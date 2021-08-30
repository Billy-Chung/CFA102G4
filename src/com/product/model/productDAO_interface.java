package com.product.model;

import java.util.List;

public interface productDAO_interface {
	
	public void insert(productVO product);
	
	public void update(productVO product);
	
	public void delete(Integer product_no);
	
	public productVO findByPrimaryKey(Integer product_no);
	
	public List<productVO> getAll();
}
