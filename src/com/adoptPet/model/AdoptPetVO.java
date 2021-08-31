package com.adoptPet.model;

import java.io.Serializable;
import java.sql.Date;

public class AdoptPetVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer adopt_pet_no;
	private	Integer adopt_meb_no;
	private Integer gen_meb_no;
	private String adopt_pet_breeds;
	private String adopt_pet_gender;
	private String adopt_pet_come_form;
	private Date adopt_pet_join_date;
	private String adopt_pet_chip;
	private String adopt_pet_join_reason;
	private String capture_address;
	private String adopt_pet_sterilization;
	private String contain_number;
	private String adopt_pet_color;
	private String adopt_pet_state;
	
	public Integer getAdopt_pet_no() {
		return adopt_pet_no;
	}
	public void setAdopt_pet_no(Integer adopt_pet_no) {
		this.adopt_pet_no = adopt_pet_no;
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
	public String getAdopt_pet_breeds() {
		return adopt_pet_breeds;
	}
	public void setAdopt_pet_breeds(String adopt_pet_breeds) {
		this.adopt_pet_breeds = adopt_pet_breeds;
	}
	public String getAdopt_pet_gender() {
		return adopt_pet_gender;
	}
	public void setAdopt_pet_gender(String adopt_pet_gender) {
		this.adopt_pet_gender = adopt_pet_gender;
	}
	public String getAdopt_pet_come_form() {
		return adopt_pet_come_form;
	}
	public void setAdopt_pet_come_form(String adopt_pet_come_form) {
		this.adopt_pet_come_form = adopt_pet_come_form;
	}
	public Date getAdopt_pet_join_date() {
		return adopt_pet_join_date;
	}
	public void setAdopt_pet_join_date(Date adopt_pet_join_date) {
		this.adopt_pet_join_date = adopt_pet_join_date;
	}
	public String getAdopt_pet_chip() {
		return adopt_pet_chip;
	}
	public void setAdopt_pet_chip(String adopt_pet_chip) {
		this.adopt_pet_chip = adopt_pet_chip;
	}
	public String getAdopt_pet_join_reason() {
		return adopt_pet_join_reason;
	}
	public void setAdopt_pet_join_reason(String adopt_pet_join_reason) {
		this.adopt_pet_join_reason = adopt_pet_join_reason;
	}
	public String getCapture_address() {
		return capture_address;
	}
	public void setCapture_address(String capture_address) {
		this.capture_address = capture_address;
	}
	public String getAdopt_pet_sterilization() {
		return adopt_pet_sterilization;
	}
	public void setAdopt_pet_sterilization(String adopt_pet_sterilization) {
		this.adopt_pet_sterilization = adopt_pet_sterilization;
	}
	public String getContain_number() {
		return contain_number;
	}
	public void setContain_number(String contain_number) {
		this.contain_number = contain_number;
	}
	public String getAdopt_pet_color() {
		return adopt_pet_color;
	}
	public void setAdopt_pet_color(String adopt_pet_color) {
		this.adopt_pet_color = adopt_pet_color;
	}
	public String getAdopt_pet_state() {
		return adopt_pet_state;
	}
	public void setAdopt_pet_state(String adopt_pet_state) {
		this.adopt_pet_state = adopt_pet_state;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
