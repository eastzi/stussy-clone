package com.stissy.clone.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.stissy.clone.domain.User;

@Mapper
public interface AccountRepository {
	public int save(User user);
	public User findUserByEmail(String Email);
}
