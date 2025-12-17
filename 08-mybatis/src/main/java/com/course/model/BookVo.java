package com.course.model;

import lombok.Data;

@Data
public class BookVo {
	
	private Long id;
	
	private String name;
	
	private String author;
	
	private String buyDate;
	
	private String imgName;
}
