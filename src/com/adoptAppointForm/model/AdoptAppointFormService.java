package com.adoptAppointForm.model;

import java.sql.Date;
import java.util.List;

public class AdoptAppointFormService {
	private AdoptAppointForm_interface dao;

	public AdoptAppointFormService() {
		dao = new AdoptAppointFormDAO();
	}

	public AdoptAppointFormVO insertAdoptAppointForm(Integer adopt_meb_no, Date appoint_date,
			String finifh_appoint_num, String appoint_limit) {
		AdoptAppointFormVO adoptAppointForm = new AdoptAppointFormVO();

		adoptAppointForm.setAdopt_meb_no(adopt_meb_no);
		adoptAppointForm.setAppoint_date(appoint_date);
		adoptAppointForm.setFinifh_appoint_num(finifh_appoint_num);
		adoptAppointForm.setAppoint_limit("appoint_limit");
		adoptAppointForm = dao.insert(adoptAppointForm);

		return adoptAppointForm;
	}

	public void updateAdoptAppointForm(String finifh_appoint_num,String appoint_limit,Integer appoint_form_no) {
		AdoptAppointFormVO adoptAppointFormVO = new AdoptAppointFormVO();
		
		adoptAppointFormVO.setFinifh_appoint_num(finifh_appoint_num);
		adoptAppointFormVO.setAppoint_limit(appoint_limit);
		adoptAppointFormVO.setAdopt_meb_no(appoint_form_no);
		dao.update(adoptAppointFormVO);
	}
	
	
	public AdoptAppointFormVO findByAdoptAppointFormPK(Integer appoint_form_no) {
		 AdoptAppointFormVO adoptAppointForm = dao.findByPK(appoint_form_no);
		 return adoptAppointForm;
	}
	
	public AdoptAppointFormVO findAdoptMebNo(Integer adopt_meb_no) {
		 AdoptAppointFormVO adoptAppointForm = dao.findByPK(adopt_meb_no);
		 return adoptAppointForm;
	}
}
