package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.course.model.Bmw;

@Configuration
public class AppConfig {

	@Bean
	public Bmw bwm() {
		return new Bmw();
	}
}
