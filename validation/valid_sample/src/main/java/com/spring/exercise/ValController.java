package com.spring.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ValController {
	@Autowired
	GiftDAO giftDAO;
	
	@RequestMapping(path="insertdo2", method=RequestMethod.POST)
	public void insertDo2(@Valid GiftVO gv, BindingResult br, HttpServletResponse response) 
			throws IOException{
		PrintWriter out = response.getWriter();
		if(br.hasErrors()) { // gv에 걸어둔 validation annotaion을 검사하여 에러가 있으면 아래의 코드가 실행됨
			System.out.println("not enough inputs for GiftVO");
			out.print("<script>alert('Fail to Insert. Try Again!'); location.href='insert';</script>");
		} else {
			giftDAO.insertGift2(gv); // exception을 throw 하지 않는 메소드
			out.print("<script>alert('Inserted Successfully!'); location.href='index';</script>");
		}
	}
}
