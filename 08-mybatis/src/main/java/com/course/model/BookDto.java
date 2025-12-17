package com.course.model;

import java.util.Date;

import lombok.Data;

@Data
public class BookDto {

	private Long id;

	private String name;

	private String author;
	
	private Date buyDate;
	
	private String imgName;
	
	// TABLE: STORE 欄位
	private String storeName;
	
	// TABLE: INVENTORY 欄位
	private Integer quantity;
}
