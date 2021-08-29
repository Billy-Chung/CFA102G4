package com.trackProduct.model;

import java.util.List;

public interface trackProductDAO_interface {

	public trackProductVO insert(trackProductVO trackProduct);
	
	public void update(trackProductVO trackProduct);

	public trackProductVO findBytrackProductNo(Integer GEN_MEB_NO, Integer PRODUCT_NO);

	public List<trackProductVO> getAlltrackProduct();
	
}
