package com.product.model;

import java.util.List;

public interface productDAO_interface {
	
	public productVO insert(productVO product);
	
	public void update(productVO product);

	public productVO findByproductNo(Integer PRODUCT_NO);

	public List<productVO> getAllproduct();

}
