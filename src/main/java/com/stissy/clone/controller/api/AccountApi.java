package com.stissy.clone.controller.api;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stissy.clone.aop.annotation.LogAspect;
import com.stissy.clone.aop.annotation.ValidAspect;
import com.stissy.clone.dto.CMRespDto;
import com.stissy.clone.dto.account.RegisterReqDto;
import com.stissy.clone.dto.validation.ValidationSequence;
import com.stissy.clone.service.account.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {	
	
	private final AccountService accountService;
	
	@LogAspect
	@ValidAspect
	@PostMapping("/register")
	public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {
		
		accountService.checkDuplicateEmail(registerReqDto.getEmail());
        accountService.register(registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "Successfully registered", registerReqDto));
	}
 
}
