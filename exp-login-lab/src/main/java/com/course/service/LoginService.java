package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.UserEntity;
import com.course.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	public boolean checkLogin(String username, String password) {
		UserEntity user = userRepository.findByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
