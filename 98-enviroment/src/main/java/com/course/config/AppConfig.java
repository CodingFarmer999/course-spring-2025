package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

	@Bean
	@Profile("dev")
	public String devBean() {
		return "DEV Bean!";
	}
	
	@Bean
	@Profile("uat")
	public String uatBean() {
		return "UAT Bean!";
	}
}
