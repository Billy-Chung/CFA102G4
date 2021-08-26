package com.adoptPetPhoto.model;

import java.io.Serializable;


public class adoptPetPhotoVO implements Serializable {
	
	private Integer ADOPT_PET_PHOTO_NO;
	private Integer ADOPT_PET_NO;	
	private byte[] ADOPT_PET_PHOTO;
	
	public Integer getADOPT_PET_PHOTO_NO() {
		return ADOPT_PET_PHOTO_NO;
	}
	public void setADOPT_PET_PHOTO_NO(Integer aDOPT_PET_PHOTO_NO) {
		ADOPT_PET_PHOTO_NO = aDOPT_PET_PHOTO_NO;
	}
	public Integer getADOPT_PET_NO() {
		return ADOPT_PET_NO;
	}
	public void setADOPT_PET_NO(Integer aDOPT_PET_NO) {
		ADOPT_PET_NO = aDOPT_PET_NO;
	}
	public byte[] getADOPT_PET_PHOTO() {
		return ADOPT_PET_PHOTO;
	}
	public void setADOPT_PET_PHOTO(byte[] aDOPT_PET_PHOTO) {
		ADOPT_PET_PHOTO = aDOPT_PET_PHOTO;
	}
	
	
	
}
