package com.general_member_pet_photos.model;

import java.util.List;

import com.adopt_member_report.model.AdoptMemberReportVO;

public interface GeneralMemberPetPhotosDAO_Interface {
	public void insert(GeneralMemberPetPhotosVO gmppVO);
	public void update(GeneralMemberPetPhotosVO gmppVO);
	public void delete(Integer gmpno);
	public GeneralMemberPetPhotosVO findByPrimaryKey(Integer gmpno);
	public List<GeneralMemberPetPhotosVO> getAll();
	
}
