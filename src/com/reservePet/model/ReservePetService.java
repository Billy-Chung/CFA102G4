package com.reservePet.model;

import java.sql.Date;
import java.util.List;

public class ReservePetService {
	private ReservePet_interface dao;

	public ReservePetService() {
		dao = new ReservePetDAO();
	}

	public ReservePetVO insertReservePet(Integer adopt_meb_no, Integer gen_meb_no, Integer adopt_pet_no,
			String reserve_people_name, String reserve_people_phone, Date reserve_date, String reserve_timeprivate,
			String reserve_state) {
		ReservePetVO reservePet = new ReservePetVO();

		reservePet.setAdopt_meb_no(adopt_meb_no);
		reservePet.setGen_meb_no(gen_meb_no);
		reservePet.setAdopt_pet_no(adopt_pet_no);
		reservePet.setReserve_people_name(reserve_people_name);
		reservePet.setReserve_people_phone(reserve_people_phone);
		reservePet.setReserve_date(reserve_date);
		reservePet.setReserve_time(reserve_timeprivate);
		reservePet.setReserve_state(reserve_state);
		reservePet = dao.insert(reservePet);

		return reservePet;
	}

	public void upodateReservePet(String reserve_people_name, String reserve_people_phone, Date reserve_date,
			String reserve_timeprivate, String reserve_state, Integer reserve_pet_no) {
		ReservePetVO reservePet = new ReservePetVO();

		reservePet.setReserve_people_name(reserve_people_name);
		reservePet.setReserve_people_phone(reserve_people_phone);
		reservePet.setReserve_date(reserve_date);
		reservePet.setReserve_time(reserve_timeprivate);
		reservePet.setReserve_state(reserve_state);
		reservePet.setReserve_pet_no(reserve_pet_no);
		dao.update(reservePet);

	}

	public ReservePetVO findByReservePetPK(Integer reserve_pet_no) {

		ReservePetVO reservePet = dao.findByReservePetPK(reserve_pet_no);

		return reservePet;
	}

	public List<ReservePetVO> findByAdoptMebNo(Integer adopt_meb_no) {

		List<ReservePetVO> reservePetList = dao.findByAdoptMebNo(adopt_meb_no);

		return reservePetList;
	}

	public List<ReservePetVO> findByGenMebNo(Integer gen_meb_no) {
		
		List<ReservePetVO> reservePetList = dao.findByAdoptMebNo(gen_meb_no);

		return reservePetList;
	}

	
	public List<ReservePetVO> findByAdoptPetNo(Integer adopt_pet_no){
		
		List<ReservePetVO> reservePetList = dao.findByAdoptPetNo(adopt_pet_no);

		return reservePetList;
	}
}
