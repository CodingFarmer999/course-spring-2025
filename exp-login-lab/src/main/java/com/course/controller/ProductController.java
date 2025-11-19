package com.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.course.model.Product;
import com.course.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public String productList(Model model) {
		List<Product> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		return "products";
	}
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Integer id) {
		productService.addProductToCart(id);
		return "redirect:/product";
	}
	
	@GetMapping("/cart")
	public String getCart(Model model) {
		List<Product> productsInCart = productService.getProductsInCart();
		model.addAttribute("productList", productsInCart);
		return "cart";
	}
}
