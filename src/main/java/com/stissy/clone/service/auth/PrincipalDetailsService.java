package com.stissy.clone.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stissy.clone.Repository.AccountRepository;
import com.stissy.clone.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = null;
		
		try {
			user = accountRepository.findUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(email);
		}
		
		System.out.println("email: " + email);
		
		if(user == null) {
			log.error("아이디를 찾지 못함");
			throw new UsernameNotFoundException(email + "은 존재하지 않는 아이디 입니다.");
		}
		
		return new PrinciaplDetails(user);
	}

}
