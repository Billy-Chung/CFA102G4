package com.petClass.model;

import java.util.List;


public interface PetClasss_interface {
	
	public PetClassVO insert(PetClassVO petClass);
	
	public void update(PetClassVO petClass);

	public PetClassVO findBypetClassNo(Integer pet_class_no);
	
	public List<PetClassVO> getAllpetClass();
}
