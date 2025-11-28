package com.course.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookVo {

	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String author;
	
	private String buyDate;
	
	private String imgName;
	
	private MultipartFile file;
}
