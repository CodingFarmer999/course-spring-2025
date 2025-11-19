package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.Cart;
import com.course.model.Product;

@Controller
// @RequestMapping("/api")
public class AppController {

	@RequestMapping("/")
	public String index() {
	    return "index";
	}
	
	// @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
	@GetMapping("/home")
	public String home() {
	    return "home";
	}
	
	// "?" 匹配一個字元
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home2
	@GetMapping("/pattern/home?")
	public String home1() {
	    return "home";
	}
	
	// "*" 匹配多個字元 
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home100
	@GetMapping("/pattern/home*")
	public String home2() {
	    return "home";
	}
	
	// "**" 匹配零個或多個路徑，路徑名稱任意
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home/abc
	@GetMapping("/pattern/**")
	public String home3() {
	    return "home";
	}
	
}
