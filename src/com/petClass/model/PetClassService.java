package com.petClass.model;

import java.util.List;

public class PetClassService {
	private PetClasss_interface dao;

	public PetClassService() {
		dao = new PetClassDAO();
	}

	public PetClassVO insertPetClass(String pet_class_name, String pet_class_state) {
		PetClassVO petClass = new PetClassVO();

		petClass.setPet_class_name(pet_class_name);
		petClass.setPet_class_state(pet_class_state);
		petClass = dao.insert(petClass);

		return petClass;
	}

	public void updatePetClass(String pet_class_name, String pet_class_state, Integer pet_class_no) {
		PetClassVO petClass = new PetClassVO();

		petClass.setPet_class_name(pet_class_name);
		petClass.setPet_class_state(pet_class_state);
		petClass.setPet_class_no(pet_class_no);
		dao.update(petClass);
	}

	public PetClassVO findBypetClassNo(Integer pet_class_no) {

		PetClassVO petClass = dao.findBypetClassNo(pet_class_no);

		return petClass;
	}

	public List<PetClassVO> getAll() {

		List<PetClassVO> petClassList = dao.getAllpetClass();

		return petClassList;
	}
}
