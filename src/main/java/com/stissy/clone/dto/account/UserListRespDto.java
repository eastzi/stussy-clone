package com.stissy.clone.dto.account;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserListRespDto {
	private int id;
	private String name;
	private String userEmail;
	private LocalDateTime createDate;
	private int userTotalCount;
}
