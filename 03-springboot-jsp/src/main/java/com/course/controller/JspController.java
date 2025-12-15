package com.course.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.course.model.Cart;
import com.course.model.Product;
import com.course.model.UserVo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JspController {

	private Logger logger = LoggerFactory.getLogger(JspController.class);
	
	@Autowired
	private Cart cart;
	
	@PostMapping("/login")
	public String loginAction(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		// 判斷登入成功與否
		return "loginSuccess";
	}
	
	@PostMapping(value = "/traditionRequest")
    public String traditionRequest(HttpServletRequest req) {
	    // 取得QueryString的參數值
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    req.setAttribute("user", username);
	    return "loginSuccess";
	}
	
	@GetMapping("/user/{id}")
	public String getUserData(@PathVariable Integer id) {
		logger.info("User Id = {}", id);
		return "loginSuccess";
	}
	
	@PostMapping("/hobby")
	public String getHobby(@ModelAttribute("hobby") UserVo userVo) {
	    logger.info(userVo.toString());
	    return "loginSuccess";
	}
	
	@ModelAttribute("company")
	public String methodModelAttribute() {
		return "佛心公司";
	}
	
	@PostMapping("/upload")
	public String uploadUser(@ModelAttribute UserVo userVo) {
		
	    System.out.println("暱稱：" + userVo.getNickname());

	    MultipartFile file = userVo.getPhoto();
	    if (!file.isEmpty()) {
	        System.out.println("檔案名稱：" + file.getOriginalFilename());
	        System.out.println("大小：" + file.getSize());

	        // 儲存檔案
	        // Path path = Paths.get("/Users/yaochilee/image/" + file.getOriginalFilename());
	        Path path = Paths.get("Users", "yaochilee", "image", file.getOriginalFilename());
	        try {
				Files.copy(file.getInputStream(), path);
			} catch (IOException e) {
				logger.error("uploadUser IOException", e);
			}
	    }
		return "loginSuccess";
		
	}
	
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam Long productId) {
		Product product = new Product();
		product.setProductId(productId);
		cart.getProducts().add(product);
		return "loginSuccess";
	}
	
	@GetMapping("/getProducts")
	public String getCart(Model model) {
		model.addAttribute("products", cart.getProducts());
		return "loginSuccess";
	}
}
