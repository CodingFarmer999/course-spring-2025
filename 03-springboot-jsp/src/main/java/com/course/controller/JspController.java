package com.course.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.UserVo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JspController {

	private Logger logger = LoggerFactory.getLogger(JspController.class);
	
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
	
	@GetMapping("/user/{id}")
	public String getUserData(@PathVariable Integer id) {
		logger.info("User Id = {}", id);
		return "loginSuccess";
	}
	
	@PostMapping("/hobby")
	public String getHobby(@ModelAttribute("hobby") UserVo userVo) {
	    logger.info(userVo.toString());
	    return "loginSuccess";
	}
	
	@ModelAttribute("company")
	public String methodModelAttribute() {
		return "佛心公司";
	}
}
