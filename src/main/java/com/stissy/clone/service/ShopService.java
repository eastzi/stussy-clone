package com.stissy.clone.service;

import java.util.List;

import com.stissy.clone.dto.shop.CollectionListRespDto;
import com.stissy.clone.dto.shop.ProductDetailRespDto;

public interface ShopService {
	public List<CollectionListRespDto> getCollections(String category, int page) throws Exception;
	public ProductDetailRespDto getProductDetails(int groupId) throws Exception; 
}
