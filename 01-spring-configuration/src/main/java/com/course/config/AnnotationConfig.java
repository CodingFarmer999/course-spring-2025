package com.course.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.course.model.Toyota;

@Configuration
// @ComponentScan(basePackageClasses = { Toyota.class }) // 掃描 Toyota 所在套件
// @ComponentScan("com.course.model") // 掃描 com.course.model 套件
@ComponentScan(basePackages = { "com.course.model" })
public class AnnotationConfig {

}
