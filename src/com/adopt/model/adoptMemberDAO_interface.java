package com.adopt.model;

import java.util.List;

public interface adoptMemberDAO_interface {
	public adoptMemberVO insert(adoptMemberVO adoptMember);
	
	public void update(adoptMemberVO adoptMember);
	
	public void delete(Integer adoptMebNo);
	
	public adoptMemberVO findByAdoptMebNoPK(Integer adoptMebNo);
	
	public List<adoptMemberVO> getAllAdoptMeb();
}
