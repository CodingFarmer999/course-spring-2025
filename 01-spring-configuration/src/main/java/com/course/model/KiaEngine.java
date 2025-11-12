package com.course.model;

import org.springframework.stereotype.Component;

@Component
// @Primary
public class KiaEngine implements Engine {

	public void start() {
		System.out.println("KiaEngine Start...");
	}
}
