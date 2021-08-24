package com.adopt.model;

import java.util.List;

public interface adoptMemberNews_interface {
	
	public adoptMemberNewsVo insert(adoptMemberNewsVo adoptMemberNews);
	
	public void update(adoptMemberNewsVo adoptMemberNews);

	public adoptMemberNewsVo findByadoptMemberNewsNoPK(Integer ADOPT_MEB_NEWS_NO);
	
	public List<adoptMemberNewsVo> getAlladoptMemberNews();
}
