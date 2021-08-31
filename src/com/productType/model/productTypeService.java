package com.productType.model;

import java.util.List;

public class productTypeService {
	
	private productTypeDAO_interface dao;

	public productTypeService() {
		dao = new productTypeDAO();
	}

	public productTypeVO addproductType(Integer product_type_no, String product_type_name) {

		productTypeVO pt = new productTypeVO();

		pt.setProduct_type_no(product_type_no);
		pt.setProduct_type_name(product_type_name);
		dao.insert(pt);
		return pt;
	}

	public productTypeVO updateproductType(Integer product_type_no, String product_type_name) {

		productTypeVO pt = new productTypeVO();

		pt.setProduct_type_no(product_type_no);
		pt.setProduct_type_name(product_type_name);
		dao.update(pt);
		return pt;
	}

	public void deleteproductType(Integer product_type_no) {
		dao.delete(product_type_no);
	}

	public productTypeVO getOneproductType(Integer product_type_no) {
		return dao.findByPrimaryKey(product_type_no);
	}

	public List<productTypeVO> getAll() {
		return dao.getAll();
	}
}
