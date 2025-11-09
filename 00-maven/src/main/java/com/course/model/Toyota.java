package com.course.model;

public class Toyota {

	public void move() {
		ToyotaEngine engine = new ToyotaEngine();
		engine.start();
		
		System.out.println("Toyota move!");
	}
}
