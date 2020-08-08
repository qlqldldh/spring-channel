package com.spring.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired
	GiftDAO giftDAO;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="result", method=RequestMethod.POST, params="sel")
	public String resultSel(@RequestParam String sel, Model model) {
		System.out.println("sel : " + sel);
		model.addAttribute("gifts",giftDAO.selectAll());
		model.addAttribute("res",sel);
		
		return "result";
	}
	
	@RequestMapping(path="result", method=RequestMethod.POST, params="inp") // parameter에 따라 메소드가 매핑됨을 확인
	public String resultInp(@RequestParam String inp, Model model) {
		System.out.println("sel : " + inp);
		model.addAttribute("gifts",giftDAO.selectAll());
		model.addAttribute("res",inp);
		
		return "result";
	}
	
	@RequestMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@RequestMapping("insertdo")
	public void insertDo(@ModelAttribute GiftVO gv, HttpServletResponse response) throws IOException { // @Valid를 사용해야 VO에서 걸어둔 validation이 진행됨
		PrintWriter out = response.getWriter();
		try { // giftDAO로부터 exception이 감지 되었을 때 catch문 수행
			giftDAO.insertGift(gv);
			out.print("<script>alert('Inserted Successfully!'); location.href='index';</script>");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script>alert('Fail to insert. Try Again!'); location.href='insert';</script>");
		}
	}
}
