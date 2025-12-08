package com.course.model;

import java.util.Date;

import lombok.Data;

@Data
public class Book {
	
	private Long id;
	
	private String name;
	
	private String author;
	
	private Date buyDate;
	
	private String imgName;
}
