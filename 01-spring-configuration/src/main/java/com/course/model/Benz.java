package com.course.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class Benz {

//	@Autowired
//	@Qualifier("kiaEngine")
	@Resource(name = "kiaEngine")
	private Engine engine;
	
	public void move() {
		
		engine.start();
		
		System.out.println("Benz move!");
	}
}
