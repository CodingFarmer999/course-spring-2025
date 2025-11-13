package com.course.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {

	private ToyotaEngine engine;
	
	public LifeCycleBean() {
		System.out.println("1. 我是建構式");
	}
	
	@Autowired
	public void setEngine(ToyotaEngine engine) {
		System.out.println("1.1 我是Setter");
		this.engine = engine;
	}

	@PostConstruct
	public void init() {
		System.out.println("2. @PostConstruct");
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("3. @PreDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("2.1. afterPropertiesSet");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("3.1 destroy");
	}
}
