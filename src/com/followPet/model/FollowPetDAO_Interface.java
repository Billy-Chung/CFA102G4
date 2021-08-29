package com.followPet.model;

import java.util.List;

public interface FollowPetDAO_Interface {
	public void insert(FollowPetVO fpVO);
	public void update(FollowPetVO fpVO);
	public void delete(Integer gmno,Integer apno);
	public FollowPetVO findByPrimaryKey(Integer gmno,Integer apno);
	public List<FollowPetVO> getAll(); 
}
