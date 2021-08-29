package com.productPhotos.model;

import java.util.List;

public interface productPhotosDAO_interface {
	
	public productPhotosVO insert(productPhotosVO productPhotos);
	
	public void update(productPhotosVO productPhotos);

	public productPhotosVO findByproductPhotosNo(Integer ADOPT_APPLY_NO);

	public List<productPhotosVO> getAllproductPhotos();

}
