package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.course.model.Engine;
import com.course.model.Toyota;
import com.course.model.ToyotaEngine;

// 宣告為配置類
@Configuration
public class AppConfig {

	// 受到 Spring 管理的 Bean
	@Bean
	public Toyota toyota(Engine engine) {
		// 透過建構式將 Engine 注入 Toyota 類別
		return new Toyota(engine);
	}
	
	@Bean(name = {"benz"})
	public ToyotaEngine toyotaEngine() {
		return new ToyotaEngine();
	}
}
