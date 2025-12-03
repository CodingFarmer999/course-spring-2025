package com.course.model;

import java.util.List;

import lombok.Data;

@Data
public class User {
	
	private Long id;

	private String name;
	
	private Integer age;
	
	private List<String> hobbies;
	
}
