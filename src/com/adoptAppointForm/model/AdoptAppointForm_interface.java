package com.adoptAppointForm.model;

import java.util.List;

public interface AdoptAppointForm_interface {
	public AdoptAppointFormVO insert (AdoptAppointFormVO adoptAppointForm);
	
	public void update (AdoptAppointFormVO adoptAppointForm);
	
	public AdoptAppointFormVO findByPK (Integer appoint_form_no );
	
	public List<AdoptAppointFormVO> findAdoptMebNo (Integer adopt_meb_no );
}
