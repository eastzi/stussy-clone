package com.stissy.clone.service.admin;

import java.util.List;

import com.stissy.clone.domain.Product;
import com.stissy.clone.dto.admin.ProductAdditionReqDto;
import com.stissy.clone.dto.admin.ProductListRespDto;
import com.stissy.clone.dto.admin.ProductModificationReqDto;

public interface ProductService {
	public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
	public List<ProductListRespDto> getProductList(int pageNumber, String category, String searchText) throws Exception; 
	public boolean updateProduct(ProductModificationReqDto productModificationReqDto) throws Exception;
	public boolean deleteProduct(int productId) throws Exception;
}
