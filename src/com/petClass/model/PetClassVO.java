package com.petClass.model;

import java.io.Serializable;

public class PetClassVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer pet_class_no;
	private String pet_class_name;
	private String pet_class_state;
	
	
	public Integer getPet_class_no() {
		return pet_class_no;
	}
	public void setPet_class_no(Integer pet_class_no) {
		this.pet_class_no = pet_class_no;
	}
	public String getPet_class_name() {
		return pet_class_name;
	}
	public void setPet_class_name(String pet_class_name) {
		this.pet_class_name = pet_class_name;
	}
	public String getPet_class_state() {
		return pet_class_state;
	}
	public void setPet_class_state(String pet_class_state) {
		this.pet_class_state = pet_class_state;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
