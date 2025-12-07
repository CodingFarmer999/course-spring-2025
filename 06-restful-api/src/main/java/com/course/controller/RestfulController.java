package com.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.ApiResponse;
import com.course.model.User;
import com.course.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
//@CrossOrigin("*")
public class RestfulController {
	
	@Autowired
	private UserService userService;

	@Operation(tags = "我是標籤", summary = "第一個RESTful API", description = "毫無反應就是個描述")
	@GetMapping("/hello")
	public String hello() {
		return "Hello RESTful";
	}
	
	@Operation(summary = "取得使用者", description = "取得使用者詳細資料", tags = "使用者")
    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setName("凱蒂貓");
        user.setAge(5);
        user.setHobbies(Arrays.asList("吃飯", "睡覺", "打東東"));
        return user;
    }
	
	@Operation(summary = "取得所有使用者", description = "取得所有使用者", tags = "使用者")
	@GetMapping("/users")
	// @CrossOrigin(origins = "http://127.0.0.1:5500", methods = {RequestMethod.GET})
	public List<User> getAllUsers() {
		return userService.queryAllUsers();
	}
	
	@Operation(summary = "新增使用者", description = "新增使用者", tags = "使用者")
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return user;
	}
	
	@Operation(summary = "新增使用者，使用 RequestParam", description = "新增使用者", tags = "使用者")
	@PostMapping("/user/requestparam")
	public User addUserRequestParam(User user) {
		return user;
	}
	
	@Operation(summary = "修改使用者", description = "修改使用者", tags = "使用者")
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return user;
	}
	
	@Operation(summary = "刪除使用者", description = "刪除使用者", tags = "使用者")
	@DeleteMapping("/user")
	public User deleteUser(@RequestBody User user) {
		return user;
	}
	
	@Operation(summary = "取得使用者-回傳ResponseEntity", description = "取得使用者詳細資料", tags = "使用者")
	@GetMapping("/user/responseEntity")
	public ResponseEntity<List<User>> getUsersResponseEntity() {
		List<User> users = userService.queryAllUsers();
		// return ResponseEntity.ok(users);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(users);
	}
	
	@Operation(summary = "取得使用者-自定義 ApiResponse", description = "取得使用者詳細資料", tags = "使用者")
	@GetMapping("/user/wrap")
	public ApiResponse<List<User>> getUsersWrapWithApiResponse() {
		List<User> users = userService.queryAllUsers();
		// return ApiResponse.success(users);
		return ApiResponse.error("401", "我也不知道發生什麼錯", users);
	}
}
