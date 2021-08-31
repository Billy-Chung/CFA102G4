package com.reservePet.model;

import java.util.List;


public interface ReservePet_interface {
	
	public ReservePetVO insert(ReservePetVO reservePet);
	
	public void update(ReservePetVO reservePet);
	
	public ReservePetVO findByReservePetPK(Integer reserve_pet_no);
	
	public List<ReservePetVO> findByAdoptMebNo(Integer adopt_meb_no);
	
	public List<ReservePetVO> findByGenMebNo(Integer gen_meb_no);
	
	public List<ReservePetVO> findByAdoptPetNo(Integer adopt_pet_no);
}
