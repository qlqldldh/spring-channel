package com.test.jpa.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.jpa.service.StudentService;
import com.test.jpa.vo.StudentVO;

@Controller
public class StudentController {
	
	@Inject
	StudentService studentService;
	
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("insertPage")
	public String insertPage() {
		return "insertPage";
	}
	
	@PostMapping("updatePage")
	public String updatePage(@RequestParam int studid, Model model) {
		model.addAttribute("vo",studentService.showOneStudent(studid));
		return "updatePage";
	}
	
	@GetMapping("select")
	public String list(Model model) {
		model.addAttribute("list",studentService.showAll());
		
		return "list";
	}
	
	@PostMapping("insert")
	public String insertDo(@ModelAttribute StudentVO vo) {
		System.out.println(vo.getStudid() + " / " + vo.getStname());
		
		studentService.insertStudent(vo);
		
		return "redirect:index";
	}
	
	@GetMapping("delete")
	public String deleteDo(@RequestParam int studid) {
		studentService.deleteStudent(studid);
		
		return "redirect:select";
	}
	
	@GetMapping("update")
	public String updateDo(@ModelAttribute StudentVO vo) {
		System.out.println(vo.getStudid() + " / " + vo.getStname() + " / " + vo.getGrade());
		
		studentService.updateStudent(vo);
		
		return "redirect:select";
	}
}
