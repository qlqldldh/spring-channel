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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(path = "result", method=RequestMethod.POST, params="inp") // parameter에 따라 메소드가 매핑됨을 확인
	public String resultInp(@RequestParam String inp, Model model) { // 그러나 POST 방식의 통신을 추구하면서 하나의 path에 params를 여럿으로 두어 mapping하는 것은 옳지 않은 것 같다
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
			giftDAO.insertGift(gv); // exception을 throw하는 메소드
			out.print("<script>alert('Inserted Successfully!'); location.href='index';</script>");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script>alert('Fail to insert. Try Again!'); location.href='insert';</script>");
		}
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam String gno, Model model) { // redirect로 post 방식으로 데이터 전송에 대한 고민
		System.out.println(giftDAO.deleteGift(gno) + " deleted"); // RedirectAttributes를 사용하면 flash된 형태의 data를 전송할 수 있으나 새로고침시 data가 사라짐
		model.addAttribute("inp",gno); // post로 보내기 위한 jsp 파일(forPostTrans.jsp)을 만들어서 위 result로 보내기 가능하나 기존에 설계를 잘하면 이런 불필요한 과정이 필요가 없을 듯
		return "forPostTrans";
	}
}
