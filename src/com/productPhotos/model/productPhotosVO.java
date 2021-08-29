package com.productPhotos.model;

public class productPhotosVO {
	
	private Integer PRODUCT_PHOTO_NO;
	private Integer PRODUCT_NO;
	private byte[] PRODUCT_PHOTO;
	
	public Integer getPRODUCT_PHOTO_NO() {
		return PRODUCT_PHOTO_NO;
	}
	public void setPRODUCT_PHOTO_NO(Integer pRODUCT_PHOTO_NO) {
		PRODUCT_PHOTO_NO = pRODUCT_PHOTO_NO;
	}
	public Integer getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(Integer pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public byte[] getPRODUCT_PHOTO() {
		return PRODUCT_PHOTO;
	}
	public void setPRODUCT_PHOTO(byte[] pRODUCT_PHOTO) {
		PRODUCT_PHOTO = pRODUCT_PHOTO;
	}
}
