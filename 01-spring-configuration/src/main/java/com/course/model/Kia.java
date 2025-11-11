package com.course.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kia {

	private Engine engine;
	
	@Autowired // 不可省略
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void move() {
		
		engine.start();
		
		System.out.println("Kia move!");
	}
}
