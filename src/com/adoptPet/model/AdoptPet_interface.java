package com.adoptPet.model;

import java.util.List;

public interface AdoptPet_interface {
	
	public AdoptPetVO insert(AdoptPetVO adoptPet);
	
	public void update(AdoptPetVO adoptPet);
	
	public AdoptPetVO findByAdoptPetNoPK(Integer adopt_pet_no);
	
	public List<AdoptPetVO> findByAdoptMebNo(Integer adopt_meb_no);
	
	public List<AdoptPetVO> getAllAdoptPet();
}
