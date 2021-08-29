package com.productPhotos.model;

import java.util.List;

public interface productPhotosDAO_interface {
	
	public void insert(productPhotosVO productPhotos);
	
	public void update(productPhotosVO productPhotos);
	
	public void delete(Integer product_photo_no);
	
	public productPhotosVO findByPrimaryKey(Integer product_photo_no);
	
	public List<productPhotosVO> getAll();

}
