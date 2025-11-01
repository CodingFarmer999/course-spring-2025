package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated())
			.formLogin(form -> form
				// 指定自定義的登入頁面，這裡會映射到 LoginController 的 /login 方法，並渲染 login.html 頁面
				.loginPage("/login")
				// 因為 post /login 由Spring Security 預設實作，所以不需要另外實作
				// 如果需要自定義的 URL登入請求，使用loginProcessingUrl設定Url，登入邏輯與預設的login處理相同
//				.loginProcessingUrl("/custom-login")
				.defaultSuccessUrl("/game", true)
				.permitAll()
			)
			.logout(logout -> logout
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			);
		return http.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
		.username("aaa")
		.password("a@123")
		.roles("USER")
		.build();
		
		return new InMemoryUserDetailsManager(user1);
	}
}
