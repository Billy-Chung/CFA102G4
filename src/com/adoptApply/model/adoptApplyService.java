package com.adoptApply.model;

import java.util.List;

public class adoptApplyService {
	
	private adoptApplyDAO_interface dao;

	public adoptApplyService() {
		dao = new adoptApplyDAO();
	}

	public adoptApplyVO addadoptApply(Integer adopt_apply_no, Integer adopt_meb_no, Integer gen_meb_no, Integer adopt_pet_no,String adopt_audit_state,String adopt_apply_people_id, java.sql.Date adopt_apply_date, String adopt_apply_state) {

		adoptApplyVO aa = new adoptApplyVO();

		aa.setAdopt_apply_no(adopt_apply_no);
		aa.setAdopt_meb_no(adopt_meb_no);
		aa.setGen_meb_no(gen_meb_no);
		aa.setAdopt_pet_no(adopt_pet_no);
		aa.setAdopt_audit_state(adopt_audit_state);
		aa.setAdopt_apply_people_id(adopt_apply_people_id);
		aa.setAdopt_apply_date(adopt_apply_date);
		aa.setAdopt_apply_state(adopt_apply_state);
		dao.insert(aa);
		return aa;
	}

	public adoptApplyVO updateadoptApply(Integer adopt_apply_no, Integer adopt_meb_no, Integer gen_meb_no, Integer adopt_pet_no,String adopt_audit_state,String adopt_apply_people_id, java.sql.Date adopt_apply_date, String adopt_apply_state) {

		adoptApplyVO aa = new adoptApplyVO();

		aa.setAdopt_apply_no(adopt_apply_no);
		aa.setAdopt_meb_no(adopt_meb_no);
		aa.setGen_meb_no(gen_meb_no);
		aa.setAdopt_pet_no(adopt_pet_no);
		aa.setAdopt_audit_state(adopt_audit_state);
		aa.setAdopt_apply_people_id(adopt_apply_people_id);
		aa.setAdopt_apply_date(adopt_apply_date);
		aa.setAdopt_apply_state(adopt_apply_state);
		dao.update(aa);
		return aa;
	}

	public void deleteadoptApply(Integer adopt_apply_no) {
		dao.delete(adopt_apply_no);
	}

	public adoptApplyVO getOneadoptApply(Integer adopt_apply_no) {
		return dao.findByPrimaryKey(adopt_apply_no);
	}

	public List<adoptApplyVO> getAll() {
		return dao.getAll();
	}
}

