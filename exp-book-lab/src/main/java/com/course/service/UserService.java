package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.UserSession;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

    /**
     * 這裡注入的是「Session Proxy」
     * 實際的 UserSession 會依照目前請求的 Session 自動切換
     */
	@Autowired
	private UserSession userSession;
	
    @Autowired
    private HttpSession httpSession;
	
	public boolean login(String username, String password) {
		
		// 假裝從 DB 來的資料
		userSession.setUsername(username);
		userSession.setNickname("凱蒂貓");
		return true;
	}
	
	public String getUsernameFromSession() {
		return userSession.getUsername();
	}

	public void logout() {
//		userSession.setNickname(null);
//		userSession.setUsername(null);
		httpSession.invalidate();
	}
}
