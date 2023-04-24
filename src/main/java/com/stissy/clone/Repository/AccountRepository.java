package com.stissy.clone.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.stissy.clone.domain.User;

@Mapper
public interface AccountRepository {
	public int save(User user);
	public User findUserByEmail(String Email);
	public List<User> getUserList(Map<String, Object> map) throws Exception;
}
