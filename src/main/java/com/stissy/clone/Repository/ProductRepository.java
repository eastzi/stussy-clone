package com.stissy.clone.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.stissy.clone.domain.Product;
import com.stissy.clone.domain.ProductImgFile;

@Mapper
public interface ProductRepository {
	public int saveProduct(Product product) throws Exception;
	public int saveImgFiles(List<ProductImgFile> product_img_files) throws Exception;
	public List<Product> getProductList(Map<String, Object> map) throws Exception;
	public int setProduct(Product product) throws Exception;
	public int deleteImgFiles(Map<String, Object> map) throws Exception;
	public List<ProductImgFile> getProductImgList(int productId) throws Exception;
	public int deleteProduct(int productId) throws Exception;
}
