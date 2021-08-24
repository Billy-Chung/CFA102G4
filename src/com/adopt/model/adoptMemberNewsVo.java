package com.adopt.model;

import java.io.Serializable;
import java.sql.Date;

public class adoptMemberNewsVo implements Serializable {
	private Integer ADOPT_MEB_NEWS_NO;
	private Integer ADOPT_MEB_NO;
	private String ADOPT_MEB_NEWS_TITLE;
	private String ADOPT_MEB_NEWS_COMMENT;
	private byte[] ADOPT_MEB_NEWS_PHOTO;
	private String ADOPT_MEB_NEWS_STATE;
	private Date ADOPT_MEB_NEWS_DATE;
	
	public Integer getADOPT_MEB_NEWS_NO() {
		return ADOPT_MEB_NEWS_NO;
	}
	public void setADOPT_MEB_NEWS_NO(Integer aDOPT_MEB_NEWS_NO) {
		ADOPT_MEB_NEWS_NO = aDOPT_MEB_NEWS_NO;
	}
	public Integer getADOPT_MEB_NO() {
		return ADOPT_MEB_NO;
	}
	public void setADOPT_MEB_NO(Integer aDOPT_MEB_NO) {
		ADOPT_MEB_NO = aDOPT_MEB_NO;
	}
	public String getADOPT_MEB_NEWS_TITLE() {
		return ADOPT_MEB_NEWS_TITLE;
	}
	public void setADOPT_MEB_NEWS_TITLE(String aDOPT_MEB_NEWS_TITLE) {
		ADOPT_MEB_NEWS_TITLE = aDOPT_MEB_NEWS_TITLE;
	}
	public String getADOPT_MEB_NEWS_COMMENT() {
		return ADOPT_MEB_NEWS_COMMENT;
	}
	public void setADOPT_MEB_NEWS_COMMENT(String aDOPT_MEB_NEWS_COMMENT) {
		ADOPT_MEB_NEWS_COMMENT = aDOPT_MEB_NEWS_COMMENT;
	}
	public byte[] getADOPT_MEB_NEWS_PHOTO() {
		return ADOPT_MEB_NEWS_PHOTO;
	}
	public void setADOPT_MEB_NEWS_PHOTO(byte[] aDOPT_MEB_NEWS_PHOTO) {
		ADOPT_MEB_NEWS_PHOTO = aDOPT_MEB_NEWS_PHOTO;
	}
	public String getADOPT_MEB_NEWS_STATE() {
		return ADOPT_MEB_NEWS_STATE;
	}
	public void setADOPT_MEB_NEWS_STATE(String aDOPT_MEB_NEWS_STATE) {
		ADOPT_MEB_NEWS_STATE = aDOPT_MEB_NEWS_STATE;
	}
	public Date getADOPT_MEB_NEWS_DATE() {
		return ADOPT_MEB_NEWS_DATE;
	}
	public void setADOPT_MEB_NEWS_DATE(Date aDOPT_MEB_NEWS_DATE) {
		ADOPT_MEB_NEWS_DATE = aDOPT_MEB_NEWS_DATE;
	}
	
	
	
}
