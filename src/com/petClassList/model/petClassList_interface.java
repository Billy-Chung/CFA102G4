package com.petClassList.model;

import java.util.List;

public interface petClassList_interface {
	
	public petClassListVO insert(petClassListVO petClassList);
	
	public void update(petClassListVO petClassList);
	
	public void delete(Integer ADOPT_PET_NO);
	
	public List<petClassListVO> findByAdoptPetNo(Integer ADOPT_PET_NO);	
	
	public List<petClassListVO> findByPetClassNo(Integer PET_CLASS_NO);	
	
}
