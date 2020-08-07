package com.spring.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired
	JdbcUserDAO jdbcUserDAO;
	
	@RequestMapping("/index")
	public String index(Model model) {
		int result = jdbcUserDAO.CountTotalUser();
		List<BuserVO> res = jdbcUserDAO.selectAll();
		
		System.out.println("result: "+result);
		model.addAttribute("users",result);
		model.addAttribute("list",res);
		
		return "index";
	}
	
	@RequestMapping("search")
	public String search(@RequestParam String email, Model model) {
		model.addAttribute("buser",jdbcUserDAO.searchByEmail(email));
		
		return "search";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute BuserVO bv, Model model) {
		System.out.println("Email : "+bv.getEmail());
		System.out.println(jdbcUserDAO.updateUser(bv));
		return "redirect:index";
	}
}
