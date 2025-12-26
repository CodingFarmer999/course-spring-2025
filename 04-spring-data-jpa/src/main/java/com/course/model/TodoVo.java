package com.course.model;

import lombok.Data;

@Data
public class TodoVo {

	private Integer id;
	
	private String title;
	
	private String duedate;
	
	private Integer status;
}
