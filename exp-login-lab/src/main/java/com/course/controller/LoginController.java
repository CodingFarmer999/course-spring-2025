package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.UserVo;
import com.course.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginAction(@RequestParam String username, @RequestParam String password) {
		boolean checkLogin = loginService.checkLogin(username, password);
		if (checkLogin) {
			return "loginSuccess";			
		} else {
			return "loginFail";
		}
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVo user) {
		return "registerSuccess";
	}

}
