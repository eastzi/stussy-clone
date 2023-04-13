package com.stissy.clone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stissy.clone.handler.auth.AuthFailuerHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //토큰관련->jwt로 대체
		http.httpBasic().disable();
		http.authorizeRequests()
			
			/* <<<<<<<<<<<<<<< page >>>>>>>>>>>>>>> */
			.antMatchers("/admin/**", "/api/admin/**")
	        .access("hasRole('ADMIN') or hasRole('MANAGER')")
	        .antMatchers("/account ", "/order/**") //해당 요청 주소들은
	        .access("hasRole('USER') or hasRole('ADMIN') or hasRole('MANAGER')")
	
	        .antMatchers("/", "/index", "/collections/**")
	        .permitAll()
	        .antMatchers("/account/login", "/account/register")
	        .permitAll()
			
			/* <<<<<<<<<<<<<<< resources >>>>>>>>>>>>>>> */
            .antMatchers("/static/**", "/image/**")
            .permitAll()
            
            .antMatchers("/api/account/register", "/api/collections/**")
            .permitAll()
            
            .anyRequest() 
            .permitAll()
	
			.and()
			.formLogin()
			.usernameParameter("email")
			.loginPage("/account/login")
			.loginProcessingUrl("/account/login")
			.failureHandler(new AuthFailuerHandler())
			.defaultSuccessUrl("/");      // 로그인 페이지 입장 후 로그인 성공시 돌아갈 페이지
	}
}
