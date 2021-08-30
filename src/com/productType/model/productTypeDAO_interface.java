package com.productType.model;

import java.util.List;

public interface productTypeDAO_interface {
		
	public void insert(productTypeVO productType);
	
	public void update(productTypeVO productType);
	
	public void delete(Integer product_type_no);
	
	public productTypeVO findByPrimaryKey(Integer product_type_no);
	
	public List<productTypeVO> getAll();
}
