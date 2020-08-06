package com.spring.exercise.autowrdWithColctn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired
	@Qualifier("numberCount")
	DataDealer dataDealer;
	
	@Autowired
	List<DataDealer<Integer>> dealerIntList;
	
	@Autowired
	Map<String,DataDealer> dealerMap;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("numcount")
	public String numcount(@RequestParam("input") String input, Model model) {
		model.addAttribute("input",input);
		model.addAttribute("count",dataDealer.deal(input));
		return "numcount";
	}
	
	
	// Error : dealerIntList가 Integer type으로 정의된 자식 클래스들만 받아질 것이라는 책의 내용과는 달리 구현된 모든 자식 클래스가 담겨옴. //
	@RequestMapping("listResult")
	public String listResult(@RequestParam String input, Model model) {
		List<Integer> ret = new ArrayList<Integer>();
		System.out.println("list's size = "+dealerIntList.size());
		for(int i=0;i<dealerIntList.size();i++) {
			System.out.println(dealerIntList.get(i).deal(input).intValue());
			ret.add(dealerIntList.get(i).deal(input).intValue());
		}
		model.addAttribute("reslist",ret);
		
		return "listResult";
	}
	
	@RequestMapping("mapResult")
	public String mapResult(@RequestParam String input, Model model) {
		model.addAttribute("numberCount",dealerMap.get("numberCount").deal(input));
		model.addAttribute("numberAdder",dealerMap.get("numberAdder").deal(input));
		model.addAttribute("sentenceEncoder",dealerMap.get("sentenceEncoder").deal(input));
		
		return "mapResult";
	}
}

