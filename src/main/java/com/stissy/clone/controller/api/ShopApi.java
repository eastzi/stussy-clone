package com.stissy.clone.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stissy.clone.dto.CMRespDto;
import com.stissy.clone.service.ShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShopApi {

	private final ShopService shopService;
	
	@GetMapping("/collections/{category}")
	public ResponseEntity<?> getCollection(@PathVariable String category, int page) throws Exception {
		return ResponseEntity.ok(new CMRespDto<>(1, "Load Successfully", shopService.getCollections(category, page)));
	}
	
	@GetMapping("/products/{groupId}")
	public ResponseEntity<?> getProduct(@PathVariable int groupId) throws Exception {
		return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", shopService.getProductDetails(groupId)));
	}
	
}
