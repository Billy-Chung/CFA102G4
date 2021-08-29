package com.adoptPetPhoto.model;

import java.io.Serializable;


public class AdoptPetPhotoVO implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private Integer adopt_pet_photo_no;
	private Integer adopt_pet_no;	
	private byte[] adopt_pet_photo;
	
	
	public Integer getAdopt_pet_photo_no() {
		return adopt_pet_photo_no;
	}
	public void setAdopt_pet_photo_no(Integer adopt_pet_photo_no) {
		this.adopt_pet_photo_no = adopt_pet_photo_no;
	}
	public Integer getAdopt_pet_no() {
		return adopt_pet_no;
	}
	public void setAdopt_pet_no(Integer adopt_pet_no) {
		this.adopt_pet_no = adopt_pet_no;
	}
	public byte[] getAdopt_pet_photo() {
		return adopt_pet_photo;
	}
	public void setAdopt_pet_photo(byte[] adopt_pet_photo) {
		this.adopt_pet_photo = adopt_pet_photo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
