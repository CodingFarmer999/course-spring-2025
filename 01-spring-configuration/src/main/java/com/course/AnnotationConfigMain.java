package com.course;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.config.AnnotationConfig;
import com.course.model.Benz;
import com.course.model.Kia;
import com.course.model.LazyBean;
import com.course.model.PrototypeBean;
import com.course.model.SingletonBean;
import com.course.model.Toyota;
import com.course.utils.SpringUtils;

public class AnnotationConfigMain {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);) {
			
			
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
			
			System.out.println("=====================");
			
			SingletonBean s1 = ctx.getBean(SingletonBean.class);
			System.out.println("SingletonBean-1: " + s1);
			
			SingletonBean s2 = ctx.getBean(SingletonBean.class);
			System.out.println("SingletonBean-2: " + s2);
			
			PrototypeBean p1 = ctx.getBean(PrototypeBean.class);
			System.out.println("PrototypeBean-1: " + p1);
			
			PrototypeBean p2 = ctx.getBean(PrototypeBean.class);
			System.out.println("PrototypeBean-2: " + p2);
			
			System.out.println("=====================");
			
			LazyBean lazy = ctx.getBean(LazyBean.class);
			
			
			System.out.println("=====================");
			
			SpringUtils utils = SpringUtils.getInstance();
			utils.doSomething();
			
			SpringUtils utils2 = SpringUtils.getInstance();
			utils2.doSomething();
		}
		
	}

}
