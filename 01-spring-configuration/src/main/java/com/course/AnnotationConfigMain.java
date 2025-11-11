package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.config.AnnotationConfig;

public class AnnotationConfigMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		System.out.println("=====================");
		
	}

}
