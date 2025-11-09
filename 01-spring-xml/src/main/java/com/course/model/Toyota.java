package com.course.model;

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
