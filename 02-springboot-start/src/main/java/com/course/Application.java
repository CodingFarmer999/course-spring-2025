package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.course.model.Benz;
import com.course.model.Bmw;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Benz benz = ctx.getBean(Benz.class);
		benz.move();
		
		Bmw bmw = ctx.getBean(Bmw.class);
		bmw.move();
	}

}
