package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.model.Toyota;

public class JavaConfigMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.course.config");
		
		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		System.out.println("=====================");
		
		Toyota car = (Toyota) ctx.getBean("toyota");
		car.move();

	}
}
