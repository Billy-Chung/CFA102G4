package com.adoptPetPhoto.model;

import java.util.List;

public interface adoptPetPhoto_interface {
	
	public adoptPetPhotoVO insert(adoptPetPhotoVO adoptPetPhoto);
	
	public void update(adoptPetPhotoVO adoptPetPhoto);

	public List<adoptPetPhotoVO> findByadoptPetNo(Integer ADOPT_PET_NO);
	
	public List<adoptPetPhotoVO> getAlladoptPetPhoto();
}
