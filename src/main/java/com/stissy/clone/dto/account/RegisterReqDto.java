package com.stissy.clone.dto.account;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stissy.clone.domain.User;
import com.stissy.clone.dto.validation.ValidationGroups;

import lombok.Data;

@Data
public class RegisterReqDto {
	
	@NotBlank(message = "이름은 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 1, max = 3, 
		message = "이름은 한글자에서 세글자 사이입니다.",
		groups = ValidationGroups.SizeCheckGroup.class)
	@Pattern(regexp = "^[가-힇]{1,3}$", 
			message = "이름은 한글만 입력가능합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
	private String lastName;
	
	@NotBlank(message = "성은 비워둘 수 없습니다.", 
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 1, max = 2, 
		message = "성은 한글자에서 두글자 사이입니다.", 
		groups = ValidationGroups.SizeCheckGroup.class)
	@Pattern(regexp = "^[가-힇]{1,2}$", 
			message = "성은 한글만 입력가능합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
    private String firstName;
	
	@Email
	@NotBlank(message = "이메일은 비워둘 수 없음", 
			groups = ValidationGroups.NotBlankGroup.class)
    private String email;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
			message = "비밀번호는 숫자, 영문(대소문자), 특수기호를 하나 이상 포함해야합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
	@NotBlank(message = "비밀번호는 비워둘 수 없음",
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 8, max = 16, 
		message = "비밀번호는 8자리에서 16자리 사이입니다.", 
		groups = ValidationGroups.SizeCheckGroup.class)
    private String password;
	
	
	//dto -> entity (DB 등록용)
	public User toUserEntity() {
        return User.builder()
                .username(email)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(firstName + lastName)
                .email(email)
                .role_id(1)
                .build();
    }
}
