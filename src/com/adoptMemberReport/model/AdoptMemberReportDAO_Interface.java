package com.adoptMemberReport.model;

import java.util.*;

public interface AdoptMemberReportDAO_Interface  {
	public void insert(AdoptMemberReportVO amrVO);
	public void update(AdoptMemberReportVO amrVO);
	public void delete(Integer amrno);
	public AdoptMemberReportVO findByPrimaryKey(Integer amrno);
	public List<AdoptMemberReportVO> getAll();
	
	

}
