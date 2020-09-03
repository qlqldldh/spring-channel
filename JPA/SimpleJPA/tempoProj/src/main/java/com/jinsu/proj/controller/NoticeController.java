package com.jinsu.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinsu.proj.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="notice", method=RequestMethod.POST)
	public String notice(Model model) {
//		model.addAttribute("list",noticeDAO.selectAll());
		model.addAttribute("list",noticeService.showNotices());
		
		return "notice";
	}
	
	@RequestMapping(value="noticeDetail", method=RequestMethod.POST)
	public String noticeDetail(@RequestParam String title,Model model) {
		System.out.println(title); // log
		
//		model.addAttribute("detail",noticeDAO.selectByTemp(title));
		model.addAttribute("detail",noticeService.showNoticeByTitle(title));
		
		return "noticeDetail";
	}
}
