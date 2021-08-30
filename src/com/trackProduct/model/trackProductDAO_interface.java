package com.trackProduct.model;

import java.util.List;

public interface trackProductDAO_interface {

	public void insert(trackProductVO trackProduct);
	
	public void update(trackProductVO trackProduct);
	
	public void delete(Integer gen_meb_no,Integer product_no);
	
	public trackProductVO findByPrimaryKey(Integer gen_meb_no,Integer product_no);
	
	public List<trackProductVO> getAll(); 
}
