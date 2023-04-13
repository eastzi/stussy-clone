package com.stissy.clone.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stissy.clone.aop.annotation.LogAspect;
import com.stissy.clone.dto.order.OrderReqDto;
import com.stissy.clone.service.auth.PrinciaplDetails;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@LogAspect
	@GetMapping("")
	public String loadOrder(Model model, OrderReqDto orderReqDto, @AuthenticationPrincipal PrinciaplDetails princiaplDetails) {
		model.addAttribute("order", orderReqDto);
		model.addAttribute("principalUser", princiaplDetails.getUser());
		return "order/order";
	}
}
