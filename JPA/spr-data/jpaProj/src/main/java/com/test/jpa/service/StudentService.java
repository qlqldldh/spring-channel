package com.test.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.jpa.repos.StudentRepos;
import com.test.jpa.vo.StudentVO;

@Service
public class StudentService {
	
	@Autowired
	StudentRepos studentRepos;
	
	@Transactional
	public List<StudentVO> showAll(){ // select
		return studentRepos.findAll();
	}
	
	@Transactional
	public void insertStudent(StudentVO vo) { // insert
		studentRepos.save(vo);
	}
	
	@Transactional
	public void deleteStudent(int studid) { // delete
		studentRepos.deleteById(studid);
	}
	
	@Transactional
	public void updateStudent(StudentVO vo) { // update
		StudentVO st = studentRepos.findById(vo.getStudid()).get();
		st.setStname(vo.getStname());
		st.setGrade(vo.getGrade());
		st.setStgroup(vo.getStgroup());
	}
	
	@Transactional
	public StudentVO showOneStudent(int studid) { // JPQL
		return studentRepos.selectStudByID(studid);
	}
}
