package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Cart;
import com.course.model.Product;

@Service
public class ProductService {
	
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iPhone 17"));
        productList.add(new Product(2, "Switch 2"));
        productList.add(new Product(3, "PS5 Pro"));
    }
	
	@Autowired
	private Cart cart;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void addProductToCart(Integer id) {
		Product product = productList.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
		cart.getProducts().add(product);
	}

	public List<Product> getProductsInCart() {
		return cart.getProducts();
	}
	
}
