package com.course.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.course.entity.UsersEntity;

import io.micrometer.common.util.StringUtils;

@SuppressWarnings("serial")
public class GameUserPrincipal implements UserDetails {

	private UsersEntity usersEntity;
	
	public GameUserPrincipal(UsersEntity usersEntity) {
		this.usersEntity =  usersEntity;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = StringUtils.isNotBlank(usersEntity.getRole()) ? usersEntity.getRole() : "USER";
		// 建議加上 ROLE_ 前綴，Spring Security 要求角色名稱預設要以 ROLE_ 開頭
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + role));
	}

	@Override
	public String getPassword() {
		return usersEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return usersEntity.getUsername();
	}
	
	public UsersEntity getUsersEntity() {
		return this.usersEntity;
	}
}
