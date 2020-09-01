package com.jinsu.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinsu.proj.dao.NoticeDAO;

@Controller
public class NoticeController {
	@Autowired
	NoticeDAO noticeDAO;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="notice", method=RequestMethod.POST)
	public String notice(Model model) {
		
		model.addAttribute("list",noticeDAO.selectAll());
		
		return "notice";
	}
}
