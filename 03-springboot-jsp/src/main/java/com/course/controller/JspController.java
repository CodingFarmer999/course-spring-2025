package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JspController {

	@PostMapping("/login")
	public String loginAction(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		// 判斷登入成功與否
		return "loginSuccess";
	}
	
	@PostMapping(value = "/traditionRequest")
    public String traditionRequest(HttpServletRequest req) {
	    // 取得QueryString的參數值
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    req.setAttribute("user", username);
	    return "loginSuccess";
	}
}
