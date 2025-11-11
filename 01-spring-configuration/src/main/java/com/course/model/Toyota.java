package com.course.model;

import org.springframework.stereotype.Component;

// @Component(value = "kia") // 調整元件名稱
@Component
public class Toyota {
	
	Engine engine;
	
	public Toyota(Engine engine) {
		this.engine = engine;
	}

	public void move() {
		
		engine.start();
		
		System.out.println("Toyota move!");
	}
}
