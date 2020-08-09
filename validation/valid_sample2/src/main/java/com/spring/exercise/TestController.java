package com.spring.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@Inject
	RegisDAO regisDAO;
	
	@GetMapping("index")
	public String index(@RequestParam(name="errs", required=false) List<String> errs, Model model) {
		if(errs!=null) {
			model.addAttribute("errs",errs);
		}
		
		return "index";
	}
	
	@PostMapping("login")
	public String login(@Validated LoginForm lf, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<ObjectError> errs = result.getAllErrors();
			List<String> res = new ArrayList<String>();
			
			for(ObjectError e:errs) res.add(e.getDefaultMessage());
			
			model.addAttribute("errs",res);
			
			return "redirect:index";
		}
		model.addAttribute("lf",lf);
		return "login";
	}
	
	@RequestMapping("register")
	public String register(@RequestParam(name="errs", required=false) List<String> errs, Model model) {
		if(errs!=null) {
			Map<String,String> ret = new HashMap<String,String>();
			for(int i=0;i<errs.size();i+=2) {
				ret.put(errs.get(i), errs.get(i+1));
			}
			model.addAttribute("err",ret);
			System.out.println("accepts : " + errs);
		} else {
			System.out.println("errs is empty!");
		}
		
		return "register";
	}
	
	@RequestMapping(path="registerDo", method=RequestMethod.POST)
	public String registerDo(@Validated RegisterVO rv, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> res = new ArrayList<String>();
			List<ObjectError> errs = result.getAllErrors();
			
			for(ObjectError e:errs) {
				String[] errInfo = e.getDefaultMessage().split(":");
				System.out.println("errInfo[0] : "+errInfo[0]);
				System.out.println("errInfo[1] : "+errInfo[1]);
				
				res.add(errInfo[0]); res.add(errInfo[1]);
			}
			
			model.addAttribute("errs",res);
			return "redirect:register";
		} else {
			regisDAO.insertUser(rv);
			System.out.println("Insert Successfully!");
			return "redirect:index";
		}
	}
	
}
