package com.stissy.clone.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.stissy.clone.domain.CollectionProduct;
import com.stissy.clone.domain.ProductDetail;

@Mapper
public interface ShopRepository {
	public List<CollectionProduct> getCollectionList(Map<String, Object> map) throws Exception;
	public List<ProductDetail> getProduct(int groupId) throws Exception;
}
