package com.stissy.clone.dto.admin;

import java.util.List;

import com.stissy.clone.domain.ProductImgFile;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductListRespDto {
	private int id;
	private String category;
	private String name;
	private int price;
	private String color;
	private String size;
	
	private String infoSimple;
	private String infoDetail;
	private String infoOption;
	private String infoManagement;
	private String infoShipping;
	
	private List<ProductImgFile> productImgFiles;
	
	private int productTotalCount;
}
