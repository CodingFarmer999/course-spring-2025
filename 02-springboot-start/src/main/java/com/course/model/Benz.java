package com.course.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Benz {
	
	@Autowired
	private Engine engine;
	
	public void move() {
		engine.start();
		System.out.println("Benz move");
	}
}
