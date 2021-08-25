package com.adoptMemberNews.model;

import java.util.List;

public class adoptMemberNewsDAO implements adoptMemberNews_interface {
	
	
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	

	@Override
	public adoptMemberNewsVo insert(adoptMemberNewsVo adoptMemberNews) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(adoptMemberNewsVo adoptMemberNews) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public adoptMemberNewsVo findByadoptMemberNewsNoPK(Integer ADOPT_MEB_NEWS_NO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<adoptMemberNewsVo> findByAdoptMebNewsTitle(String ADOPT_MEB_NEWS_TITLE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<adoptMemberNewsVo> getAlladoptMemberNews() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		
	}
}
