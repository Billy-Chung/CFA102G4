package com.adoptApply.model;

import java.io.Serializable;
import java.sql.Date;

public class adoptApplyVO implements Serializable {
	
	private Integer adopt_apply_no;
	private Integer adopt_meb_no;
	private Integer gen_meb_no;
	private Integer adopt_pet_no;
	private String adopt_audit_state;
	private String adopt_apply_people_id;
	private Date adopt_apply_date;
	private String adopt_apply_state;
	
	public Integer getAdopt_apply_no() {
		return adopt_apply_no;
	}
	public void setAdopt_apply_no(Integer adopt_apply_no) {
		this.adopt_apply_no = adopt_apply_no;
	}
	public Integer getAdopt_meb_no() {
		return adopt_meb_no;
	}
	public void setAdopt_meb_no(Integer adopt_meb_no) {
		this.adopt_meb_no = adopt_meb_no;
	}
	public Integer getGen_meb_no() {
		return gen_meb_no;
	}
	public void setGen_meb_no(Integer gen_meb_no) {
		this.gen_meb_no = gen_meb_no;
	}
	public Integer getAdopt_pet_no() {
		return adopt_pet_no;
	}
	public void setAdopt_pet_no(Integer adopt_pet_no) {
		this.adopt_pet_no = adopt_pet_no;
	}
	public String getAdopt_audit_state() {
		return adopt_audit_state;
	}
	public void setAdopt_audit_state(String adopt_audit_state) {
		this.adopt_audit_state = adopt_audit_state;
	}
	public String getAdopt_apply_people_id() {
		return adopt_apply_people_id;
	}
	public void setAdopt_apply_people_id(String adopt_apply_people_id) {
		this.adopt_apply_people_id = adopt_apply_people_id;
	}
	public Date getAdopt_apply_date() {
		return adopt_apply_date;
	}
	public void setAdopt_apply_date(Date adopt_apply_date) {
		this.adopt_apply_date = adopt_apply_date;
	}
	public String getAdopt_apply_state() {
		return adopt_apply_state;
	}
	public void setAdopt_apply_state(String adopt_apply_state) {
		this.adopt_apply_state = adopt_apply_state;
	}	
}