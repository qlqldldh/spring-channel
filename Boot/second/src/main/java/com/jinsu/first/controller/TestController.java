package com.jinsu.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinsu.first.service.StudentService;

@Controller
public class TestController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		model.addAttribute("test","from JinsuPark");
		
		model.addAttribute("cds","<font color='red'>Hello!</font>");
		
		model.addAttribute("usr","admin");
		
		model.addAttribute("my","jinsu");
		
		model.addAttribute("students",studentService.showAll());
		
		return "index";
	}
	
	@RequestMapping("move")
	public String movingPage() {
		return "result";
	}

}
