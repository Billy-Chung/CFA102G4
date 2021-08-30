package com.generalMemberPetPhotos.model;

import java.io.Serializable;
import java.sql.Blob;

public class GeneralMemberPetPhotosVO implements Serializable {
	private Integer gen_meb_photo_no;
	private Integer gen_meb_no;
	private byte[] gen_meb_pet_photo;
	
	public Integer getGen_meb_photo_no() {
		return gen_meb_photo_no;
	}
	public void setGen_meb_photo_no(Integer gen_meb_photo_no) {
		this.gen_meb_photo_no = gen_meb_photo_no;
	}
	public Integer getGen_meb_no() {
		return gen_meb_no;
	}
	public void setGen_meb_no(Integer gen_meb_no) {
		this.gen_meb_no = gen_meb_no;
	}
	public byte[] getGen_meb_pet_photo() {
		return gen_meb_pet_photo;
	}
	public void setGen_meb_pet_photo(byte[] gen_meb_pet_photo) {
		this.gen_meb_pet_photo = gen_meb_pet_photo;
	}

	
}
