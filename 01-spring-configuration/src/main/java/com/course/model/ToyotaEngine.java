package com.course.model;

import org.springframework.stereotype.Component;

@Component
public class ToyotaEngine implements Engine {

	public void start() {
		System.out.println("ToyotaEngine Start...");
	}
}
