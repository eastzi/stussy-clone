package com.stissy.clone.handler.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthFailuerHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		/*
		 * UsernameNotFoundException -> 계정없음
		 * BadCredentialsException -> 자격증명실패/아이디 혹은 비밀번호 불일치/비밀번호 불일치
		 */
		
		if(exception.getClass() == UsernameNotFoundException.class || exception.getClass() == BadCredentialsException.class) {
			response.sendRedirect("/account/login?error=auth");
		}else {
			response.sendRedirect("/account/login?error");
		}
		
	}

}
