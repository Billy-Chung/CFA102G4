package com.adoptMember.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class AdoptMemberService {
	private AdoptMemberDAO_interface dao;

	public AdoptMemberService() {
		dao = new AdoptMemberDAO();
	}

	public AdoptMemberVO insertAdoptMember(String adopt_meb_name, String adopt_meb_comment, byte[] adopt_meb_photo,
			String adopt_meb_address, String adopt_meb_phone, String adopt_meb_email, String adopt_meb_account,
			String adopt_meb_password, String adopt_meb_state, String adopt_meb_auth, String adopt_meb_holiday,
			String adopt_meb_limit) {
		AdoptMemberVO adoptMember = new AdoptMemberVO();

		adoptMember.setAdopt_meb_name(adopt_meb_name);
		adoptMember.setAdopt_meb_comment(adopt_meb_comment);
		adoptMember.setAdopt_meb_photo(adopt_meb_photo);
		adoptMember.setAdopt_meb_address(adopt_meb_address);
		adoptMember.setAdopt_meb_phone(adopt_meb_phone);
		adoptMember.setAdopt_meb_email(adopt_meb_email);
		adoptMember.setAdopt_meb_account(adopt_meb_account);
		adoptMember.setAdopt_meb_password(adopt_meb_password);
		adoptMember.setAdopt_meb_state(adopt_meb_state);
		adoptMember.setAdopt_meb_auth(adopt_meb_auth);
		adoptMember.setAdopt_meb_holiday(adopt_meb_holiday);
		adoptMember.setAdopt_meb_limit(adopt_meb_limit);
		adoptMember = dao.insert(adoptMember);

		return adoptMember;
	}

	public void updateAdoptMember(String adopt_meb_name, String adopt_meb_comment, byte[] adopt_meb_photo,
			String adopt_meb_address, String adopt_meb_phone, String adopt_meb_email, String adopt_meb_account,
			String adopt_meb_password, String adopt_meb_state, String adopt_meb_auth , String adopt_meb_holiday,
			String adopt_meb_limit,Integer adopt_meb_no) {
		AdoptMemberVO adoptMember = new AdoptMemberVO();
		
		adoptMember.setAdopt_meb_name(adopt_meb_name);
		adoptMember.setAdopt_meb_comment(adopt_meb_comment);
		adoptMember.setAdopt_meb_photo(adopt_meb_photo);
		adoptMember.setAdopt_meb_address(adopt_meb_address);
		adoptMember.setAdopt_meb_phone(adopt_meb_phone);
		adoptMember.setAdopt_meb_email(adopt_meb_email);
		adoptMember.setAdopt_meb_account(adopt_meb_account);
		adoptMember.setAdopt_meb_password(adopt_meb_password);
		adoptMember.setAdopt_meb_state(adopt_meb_state);
		adoptMember.setAdopt_meb_auth(adopt_meb_auth);
		adoptMember.setAdopt_meb_holiday(adopt_meb_holiday);
		adoptMember.setAdopt_meb_limit(adopt_meb_limit);
		adoptMember.setAdopt_meb_no(adopt_meb_no);
		
		dao.update(adoptMember);	
		
	}

	public AdoptMemberVO findByAdoptMebNoPK(Integer adopt_meb_no) {
		AdoptMemberVO adoptMember = new AdoptMemberVO();
		
		adoptMember = dao.findByAdoptMebNoPK(adopt_meb_no);
		
		return adoptMember;
	}
	
	public List<AdoptMemberVO> findByAdoptMebName(String adopt_meb_name){
		
		List<AdoptMemberVO> adoptMember = dao.findByAdoptMebName(adopt_meb_name);
		
		return adoptMember;
	}


	public  List<AdoptMemberVO> getAll(){
		
		List<AdoptMemberVO> adoptMember = dao.getAllAdoptMeb();
		
		return adoptMember;
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
