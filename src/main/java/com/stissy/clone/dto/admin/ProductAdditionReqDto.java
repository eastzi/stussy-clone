package com.stissy.clone.dto.admin;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.stissy.clone.domain.Product;
import com.stissy.clone.dto.validation.ValidationGroups;

import lombok.Data;

@Data
public class ProductAdditionReqDto {
	
	@NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String category;
	
	@NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String name;
	
	@Max(value = 1000000, message = "최대 금액은 100만원 입니다.")
	@Min(value = 100, message = "최소 금액은 100원 입니다.")
	private int price;
	
	@NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String color;
	
	@NotBlank(message = "빈 값일 수 없스니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String size;
	
	private String infoSimple;
	private String infoDetail;
	private String infoOption;
	private String infoManagement;
	private String infoShipping;
	
	private List<MultipartFile> files;
	
	//dto -> entity(db 등록용)
	public Product toProductEntity() {
		return Product.builder()
				.category(category)
				.name(name)
				.price(price)
				.color(color)
				.size(size)
				.info_simple(infoSimple)
				.info_detail(infoDetail)
				.info_option(infoOption)
				.info_management(infoManagement)
				.info_shipping(infoShipping)
				.build();
	}
}
