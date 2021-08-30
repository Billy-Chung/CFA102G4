package com.adoptMemberNews.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class AdoptMemberNewService {
	AdoptMemberNews_interface dao;

	public AdoptMemberNewService() {
		dao = new AdoptMemberNewsDAO();
	}

	public AdoptMemberNewsVo insertAdoptMemberNew(Integer adopt_meb_no, String adopt_meb_news_title,
			String adopt_meb_news_comment, byte[] adopt_meb_news_photo, String adopt_meb_news_state,
			Date adopt_meb_news_date) {
		AdoptMemberNewsVo adoptMemberNew = new AdoptMemberNewsVo();

		adoptMemberNew.setAdopt_meb_no(adopt_meb_no);
		adoptMemberNew.setAdopt_meb_news_title(adopt_meb_news_title);
		adoptMemberNew.setAdopt_meb_news_comment(adopt_meb_news_comment);
		adoptMemberNew.setAdopt_meb_news_photo(adopt_meb_news_photo);
		adoptMemberNew.setAdopt_meb_news_state(adopt_meb_news_state);
		adoptMemberNew.setAdopt_meb_news_date(adopt_meb_news_date);
		adoptMemberNew = dao.insert(adoptMemberNew);

		return adoptMemberNew;
	}

	public void updateAdoptMemberNew(String adopt_meb_news_title, String adopt_meb_news_comment,
			byte[] adopt_meb_news_photo, String adopt_meb_news_state, Date adopt_meb_news_date,
			Integer adopt_meb_news_no) {
		AdoptMemberNewsVo adoptMemberNew = new AdoptMemberNewsVo();

		adoptMemberNew.setAdopt_meb_news_title(adopt_meb_news_title);
		adoptMemberNew.setAdopt_meb_news_comment(adopt_meb_news_comment);
		adoptMemberNew.setAdopt_meb_news_photo(adopt_meb_news_photo);
		adoptMemberNew.setAdopt_meb_news_state(adopt_meb_news_state);
		adoptMemberNew.setAdopt_meb_news_date(adopt_meb_news_date);
		adoptMemberNew.setAdopt_meb_news_no(adopt_meb_news_no);

		dao.update(adoptMemberNew);

	}

	public AdoptMemberNewsVo findByadoptMemberNewsNoPK(Integer adopt_meb_news_no) {

		AdoptMemberNewsVo adoptMemberNew = dao.findByadoptMemberNewsNoPK(adopt_meb_news_no);

		return adoptMemberNew;
	}

	public List<AdoptMemberNewsVo> findByAdoptMebNewsTitle(String adopt_meb_news_title) {

		List<AdoptMemberNewsVo> adoptMemberNews = dao.findByAdoptMebNewsTitle(adopt_meb_news_title);

		return adoptMemberNews;
	}

	public List<AdoptMemberNewsVo> getAll() {
		
		List<AdoptMemberNewsVo> adoptMemberNews = dao.getAlladoptMemberNews();

		return adoptMemberNews;
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
