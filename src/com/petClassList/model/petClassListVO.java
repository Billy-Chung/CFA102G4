package com.petClassList.model;

import java.io.Serializable;

public class petClassListVO implements Serializable {
	private Integer PET_CLASS_LIST_NO;
	private Integer ADOPT_PET_NO;
	private Integer PET_CLASS_NO;
	private Integer GEN_MEB_PET_NO;
	
	public Integer getPET_CLASS_LIST_NO() {
		return PET_CLASS_LIST_NO;
	}
	public void setPET_CLASS_LIST_NO(Integer pET_CLASS_LIST_NO) {
		PET_CLASS_LIST_NO = pET_CLASS_LIST_NO;
	}
	public Integer getADOPT_PET_NO() {
		return ADOPT_PET_NO;
	}
	public void setADOPT_PET_NO(Integer aDOPT_PET_NO) {
		ADOPT_PET_NO = aDOPT_PET_NO;
	}
	public Integer getPET_CLASS_NO() {
		return PET_CLASS_NO;
	}
	public void setPET_CLASS_NO(Integer pET_CLASS_NO) {
		PET_CLASS_NO = pET_CLASS_NO;
	}
	public Integer getGEN_MEB_PET_NO() {
		return GEN_MEB_PET_NO;
	}
	public void setGEN_MEB_PET_NO(Integer gEN_MEB_PET_NO) {
		GEN_MEB_PET_NO = gEN_MEB_PET_NO;
	}
	
	
}
