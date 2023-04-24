package com.stissy.clone.service.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stissy.clone.Repository.AccountRepository;
import com.stissy.clone.domain.User;
import com.stissy.clone.dto.account.RegisterReqDto;
import com.stissy.clone.dto.account.UserListRespDto;
import com.stissy.clone.exception.CustomValidationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository; 

	@Override
	public boolean checkDuplicateEmail(String email) {
		
		User user = accountRepository.findUserByEmail(email); 
		
		if(user != null) {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("duplicateFlag", "이미 가입된 이메일입니다.");
			throw new CustomValidationException("DuplicateEmail Error", errorMap);
		}
		
		return true;
	}

	@Override
	public boolean register(RegisterReqDto registerReqDto) throws Exception {
		
		User userEntity  = registerReqDto.toUserEntity();
		
		int result = accountRepository.save(userEntity);
		
		return result != 0;
	}

	@Override
	public List<UserListRespDto> getUserList(int pageNumber, String searchText) throws Exception {
		Map<String, Object> userMap = new HashMap<String, Object>();
		
		userMap.put("index", (pageNumber -1) * 10);
		userMap.put("searchText", searchText);
		
		List<UserListRespDto> list = new ArrayList<UserListRespDto>();
		
		accountRepository.getUserList(userMap).forEach(user -> {
			list.add(user.toUserListRespDto());
		});
		
		return list;
	}

}
