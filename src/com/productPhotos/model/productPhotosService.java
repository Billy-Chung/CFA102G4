package com.productPhotos.model;

import java.util.List;

public class productPhotosService {

	private productPhotosDAO_interface dao;

	public productPhotosService() {
		dao = new productPhotosDAO();
	}

	public productPhotosVO addproductPhotos(Integer product_photo_no, Integer product_no, byte[] product_photo) {

		productPhotosVO pp = new productPhotosVO();

		pp.setProduct_photo_no(product_photo_no);
		pp.setProduct_no(product_no);
		pp.setProduct_photo(product_photo);
		dao.insert(pp);
		return pp;
	}

	public productPhotosVO updateproductPhotos(Integer product_photo_no, Integer product_no, byte[] product_photo) {

		productPhotosVO pp = new productPhotosVO();

		pp.setProduct_photo_no(product_photo_no);
		pp.setProduct_no(product_no);
		pp.setProduct_photo(product_photo);
		dao.update(pp);
		return pp;
	}

	public void deleteproductPhotos(Integer product_photo_no) {
		dao.delete(product_photo_no);
	}

	public productPhotosVO getOneproductPhotos(Integer product_photo_no) {
		return dao.findByPrimaryKey(product_photo_no);
	}

	public List<productPhotosVO> getAll() {
		return dao.getAll();
	}
}
