package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.config.AnnotationConfig;
import com.course.model.Benz;
import com.course.model.Kia;
import com.course.model.Toyota;

public class AnnotationConfigMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		System.out.println("=====================");
		
		Toyota car = (Toyota) ctx.getBean("toyota");
		car.move();
		
		Kia kia = ctx.getBean(Kia.class);
		kia.move();
		
		Benz benz = ctx.getBean(Benz.class);
		benz.move();
	}

}
