package com.adopt.model;

import java.util.List;

public interface adoptMemberDAO_interface {
	public void insert(adoptMemberVO adoptMember);
	
	public void update(adoptMemberVO adoptMember);
	
	public void delete(Integer ADOPT_MEB_NO);
	
	public adoptMemberVO findByAdoptMebNoPK(Integer ADOPT_MEB_NO);
	
	public List<adoptMemberVO> getAllAdoptMeb();
}
