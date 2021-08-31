package com.pay_method.model;

import java.io.Serializable;
import java.sql.Date;

public class pay_methodVO implements Serializable{
	private Integer pay_no;
	private String pay_name;
	public Integer getPay_no() {
		return pay_no;
	}
	public void setPay_no(Integer pay_no) {
		this.pay_no = pay_no;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	
	
}
