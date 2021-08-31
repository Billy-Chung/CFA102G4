package com.product.model;

import java.util.List;

public class productService {

	private productDAO_interface dao;

	public productService() {
		dao = new productDAO();
	}

	public productVO addproduct(Integer product_no, Integer product_type_no, String product_name, Integer product_price, String product_comment, String product_status, Integer product_all_stars, Integer product_all_comments) {

		productVO p = new productVO();

		p.setProduct_no(product_no);
		p.setProduct_type_no(product_type_no);
		p.setProduct_name(product_name);
		p.setProduct_price(product_price);
		p.setProduct_comment(product_comment);
		p.setProduct_status(product_status);
		p.setProduct_all_stars(product_all_stars);
		p.setProduct_all_comments(product_all_comments);
		dao.insert(p);
		return p;
	}

	public productVO updateproduct(Integer product_no, Integer product_type_no, String product_name, Integer product_price, String product_comment, String product_status, Integer product_all_stars, Integer product_all_comments) {

		productVO p = new productVO();

		p.setProduct_no(product_no);
		p.setProduct_type_no(product_type_no);
		p.setProduct_name(product_name);
		p.setProduct_price(product_price);
		p.setProduct_comment(product_comment);
		p.setProduct_status(product_status);
		p.setProduct_all_stars(product_all_stars);
		p.setProduct_all_comments(product_all_comments);
		dao.update(p);
		return p;
	}

	public void deleteproduct(Integer product_no) {
		dao.delete(product_no);
	}

	public productVO getOneproduct(Integer product_no) {
		return dao.findByPrimaryKey(product_no);
	}

	public List<productVO> getAll() {
		return dao.getAll();
	}
}
