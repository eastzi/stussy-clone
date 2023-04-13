package com.stissy.clone.service.account;

import com.stissy.clone.dto.account.RegisterReqDto;

public interface AccountService {
	
	public boolean checkDuplicateEmail(String email);
	
	public boolean register(RegisterReqDto registerReqDto) throws Exception;
}
