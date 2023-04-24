package com.stissy.clone.domain;

import java.time.LocalDateTime;

import com.stissy.clone.dto.account.UserListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String provider;
	private int role_id;
	private Role role;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	private int user_total_count;
	
	public UserListRespDto toUserListRespDto() {
		return UserListRespDto.builder()
				.id(id)
				.name(name)
				.userEmail(email)
				.createDate(create_date)
				.userTotalCount(user_total_count)
				.build();
	}
}
