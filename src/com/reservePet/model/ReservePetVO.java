package com.reservePet.model;

import java.io.Serializable;
import java.sql.Date;

public class ReservePetVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer reserve_pet_no;
	private Integer adopt_meb_no;
	private Integer gen_meb_no;
	private Integer adopt_pet_no;
	private String reserve_people_name;
	private String reserve_people_phone;
	private Date reserve_date;
	private String reserve_time;
	private String reserve_state;
	
	public Integer getReserve_pet_no() {
		return reserve_pet_no;
	}
	public void setReserve_pet_no(Integer reserve_pet_no) {
		this.reserve_pet_no = reserve_pet_no;
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
	public String getReserve_people_name() {
		return reserve_people_name;
	}
	public void setReserve_people_name(String reserve_people_name) {
		this.reserve_people_name = reserve_people_name;
	}
	public String getReserve_people_phone() {
		return reserve_people_phone;
	}
	public void setReserve_people_phone(String reserve_people_phone) {
		this.reserve_people_phone = reserve_people_phone;
	}
	public Date getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(Date reserve_date) {
		this.reserve_date = reserve_date;
	}
	public String getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	public String getReserve_state() {
		return reserve_state;
	}
	public void setReserve_state(String reserve_state) {
		this.reserve_state = reserve_state;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
