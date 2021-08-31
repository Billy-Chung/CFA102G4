package com.adoptMember.model;

import java.util.List;

public interface AdoptMemberDAO_interface {
	public AdoptMemberVO insert(AdoptMemberVO adoptMember);
	
	public void update(AdoptMemberVO adoptMember);

	public AdoptMemberVO findByAdoptMebNoPK(Integer adopt_meb_no);
	
	public List<AdoptMemberVO> findByAdoptMebName(String adopt_meb_name);
	
	public List<AdoptMemberVO> getAllAdoptMeb();
}
