package com.generalMemberPetPhotos.model;

import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public interface GeneralMemberPetPhotosDAO_Interface {
	public void insert(GeneralMemberPetPhotosVO gmppVO);
	public void update(GeneralMemberPetPhotosVO gmppVO);
	public void delete(Integer gmpno);
	public GeneralMemberPetPhotosVO findByPrimaryKey(Integer gmpno);
	public List<GeneralMemberPetPhotosVO> getAll();
	
}
