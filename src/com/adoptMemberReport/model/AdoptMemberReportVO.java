package com.adoptMemberReport.model;

import java.io.Serializable;
import java.sql.Date;

public class AdoptMemberReportVO implements Serializable {
	private Integer adopt_meb_report_no;
	private Integer adopt_meb_no;
	private Integer gen_meb_no;
	private String eport_comment;
	private String adopt_meb_report_state;
	private Date adopt_meb_report_date;
	
	
	public Integer getAdopt_meb_report_no() {
		return adopt_meb_report_no;
	}
	public void setAdopt_meb_report_no(Integer adopt_meb_report_no) {
		this.adopt_meb_report_no = adopt_meb_report_no;
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
	public String getEport_comment() {
		return eport_comment;
	}
	public void setEport_comment(String eport_comment) {
		this.eport_comment = eport_comment;
	}
	public String getAdopt_meb_report_state() {
		return adopt_meb_report_state;
	}
	public void setAdopt_meb_report_state(String adopt_meb_report_state) {
		this.adopt_meb_report_state = adopt_meb_report_state;
	}
	public Date getAdopt_meb_report_date() {
		return adopt_meb_report_date;
	}
	public void setAdopt_meb_report_date(Date adopt_meb_report_date) {
		this.adopt_meb_report_date = adopt_meb_report_date;
	}
	
	
}
