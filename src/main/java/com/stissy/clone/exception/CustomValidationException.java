package com.stissy.clone.exception;

import java.util.Map;

import lombok.Data;

@Data
public class CustomValidationException extends RuntimeException {
	
	private Map<String, String> errorMap;
	
	public CustomValidationException(String message, Map<String, String> errorMap) {
		super(message);
		this.errorMap = errorMap;
	}

}
