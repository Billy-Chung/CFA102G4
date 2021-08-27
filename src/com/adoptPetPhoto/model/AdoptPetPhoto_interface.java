package com.adoptPetPhoto.model;

import java.util.List;

public interface AdoptPetPhoto_interface {
	
	public AdoptPetPhotoVO insert(AdoptPetPhotoVO adoptPetPhoto);
	
	public void update(AdoptPetPhotoVO adoptPetPhoto);
	
	public void delete(Integer adopt_pet_photo_no);

	public List<AdoptPetPhotoVO> findByadoptPetNo(Integer adopt_pet_no);
	
}
