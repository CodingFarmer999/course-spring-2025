package com.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.course.model.Benz;
import com.course.model.Bmw;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		
		Benz benz = ctx.getBean(Benz.class);
		benz.move();
		
		Bmw bmw = ctx.getBean(Bmw.class);
		bmw.move();
		
		logger.trace("我是 trace");
		logger.debug("我是 debug");
		logger.info("我是 info");
		logger.warn("我是 warn");
		logger.error("我是 error {}", "凱蒂貓");
	}

}
