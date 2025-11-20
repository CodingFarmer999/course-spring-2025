package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UsersDao;
import com.course.entity.UsersEntity;

@Service
public class UserService {
	
    @Autowired
    private UsersDao usersDao; 
    
    /**
     * 檢查登入邏輯
     * @param username
     * @param password
     * @return
     */
    public UsersEntity checkUser(String username, String password) {
    	UsersEntity user = usersDao.findByUsername(username);

        // 檢查帳號是否存在
        if (user != null) {
            // 檢查密碼是否正確
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
