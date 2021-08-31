package com.promotions.model;

import java.io.Serializable;
import java.sql.Date;





//VO，Value Object 值物件，每個表格對應一個VO
public class promotionsVO implements Serializable {
	private int promot_no;
	private String promot_name;	
	private Date promot_date_start;
	private Date promot_date_end;
	private String promot_status;
	private String promot_type;
	private String promot_discount_type;	
	private String promot_discount;
	private String promot_reduce;	
	private String promot_comment;
	
	private byte[] promot_photo;//存LONGBLOB  type_img
	
	
	
	public int getPromot_no() {
		return promot_no;
	}
	public void setPromot_no(int promot_no) {
		this.promot_no = promot_no;
	}
	public String getPromot_name() {
		return promot_name;
	}
	public void setPromot_name(String promot_name) {
		this.promot_name = promot_name;
	}
	public Date getPromot_date_start() {
		return promot_date_start;
	}
	public void setPromot_date_start(Date promot_date_start) {
		this.promot_date_start = promot_date_start;
	}
	public Date getPromot_date_end() {
		return promot_date_end;
	}
	public void setPromot_date_end(Date promot_date_end) {
		this.promot_date_end = promot_date_end;
	}
	public String getPromot_status() {
		return promot_status;
	}
	public void setPromot_status(String promot_status) {
		this.promot_status = promot_status;
	}
	public String getPromot_type() {
		return promot_type;
	}
	public void setPromot_type(String promot_type) {
		this.promot_type = promot_type;
	}
	public String getPromot_discount_type() {
		return promot_discount_type;
	}
	public void setPromot_discount_type(String promot_discount_type) {
		this.promot_discount_type = promot_discount_type;
	}
	public String getPromot_discount() {
		return promot_discount;
	}
	public void setPromot_discount(String promot_discount) {
		this.promot_discount = promot_discount;
	}
	public String getPromot_reduce() {
		return promot_reduce;
	}
	public void setPromot_reduce(String promot_reduce) {
		this.promot_reduce = promot_reduce;
	}
	public String getPromot_comment() {
		return promot_comment;
	}
	public void setPromot_comment(String promot_comment) {
		this.promot_comment = promot_comment;
	}
	public byte[] getPromot_photo() {
		return promot_photo;
	}
	public void setPromot_photo(byte[] promot_photo) {
		this.promot_photo = promot_photo;
	}

	
	
}
