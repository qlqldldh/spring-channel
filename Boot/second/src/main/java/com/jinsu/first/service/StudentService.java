package com.jinsu.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinsu.first.repos.StudentRepository;
import com.jinsu.first.vo.StudentVO;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<StudentVO> showAll(){
		return studentRepository.findAll();
	}
}
