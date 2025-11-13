package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

	// URL: http://localhost:8080/99-classic-springmvc/hello
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "佛殺凱蒂貓");
		return "hello";
	}
	
	@GetMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		return "registerSuccess";
	}
}
