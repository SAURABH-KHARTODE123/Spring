package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService lservice;
	
	
	@GetMapping("/")
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String uname, @RequestParam String pass, HttpSession session) {
			MyUser u = lservice.validateUser(uname,pass);
			if(u!=null) {
				session.setAttribute("user",u);
				return new ModelAndView("redirect:/employee/getemployee");
			}
			return new ModelAndView("login");
	}
	
	
}
