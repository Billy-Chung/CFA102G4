package com.adoptMemberNews.model;

import java.util.List;

public interface AdoptMemberNews_interface {
	
	public AdoptMemberNewsVo insert(AdoptMemberNewsVo adoptMemberNews);
	
	public void update(AdoptMemberNewsVo adoptMemberNews);

	public AdoptMemberNewsVo findByadoptMemberNewsNoPK(Integer adopt_meb_news_no);
	
	public List<AdoptMemberNewsVo> findByAdoptMebNewsTitle(String adopt_meb_news_title);
	
	public List<AdoptMemberNewsVo> getAlladoptMemberNews();
}
