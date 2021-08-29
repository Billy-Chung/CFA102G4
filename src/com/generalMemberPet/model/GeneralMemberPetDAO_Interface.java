package com.generalMemberPet.model;

import java.util.List;

public interface GeneralMemberPetDAO_Interface {
	public void insert(GeneralMemberPetVO gmpVO);
	public void update(GeneralMemberPetVO gmpVO);
	public void delete(Integer gmpno);
	public GeneralMemberPetVO findByPrimaryKey(Integer gmpno);
	public List<GeneralMemberPetVO> getAll();
}
