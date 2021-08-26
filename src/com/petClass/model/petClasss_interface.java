package com.petClass.model;

import java.util.List;


public interface petClasss_interface {
	
	public petClassVO insert(petClassVO petClass);
	
	public void update(petClassVO petClass);

	public petClassVO findBypetClassNo(Integer PET_CLASS_NO);
	
	public List<petClassVO> getAllpetClass();
}
