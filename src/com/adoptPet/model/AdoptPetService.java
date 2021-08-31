package com.adoptPet.model;

import java.sql.Date;
import java.util.List;

public class AdoptPetService {
	private AdoptPet_interface dao;

	public AdoptPetService() {
		dao = new AdoptPetDAO();
	}

	public AdoptPetVO insertAdoptPet(Integer adopt_meb_no, Integer gen_meb_no, String adopt_pet_breeds,
			String adopt_pet_gender, String adopt_pet_come_form, Date adopt_pet_join_date, String adopt_pet_chip,
			String adopt_pet_join_reason, String capture_address, String adopt_pet_sterilization, String contain_number,
			String adopt_pet_color, String adopt_pet_state) {
		AdoptPetVO adoptPet = new AdoptPetVO();

		adoptPet.setAdopt_meb_no(adopt_meb_no);
		adoptPet.setGen_meb_no(gen_meb_no);
		adoptPet.setAdopt_pet_breeds(adopt_pet_breeds);
		adoptPet.setAdopt_pet_gender(adopt_pet_gender);
		adoptPet.setAdopt_pet_come_form(adopt_pet_come_form);
		adoptPet.setAdopt_pet_join_date(adopt_pet_join_date);
		adoptPet.setAdopt_pet_chip(adopt_pet_chip);
		adoptPet.setAdopt_pet_join_reason(adopt_pet_join_reason);
		adoptPet.setCapture_address(capture_address);
		adoptPet.setAdopt_pet_sterilization(adopt_pet_sterilization);
		adoptPet.setContain_number(contain_number);
		adoptPet.setAdopt_pet_color(adopt_pet_color);
		adoptPet.setAdopt_pet_state(adopt_pet_state);
		adoptPet = dao.insert(adoptPet);

		return adoptPet;
	}

	public void updateAdoptPet(Integer gen_meb_no, String adopt_pet_breeds, String adopt_pet_gender,
			String adopt_pet_come_form, Date adopt_pet_join_date, String adopt_pet_chip, String adopt_pet_join_reason,
			String capture_address, String adopt_pet_sterilization, String contain_number, String adopt_pet_color,
			String adopt_pet_state, Integer adopt_pet_no) {
		AdoptPetVO adoptPet = new AdoptPetVO();	
		adoptPet.setGen_meb_no(gen_meb_no);
		adoptPet.setAdopt_pet_breeds(adopt_pet_breeds);
		adoptPet.setAdopt_pet_gender(adopt_pet_gender);
		adoptPet.setAdopt_pet_come_form(adopt_pet_come_form);
		adoptPet.setAdopt_pet_join_date(adopt_pet_join_date);
		adoptPet.setAdopt_pet_chip(adopt_pet_chip);
		adoptPet.setAdopt_pet_join_reason(adopt_pet_join_reason);
		adoptPet.setCapture_address(capture_address);
		adoptPet.setAdopt_pet_sterilization(adopt_pet_sterilization);
		adoptPet.setContain_number(contain_number);
		adoptPet.setAdopt_pet_color(adopt_pet_color);
		adoptPet.setAdopt_pet_state(adopt_pet_state);
		adoptPet.setAdopt_pet_no(adopt_pet_no);
		dao.update(adoptPet);
	}

	public AdoptPetVO findByAdoptPetNoPK(Integer adopt_pet_no) {

		AdoptPetVO adoptPet = dao.findByAdoptPetNoPK(adopt_pet_no);

		return adoptPet;
	}

	public List<AdoptPetVO> findByAdoptMebNo(Integer adopt_meb_no) {

		List<AdoptPetVO> adoptPetList = dao.findByAdoptMebNo(adopt_meb_no);

		return adoptPetList;
	}

	public List<AdoptPetVO> getAll() {

		List<AdoptPetVO> adoptPetList = dao.getAllAdoptPet();

		return adoptPetList;
	}
}
