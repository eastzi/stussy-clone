package com.stissy.clone.service.account;

import java.util.List;

import com.stissy.clone.dto.account.RegisterReqDto;
import com.stissy.clone.dto.account.UserListRespDto;

public interface AccountService {
	public boolean checkDuplicateEmail(String email);
	public boolean register(RegisterReqDto registerReqDto) throws Exception;
	public List<UserListRespDto> getUserList(int pageNumber, String searchText) throws Exception;
}
