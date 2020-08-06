package com.spring.exercise.annotConfig;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Inject
	ACounter aCounter;
	
	@Autowired
	private SentenceAnalysis sentenceAnalysis;
	
	@RequestMapping("start")
	public String goTest() {
		return "index";
	}
	
	@RequestMapping("end")
	public String printTest(@RequestParam String str, Model model) {
		if(aCounter.countAChar(str)>3) model.addAttribute("stats","a is counted more than 4 times");
		else model.addAttribute("stats","a is counted less than 4 times");
		return "finish";
	}
	
	@RequestMapping("strTest")
	public String strTest(@RequestParam String sent, Model model) {
		model.addAttribute("result",sentenceAnalysis.getSubject(sent));
		return "result";
	}
}
