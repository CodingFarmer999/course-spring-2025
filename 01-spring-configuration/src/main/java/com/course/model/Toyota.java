package com.course.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component(value = "kia") // 調整元件名稱
@Component
public class Toyota {
	
	private Engine engine;
	
	// @Autowired // 可省略
	public Toyota(@Qualifier("kiaEngine") Engine engine) {
		this.engine = engine;
	}

	public void move() {
		
		engine.start();
		
		System.out.println("Toyota move!");
	}
}
