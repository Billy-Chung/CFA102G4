package com.productPhotos.model;

public class productPhotosVO {
	
	private Integer product_photo_no;
	private Integer product_no;
	private byte[] product_photo;
	
	public Integer getProduct_photo_no() {
		return product_photo_no;
	}
	public void setProduct_photo_no(Integer product_photo_no) {
		this.product_photo_no = product_photo_no;
	}
	public Integer getProduct_no() {
		return product_no;
	}
	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}
	public byte[] getProduct_photo() {
		return product_photo;
	}
	public void setProduct_photo(byte[] product_photo) {
		this.product_photo = product_photo;
	}
}
