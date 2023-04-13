package com.stissy.clone.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stissy.clone.dto.CMRespDto;
import com.stissy.clone.exception.CustomInternalServerErrorException;
import com.stissy.clone.exception.CustomValidationException;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<?> validationErrorException(CustomValidationException e) {
		return ResponseEntity.badRequest().body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
	}
	
	@ExceptionHandler(CustomInternalServerErrorException.class)
	public ResponseEntity<?> internalServerErrorException(CustomValidationException e) {
		return ResponseEntity
				.internalServerError()
				.body(new CMRespDto<>(-1, e.getMessage(), null));
	}
}
