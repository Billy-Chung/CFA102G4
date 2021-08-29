package com.productType.model;

import java.util.List;

public interface productTypeDAO_interface {
		
		public productTypeVO insert(productTypeVO adoptApply);
		
		public void update(productTypeVO adoptApply);

		public productTypeVO findByproductTypeNo(Integer PRODUCT_TYPE_NO);
		
		public List<productTypeVO> getAllproductType();
}
