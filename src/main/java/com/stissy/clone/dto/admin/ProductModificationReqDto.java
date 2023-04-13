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
public class ProductModificationReqDto {
	
	@Min(value = 0, message = "상품 코드는 음수일 수 없음")
	private int id;
	@Max(value = 1000000, message = "최대 금액은 100만원까지 설정 가능")
	@Min(value = 100, message = "최소 금액은 100원")
	private int price;
	@NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String color;
	@NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
	private String size;
	
	private String infoSimple;
	private String infoDetail;
	private String infoOption;
	private String infoManageMent;
	private String infoShipping;
	
	private List<String> deleteImgFiles;
	private List<MultipartFile> files;
	
	public Product toProductEntity() {
		return Product.builder()
				.id(id)
				.price(price)
				.color(color)
				.size(size)
				.info_simple(infoSimple)
				.info_detail(infoDetail)
				.info_option(infoOption)
				.info_management(infoManageMent)
				.info_shipping(infoShipping)
				.build();
	}
}
