package com.promotions.model;

import java.io.Serializable;
import java.sql.Date;


public class promotionsVO implements Serializable {
	private Integer PROMOT_NO;
	private String PROMOT_NAME;	
	private Date PROMOT_DATE_START;
	private Date PROMOT_DATE_END;
	private String PROMOT_STATUS;
	private String PROMOT_TYPE;
	private String PROMOT_DISCOUNT_TYPE;	
	private String PROMOT_DISCOUNT;
	private String PROMOT_REDUCE;	
	private String PROMOT_COMMENT;
	private byte[] PROMOT_PHOTO;
	
	public Integer getPROMOT_NO() {
		return PROMOT_NO;
	}
	public void setPROMOT_NO(Integer pROMOT_NO) {
		PROMOT_NO = pROMOT_NO;
	}
	public String getPROMOT_NAME() {
		return PROMOT_NAME;
	}
	public void setPROMOT_NAME(String pROMOT_NAME) {
		PROMOT_NAME = pROMOT_NAME;
	}
	public Date getPROMOT_DATE_START() {
		return PROMOT_DATE_START;
	}
	public void setPROMOT_DATE_START(Date pROMOT_DATE_START) {
		PROMOT_DATE_START = pROMOT_DATE_START;
	}
	public Date PROMOT_DATE_END() {
		return PROMOT_DATE_END;
	}
	public void setPROMOT_DATE_END(Date pROMOT_DATE_END) {
		PROMOT_DATE_END = pROMOT_DATE_END;
	}
	public String getPROMOT_STATUS() {
		return PROMOT_STATUS;
	}
	public void setPROMOT_STATUS(String pROMOT_STATUS) {
		PROMOT_STATUS = pROMOT_STATUS;
	}
	public String getPROMOT_TYPE() {
		return PROMOT_TYPE;
	}
	public void setPROMOT_TYPE(String pROMOT_TYPE) {
		PROMOT_TYPE = pROMOT_TYPE;
	}
	public String getPROMOT_DISCOUNT_TYPE() {
		return PROMOT_DISCOUNT_TYPE;
	}
	public void setPROMOT_DISCOUNT_TYPE(String pROMOT_DISCOUNT_TYPE) {
		PROMOT_DISCOUNT_TYPE = pROMOT_DISCOUNT_TYPE;
	}
	public String getPROMOT_DISCOUNT() {
		return PROMOT_DISCOUNT;
	}
	public void setPROMOT_DISCOUNT(String pROMOT_DISCOUNT) {
		PROMOT_DISCOUNT = pROMOT_DISCOUNT;
	}
	public String getPROMOT_REDUCE() {
		return PROMOT_REDUCE;
	}
	public void setPROMOT_REDUCE(String pROMOT_REDUCE) {
		PROMOT_REDUCE = pROMOT_REDUCE;
	}
	public String getPROMOT_COMMENT() {
		return PROMOT_COMMENT;
	}
	public void setPROMOT_COMMENT(String pROMOT_COMMENT) {
		PROMOT_COMMENT = pROMOT_COMMENT;
	}
	public byte[] getPROMOT_PHOTO() {
		return PROMOT_PHOTO;
	}
	public void setPROMOT_PHOTO(byte[] pROMOT_PHOTO) {
		PROMOT_PHOTO = pROMOT_PHOTO;
	}
	
}
