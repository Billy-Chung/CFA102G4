package com.adopt.model;

import java.util.List;

public interface adoptMemberDAO_interface {
	public adoptMemberVO insert(adoptMemberVO adoptMember);
	
	public void update(adoptMemberVO adoptMember);

	public adoptMemberVO findByAdoptMebNoPK(Integer ADOPT_MEB_NO);
	
	public List<adoptMemberVO> findByAdoptMebName(String ADOPT_MEB_NAME);
	
	public List<adoptMemberVO> getAllAdoptMeb();
}
