package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.model.UserVo;

@Controller
public class AppController {

    private static final List<UserVo> userList = new ArrayList<>();

    static {
    	userList.add(new UserVo(1, "芙莉蓮", "111", "aaa@aaa.com"));
    	userList.add(new UserVo(2, "賽倫", "222", "bbb@bbb.com"));
    	userList.add(new UserVo(3, "星野愛", "333", "ccc@ccc.com"));
    }
	
	// 如果沒有特別需要定義，可以不用定義 "/"，會自動 Mapping 到 index.html
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@GetMapping("/app")
	public String app(Model model) {
		model.addAttribute("title", "去唱卡拉ＯＫ吧～");
		model.addAttribute("titleWithScript", "<script>alert('去唱卡拉ＯＫ吧～')</script>");
		model.addAttribute("text1", "葬送的");
		model.addAttribute("text2", "芙莉蓮");
		model.addAttribute("users", userList);
		model.addAttribute("isLogin", true);	
		model.addAttribute("username", "snoopy");
		return "app";
	}
	
	@GetMapping("/edit/{id}")
	public String toEditPage(@PathVariable Integer id, Model model) {
		
		UserVo user = userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		model.addAttribute("user", user);
		return "editPage";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute UserVo user) {
		System.out.println("User: " + user);
		return "app";
	}
	
	@GetMapping("/book/{id}")
	public String hrefPathVariable(@PathVariable Integer id) {
		System.out.println("ID: " + id);
		return "app";
	}
	
	@GetMapping("/books")
	public String hrefRequestParam(Integer page, String keyword) {
		System.out.println("Page: " + page);
		System.out.println("Keyword: " + keyword);
		return "app";
	}
}
