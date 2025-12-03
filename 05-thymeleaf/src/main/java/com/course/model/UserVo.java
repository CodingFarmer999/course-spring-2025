package com.course.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
	
	private Integer id;
	
	private String username;
	
	private String password;
	
    private String email;
    
    private MultipartFile photo;
    
	public UserVo(Integer id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
