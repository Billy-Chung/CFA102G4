package com.generalMember.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GmTest {

	public static void main(String[] args) throws IOException {
		//新增
//		GeneralMemberVO gm = new GeneralMemberVO();
//		GeneralMemberDAO_Interface gmdao = new GeneralMemberDAO();
//		gm.setGer_meb_no(6);
//		gm.setMeb_name("2");
//		gm.setPhone("2");
//		gm.setBirthday(java.sql.Date.valueOf("2016-01-01"));
//		byte[] pic = getPictureByteArray("image/123.jpg");
//		gm.setPhoto(pic);
//		gm.setComment("dddddd");
//		gm.setAddress("ddddddddd");
//		gm.setEmail("eric87897@yahoo.com.tw");
//		gm.setAccount("fiufniurf89808");
//		gm.setPassword("585858");
//		gm.setGender("1");
//		gm.setMeb_money(600);
//		gm.setPost_permission("1");
//		gmdao.insert(gm);
//		System.out.println("新增成功");

		
//		GeneralMemberVO gm = new GeneralMemberVO();
//		GeneralMemberDAO_Interface gmdao = new GeneralMemberDAO();
//		gm.setGer_meb_no(6);
//		gm.setMeb_name("3");
//		gm.setPhone("2");
//		gm.setBirthday(java.sql.Date.valueOf("2016-01-01"));
//		byte[] pic = getPictureByteArray("image/123.jpg");
//		gm.setPhoto(pic);
//		gm.setComment("dddddd");
//		gm.setAddress("ddddddddd");
//		gm.setEmail("eric87897@yahoo.com.tw");
//		gm.setAccount("fiufniurf89808");
//		gm.setPassword("585858");
//		gm.setGender("1");
//		gm.setMeb_money(600);
//		gm.setPost_permission("1");
//		gmdao.update(gm);
//		System.out.println("更新成功");
		
		
//		GeneralMemberVO gm = new GeneralMemberVO();
//		GeneralMemberDAO_Interface gmdao = new GeneralMemberDAO();
//		gmdao.delete(6);
//		System.out.println("刪除成功");
		
		//查詢單一
//		GeneralMemberDAO_Interface gmpdao = new GeneralMemberDAO();
//		GeneralMemberVO gm = gmpdao.findByPrimaryKey(2);
//		System.out.println(gm.getGer_meb_no() + ",");
//		System.out.println(gm.getMeb_name() + ",");
//		System.out.println(gm.getPhone() + ",");
//		System.out.println(gm.getBirthday() + ",");
//		System.out.println(gm.getPhoto() + ",");
//		System.out.println(gm.getComment() + ",");
//		System.out.println(gm.getAddress() + ",");
//		System.out.println(gm.getEmail() + ",");
//		System.out.println(gm.getAccount() + ",");
//		System.out.println(gm.getPassword() + ",");
//		System.out.println(gm.getGender() + ",");
//		System.out.println(gm.getMeb_money());
//		System.out.println(gm.getPost_permission());
//		
//		System.out.println();
		
		
		// 查詢全部

		GeneralMemberDAO_Interface gmpdao = new GeneralMemberDAO();
		List<GeneralMemberVO> gmlist = gmpdao.getAll();
		for (GeneralMemberVO gm : gmlist) {
			System.out.println(gm.getGer_meb_no() + ",");
			System.out.println(gm.getMeb_name() + ",");
			System.out.println(gm.getPhone() + ",");
			System.out.println(gm.getBirthday() + ",");
			System.out.println(gm.getPhoto() + ",");
			System.out.println(gm.getComment() + ",");
			System.out.println(gm.getAddress() + ",");
			System.out.println(gm.getEmail() + ",");
			System.out.println(gm.getAccount() + ",");
			System.out.println(gm.getPassword() + ",");
			System.out.println(gm.getGender() + ",");
			System.out.println(gm.getMeb_money());
			System.out.println(gm.getPost_permission());
			System.out.println();
		}
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
