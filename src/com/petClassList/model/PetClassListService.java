package com.petClassList.model;

import java.util.List;

public class PetClassListService {
	private PetClassList_interface dao;

	public PetClassListService() {
		dao = new PetClassListDAO();
	}

	public PetClassListVO insertPetClassList(Integer adopt_pat_no, Integer pet_class_no, Integer gen_meb_pet_no,
			String pet_class_list_state) {
		PetClassListVO petClassList = new PetClassListVO();

		petClassList.setAdopt_pat_no(adopt_pat_no);
		petClassList.setPet_class_no(pet_class_no);
		petClassList.setGen_meb_pet_no(gen_meb_pet_no);
		petClassList.setPet_class_list_state(pet_class_list_state);
		petClassList = dao.insert(petClassList);

		return petClassList;
	}

	public void updatePetClassList(Integer gen_meb_pet_no, String pet_class_list_state, Integer pet_class_list_no) {

		PetClassListVO petClassList = new PetClassListVO();
		petClassList.setGen_meb_pet_no(gen_meb_pet_no);
		petClassList.setPet_class_list_state(pet_class_list_state);
		petClassList.setPet_class_list_no(pet_class_list_no);
		
		dao.update(petClassList);
	}
	
	public List<PetClassListVO> findByAdoptPetNo(Integer adopt_pat_no){
		
		List<PetClassListVO> petClassLists = dao.findByAdoptPetNo(adopt_pat_no);
		
		return petClassLists;
	}

	public List<PetClassListVO> findByPetClassNo(Integer pet_class_no){
		
		List<PetClassListVO> petClassLists = dao.findByPetClassNo(pet_class_no);
		
		return petClassLists;
	}
}
