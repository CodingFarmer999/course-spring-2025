package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.IService;

@RestController
public class AppController {

	@Autowired
	private IService service;
	
	@Value("${app.message}")
	private String message;
	
	@GetMapping("/env")
	public String home() {
		System.out.println("Service: " + service.getData());
		return "Welcome to the Spring Boot Application! " + message;
	}
}
