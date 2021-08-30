package com.followPet.model;

import java.io.Serializable;

public class FollowPetVO implements Serializable {
	private Integer gen_meb_no;
	private Integer adopt_pet_no;
	
	public Integer getGen_meb_no() {
		return gen_meb_no;
	}
	public void setGen_meb_no(Integer gen_meb_no) {
		this.gen_meb_no = gen_meb_no;
	}
	public Integer getAdopt_pet_no() {
		return adopt_pet_no;
	}
	public void setAdopt_pet_no(Integer adopt_pet_no) {
		this.adopt_pet_no = adopt_pet_no;
	}
	
	
}
