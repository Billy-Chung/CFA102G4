package com.petClass.model;

import java.io.Serializable;

public class petClassVO implements Serializable {

	private Integer PET_CLASS_NO;
	private String PET_CLASS_NAME;
	private String PET_CLASS_STATE;
	
	public Integer getPET_CLASS_NO() {
		return PET_CLASS_NO;
	}
	public void setPET_CLASS_NO(Integer pET_CLASS_NO) {
		PET_CLASS_NO = pET_CLASS_NO;
	}
	public String getPET_CLASS_NAME() {
		return PET_CLASS_NAME;
	}
	public void setPET_CLASS_NAME(String pET_CLASS_NAME) {
		PET_CLASS_NAME = pET_CLASS_NAME;
	}
	public String getPET_CLASS_STATE() {
		return PET_CLASS_STATE;
	}
	public void setPET_CLASS_STATE(String pET_CLASS_STATE) {
		PET_CLASS_STATE = pET_CLASS_STATE;
	}
	
}
