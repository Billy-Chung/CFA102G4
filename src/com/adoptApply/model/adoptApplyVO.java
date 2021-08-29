package com.adoptApply.model;

import java.io.Serializable;
import java.sql.Date;

public class adoptApplyVO implements Serializable {
	
	private Integer ADOPT_APPLY_NO;
	private Integer ADOPT_MEB_NO;
	private Integer GEN_MEB_NO;
	private Integer ADOPT_PET_NO;
	private String ADOPT_AUDIT_STATE;
	private String ADOPT_APPLY_PEOPLE_ID;
	private Date ADOPT_APPLY_DATE;
	private String ADOPT_APPLY_STATE;
	
	public Integer getADOPT_APPLY_NO() {
		return ADOPT_APPLY_NO;
	}
	public void setADOPT_APPLY_NO(Integer aDOPT_APPLY_NO) {
		ADOPT_APPLY_NO = aDOPT_APPLY_NO;
	}

	public Integer getADOPT_MEB_NO() {
		return ADOPT_MEB_NO;
	}
	public void setADOPT_MEB_NO(Integer aDOPT_MEB_NO) {
		ADOPT_MEB_NO = aDOPT_MEB_NO;
	}
	public Integer getGEN_MEB_NO() {
		return GEN_MEB_NO;
	}
	public void setGEN_MEB_NO(Integer gEN_MEB_NO) {
		GEN_MEB_NO = gEN_MEB_NO;
	}
	public Integer getADOPT_PET_NO() {
		return ADOPT_PET_NO;
	}
	public void setADOPT_PET_NO(Integer aDOPT_PET_NO) {
		ADOPT_PET_NO = aDOPT_PET_NO;
	}
	public String getADOPT_AUDIT_STATE() {
		return ADOPT_AUDIT_STATE;
	}
	public void setADOPT_AUDIT_STATE(String aDOPT_AUDIT_STATE) {
		ADOPT_AUDIT_STATE = aDOPT_AUDIT_STATE;
	}
	public String getADOPT_APPLY_PEOPLE_ID() {
		return ADOPT_APPLY_PEOPLE_ID;
	}
	public void setADOPT_APPLY_PEOPLE_ID(String aDOPT_APPLY_PEOPLE_ID) {
		ADOPT_APPLY_PEOPLE_ID = aDOPT_APPLY_PEOPLE_ID;
	}
	public Date getADOPT_APPLY_DATE() {
		return ADOPT_APPLY_DATE;
	}
	public void setADOPT_APPLY_DATE(Date aDOPT_APPLY_DATE) {
		ADOPT_APPLY_DATE = aDOPT_APPLY_DATE;
	}
	public String getADOPT_APPLY_STATE() {
		return ADOPT_APPLY_STATE;
	}
	public void setADOPT_APPLY_STATE(String aDOPT_APPLY_STATE) {
		ADOPT_APPLY_STATE = aDOPT_APPLY_STATE;
	}
}