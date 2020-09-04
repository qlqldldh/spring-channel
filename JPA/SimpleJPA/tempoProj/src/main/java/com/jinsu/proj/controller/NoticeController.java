package com.jinsu.proj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinsu.proj.service.NoticeService;
import com.jinsu.proj.vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("writeNotice")
	public String goWriteNotice(@RequestParam(required=false) Map<String,String> errs, Model model) {
		if(!errs.isEmpty()) { // make REST API for validation may be more efficient
			model.addAttribute("username",errs.get("username"));
			model.addAttribute("title",errs.get("title"));
		}
		
		return "writeNotice";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String notice(Model model) {
		model.addAttribute("list",noticeService.showNotices());
		
		return "notice";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.POST)
	public String noticeDetail(@RequestParam String title,Model model) {
		System.out.println(title); // log
		
		model.addAttribute("detail",noticeService.showNoticeByTitle(title));
		
		return "noticeDetail";
	}
	
	@PostMapping("write")
	public String writeNotice(@Validated NoticeVO nv, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<ObjectError> errs = result.getAllErrors();
			
			for(ObjectError err:errs) {
				String[] erInfo = err.getDefaultMessage().split(":");
				
				model.addAttribute(erInfo[0],erInfo[1]);
			}

			return "redirect:writeNotice";
		} 
		noticeService.regisNewNotice(nv);
		
		return "redirect:index";
	}
	
	@GetMapping("delete")
	public String deleteNotice(@RequestParam String title) {
		noticeService.deleteNotice(title);
		
		return "redirect:list";
	}
	
	@GetMapping("updateNotice")
	public String goUdpateNotice(@RequestParam String title, Model model) {
		String contents = noticeService.showNoticeByTitle(title).getNcontents();
		
		model.addAttribute("title",title);
		model.addAttribute("content",contents);
		
		return "noticeUpdate";
	}
	
	@PostMapping("update")
	public String updateNotice(@ModelAttribute NoticeVO vo) {
		noticeService.updateNotice(vo.getTitle(), vo.getNcontents());
		
		return "redirect:list";
	}
}
