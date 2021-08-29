package com.petClassList.model;

import java.io.Serializable;

public class PetClassListVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer pet_class_list_no;
	private Integer adopt_pat_no;
	private Integer pet_class_no;
	private Integer gen_meb_pet_no;
	private String pet_class_list_state;
	
	public Integer getPet_class_list_no() {
		return pet_class_list_no;
	}
	public void setPet_class_list_no(Integer pet_class_list_no) {
		this.pet_class_list_no = pet_class_list_no;
	}
	public Integer getAdopt_pat_no() {
		return adopt_pat_no;
	}
	public void setAdopt_pat_no(Integer adopt_pat_no) {
		this.adopt_pat_no = adopt_pat_no;
	}
	public Integer getPet_class_no() {
		return pet_class_no;
	}
	public void setPet_class_no(Integer pet_class_no) {
		this.pet_class_no = pet_class_no;
	}
	public Integer getGen_meb_pet_no() {
		return gen_meb_pet_no;
	}
	public void setGen_meb_pet_no(Integer gen_meb_pet_no) {
		this.gen_meb_pet_no = gen_meb_pet_no;
	}
	public String getPet_class_list_state() {
		return pet_class_list_state;
	}
	public void setPet_class_list_state(String pet_class_list_state) {
		this.pet_class_list_state = pet_class_list_state;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
