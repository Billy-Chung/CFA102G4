package com.trackProduct.model;

import java.util.List;

public class trackProductService {

	private trackProductDAO_interface dao;

	public trackProductService() {
		dao = new trackProductDAO();
	}

	public trackProductVO addtrackProduct(Integer gen_meb_no, Integer product_no) {

		trackProductVO tp = new trackProductVO();

		tp.setGen_meb_no(gen_meb_no);
		tp.setProduct_no(product_no);
		dao.insert(tp);
		return tp;
	}

	public trackProductVO updatetrackProduct(Integer gen_meb_no, Integer product_no) {

		trackProductVO tp = new trackProductVO();

		tp.setGen_meb_no(gen_meb_no);
		tp.setProduct_no(product_no);
		dao.update(tp);
		return tp;
	}

	public void deletetrackProduct(Integer gen_meb_no, Integer product_no) {
		dao.delete(gen_meb_no, product_no);
	}

	public trackProductVO getOnetrackProduct(Integer gen_meb_no, Integer product_no) {
		return dao.findByPrimaryKey(gen_meb_no, product_no);
	}

	public List<trackProductVO> getAll() {
		return dao.getAll();
	}
}
