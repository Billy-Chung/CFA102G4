package com.storedValRecord.model;

import java.io.Serializable;
import java.sql.Date;

public class StoredValRecodeVO implements Serializable {
	private Integer stored_val_recode_no;
	private Integer ger_meb_no;
	private Date stored_val_date;
	private Integer stored_val_amout;
	
	public Integer getStored_val_recode_no() {
		return stored_val_recode_no;
	}
	public void setStored_val_recode_no(Integer stored_val_recode_no) {
		this.stored_val_recode_no = stored_val_recode_no;
	}
	public Integer getGer_meb_no() {
		return ger_meb_no;
	}
	public void setGer_meb_no(Integer ger_meb_no) {
		this.ger_meb_no = ger_meb_no;
	}
	public Date getStored_val_date() {
		return stored_val_date;
	}
	public void setStored_val_date(Date stored_val_date) {
		this.stored_val_date = stored_val_date;
	}
	public Integer getStored_val_amout() {
		return stored_val_amout;
	}
	public void setStored_val_amout(Integer stored_val_amout) {
		this.stored_val_amout = stored_val_amout;
	}
	
	
}
