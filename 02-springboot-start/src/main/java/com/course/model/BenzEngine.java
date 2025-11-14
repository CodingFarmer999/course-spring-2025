package com.course.model;

import org.springframework.stereotype.Component;

@Component
public class BenzEngine implements Engine {

	@Override
	public void start() {
		System.out.println("BenzEngine start...");
		
	}

}
