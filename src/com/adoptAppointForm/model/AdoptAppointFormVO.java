package com.adoptAppointForm.model;

import java.io.Serializable;
import java.sql.Date;

public class AdoptAppointFormVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer appoint_form_no;
	private Integer adopt_meb_no;
	private Date appoint_date;
	private String finifh_appoint_num;
	private String appoint_limit;
	
	public Integer getAppoint_form_no() {
		return appoint_form_no;
	}
	public void setAppoint_form_no(Integer appoint_form_no) {
		this.appoint_form_no = appoint_form_no;
	}
	public Integer getAdopt_meb_no() {
		return adopt_meb_no;
	}
	public void setAdopt_meb_no(Integer adopt_meb_no) {
		this.adopt_meb_no = adopt_meb_no;
	}
	public Date getAppoint_date() {
		return appoint_date;
	}
	public void setAppoint_date(Date appoint_date) {
		this.appoint_date = appoint_date;
	}
	public String getFinifh_appoint_num() {
		return finifh_appoint_num;
	}
	public void setFinifh_appoint_num(String finifh_appoint_num) {
		this.finifh_appoint_num = finifh_appoint_num;
	}
	public String getAppoint_limit() {
		return appoint_limit;
	}
	public void setAppoint_limit(String appoint_limit) {
		this.appoint_limit = appoint_limit;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
