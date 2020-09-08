package com.jinsu.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinsu.first.service.StudentService;
import com.jinsu.first.vo.StudentVO;

@RestController
public class TestRestController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("list")
	public List<StudentVO> listOfStudents(){
		List<StudentVO> ret = studentService.showAll();
		
		for(StudentVO vo:ret) {
			System.out.println("name : "+vo.getStname());
		} // for log
		
		return ret;
	}
}
