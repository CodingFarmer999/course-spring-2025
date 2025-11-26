package com.course.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BookVo {

	private Long id;
	
	private String name;
	
	private String author;
	
	private String buyDate;
	
	private MultipartFile file;
}
