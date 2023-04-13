package com.stissy.clone.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImgFile {
	private int id;
	private int product_id;
	private String origin_name;
	private String temp_name;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
