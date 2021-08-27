package com.petClassList.model;

import java.util.List;

public interface PetClassList_interface {
	
	public PetClassListVO insert(PetClassListVO petClassList);	
	
	public void delete(Integer pet_class_list_no);
	
	public List<PetClassListVO> findByAdoptPetNo(Integer adopt_pat_no);	
	
	public List<PetClassListVO> findByPetClassNo(Integer pet_class_no);	
	
}
