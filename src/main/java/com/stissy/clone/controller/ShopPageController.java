package com.stissy.clone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopPageController {

	@GetMapping("/collections/{category}") 
	public String loadCollections(@PathVariable String category) {
		return "shop/collections";
	}
	
	@GetMapping("/products/{groupId}")
	public String loadProductDetail(@PathVariable String groupId) {
		return "shop/product";
	}
}
