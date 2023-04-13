package com.stissy.clone.controller.admin.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stissy.clone.aop.annotation.LogAspect;
import com.stissy.clone.aop.annotation.ValidAspect;
import com.stissy.clone.dto.CMRespDto;
import com.stissy.clone.dto.admin.ProductAdditionReqDto;
import com.stissy.clone.dto.admin.ProductModificationReqDto;
import com.stissy.clone.dto.validation.ValidationSequence;
import com.stissy.clone.service.admin.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class ProductApi {
	
	private final ProductService productService;

	@ValidAspect
	@LogAspect
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) throws Exception {
		
		return ResponseEntity.created(null).body(new CMRespDto<>(1, "AddSuccessfully", productService.addProduct(productAdditionReqDto)));
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getProductList(@RequestParam int page, @RequestParam @Nullable String category, @RequestParam @Nullable String searchValue) throws Exception {
		
		return ResponseEntity.ok(new CMRespDto<>(1, "GetSuccessfully", productService.getProductList(page, category, searchValue)));
	}
	
	@LogAspect
	@ValidAspect
	@PostMapping("/product/modification")
	public ResponseEntity<?> updateProduct(@Valid ProductModificationReqDto productModificationReqDto, BindingResult bindingResult) throws Exception {
		
		return ResponseEntity.ok(new CMRespDto<>(1, "UpdateSuccessfully", productService.updateProduct(productModificationReqDto)));
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws Exception {
		return ResponseEntity.ok(new CMRespDto<>(1, "DeleteSuccessfully", productService.deleteProduct(productId)));
	}
	
}
