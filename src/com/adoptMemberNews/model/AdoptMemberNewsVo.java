package com.adoptMemberNews.model;

import java.io.Serializable;
import java.sql.Date;

public class AdoptMemberNewsVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer adopt_meb_news_no;
	private Integer adopt_meb_no;
	private String adopt_meb_news_title;
	private String adopt_meb_news_comment;
	private byte[] adopt_meb_news_photo;
	private String adopt_meb_news_state;
	private Date adopt_meb_news_date;
	
	
	public Integer getAdopt_meb_news_no() {
		return adopt_meb_news_no;
	}
	public void setAdopt_meb_news_no(Integer adopt_meb_news_no) {
		this.adopt_meb_news_no = adopt_meb_news_no;
	}
	public Integer getAdopt_meb_no() {
		return adopt_meb_no;
	}
	public void setAdopt_meb_no(Integer adopt_meb_no) {
		this.adopt_meb_no = adopt_meb_no;
	}
	public String getAdopt_meb_news_title() {
		return adopt_meb_news_title;
	}
	public void setAdopt_meb_news_title(String adopt_meb_news_title) {
		this.adopt_meb_news_title = adopt_meb_news_title;
	}
	public String getAdopt_meb_news_comment() {
		return adopt_meb_news_comment;
	}
	public void setAdopt_meb_news_comment(String adopt_meb_news_comment) {
		this.adopt_meb_news_comment = adopt_meb_news_comment;
	}
	public byte[] getAdopt_meb_news_photo() {
		return adopt_meb_news_photo;
	}
	public void setAdopt_meb_news_photo(byte[] adopt_meb_news_photo) {
		this.adopt_meb_news_photo = adopt_meb_news_photo;
	}
	public String getAdopt_meb_news_state() {
		return adopt_meb_news_state;
	}
	public void setAdopt_meb_news_state(String adopt_meb_news_state) {
		this.adopt_meb_news_state = adopt_meb_news_state;
	}
	public Date getAdopt_meb_news_date() {
		return adopt_meb_news_date;
	}
	public void setAdopt_meb_news_date(Date adopt_meb_news_date) {
		this.adopt_meb_news_date = adopt_meb_news_date;
	}	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
