package com.course.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean checkLogin(String username, String password) {
		if (username.equals("aaa") && password.equals("1111")) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
