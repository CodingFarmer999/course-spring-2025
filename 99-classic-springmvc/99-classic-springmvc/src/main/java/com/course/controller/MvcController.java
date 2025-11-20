package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.UsersEntity;
import com.course.service.UserService;

@Controller
public class MvcController {

    @Autowired
    private UserService userService;
    
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
	
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 檢查帳號是否存在
        UsersEntity user = userService.checkUser(username, password);

        if (user != null) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }
}
