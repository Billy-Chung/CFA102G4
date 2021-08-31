package com.promotions.model;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;







public class promotionsTest {

	public static void main(String[] args) {
		//實作DAO
		promotionsDAO_interface dao = new promotionsDAO();
		
		
//		// 新增
//		promotionsVO promotions1 = new promotionsVO();//promotionsVO()
////		promotions1.setPromot_no(4);//自動生成流水號
//		promotions1.setPromot_name("盛大開幕，期間限定大Fun送");
//		promotions1.setPromot_date_start(java.sql.Date.valueOf("2021-08-24"));
//		promotions1.setPromot_date_end(java.sql.Date.valueOf("2021-09-15"));
//		promotions1.setPromot_status("2");
//		promotions1.setPromot_type("0");
//		promotions1.setPromot_discount_type("1");
//		promotions1.setPromot_discount("9");//想為空
//		promotions1.setPromot_reduce("100");
//		promotions1.setPromot_comment("寵一而忠開幕特別企劃商品滿額折200");
//		
//		try {
//		byte[]pic=getPictureByteArray("images/promotions1.png");
//		promotions1.setPromot_photo(pic);
//		}catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		dao.add(promotions1);
//		System.out.println("新增成功");
		
		// 修改
		promotionsVO promotions2 = new promotionsVO();
		promotions2.setPromot_no(1);//修改目標
		promotions2.setPromot_name("盛大開幕(好評延長)");
		promotions2.setPromot_date_start(java.sql.Date.valueOf("2021-09-16"));
		promotions2.setPromot_date_end(java.sql.Date.valueOf("2021-09-24"));
		promotions2.setPromot_status("1");
		promotions2.setPromot_type("0");
		promotions2.setPromot_discount_type("0");
		promotions2.setPromot_discount("8.8");
		promotions2.setPromot_reduce("200");//想為空
		promotions2.setPromot_comment("寵一而忠開幕特別企劃商品全館9折");
		
		try {
		byte[]pic=getPictureByteArray("images/promotions2.png");
		promotions2.setPromot_photo(pic);
		}catch (IOException e) {			
			e.printStackTrace();
		}
		dao.update(promotions2);
		System.out.println("更新成功");

//		// 刪除，有綁FK參考表要先砍
//		dao.delete(1);
//		System.out.println("刪除成功");
		
//		// 主鍵查詢
//		promotionsVO promotions3 =dao.findByPromotNoPk(6);
//		System.out.print(promotions3.getPromot_no()+ ",");
//		System.out.print(promotions3.getPromot_name()+ ",");
//		System.out.print(promotions3.getPromot_date_start()+ ",");
//		System.out.print(promotions3.getPromot_date_end()+ ",");
//		System.out.print(promotions3.getPromot_status()+ ",");
//		System.out.print(promotions3.getPromot_type()+ ",");
//		System.out.print(promotions3.getPromot_discount_type()+ ",");
//		System.out.print(promotions3.getPromot_discount()+ ",");
//		System.out.print(promotions3.getPromot_reduce()+ ",");
//		System.out.print(promotions3.getPromot_comment()+ ",");
////		System.out.print(promotions3.getPromot_photo());

//		// 查詢
//		List<promotionsVO> list = dao.getAll();
//		for (promotionsVO promotions : list) {
//			System.out.print(promotions.getPromot_no() + ",");			
//			System.out.print(promotions.getPromot_name()+ ",");
//			System.out.print(promotions.getPromot_date_start()+ ",");
//			System.out.print(promotions.getPromot_date_end()+ ",");
//			System.out.print(promotions.getPromot_status()+ ",");
//			System.out.print(promotions.getPromot_type()+ ",");
//			System.out.print(promotions.getPromot_discount_type()+ ",");
//			System.out.print(promotions.getPromot_discount()+ ",");
//			System.out.print(promotions.getPromot_reduce()+ ",");
//			System.out.print(promotions.getPromot_comment()+ ",");
////			System.out.print(promotions.getPromot_photo());
//			System.out.println();
//		}
}

	//	將照片顯示出來
	public static void readPicture(byte[] bytes) throws IOException {
		String imgurl = "images/promotions1.png";
		FileOutputStream fos = new FileOutputStream(imgurl);
		fos.write(bytes);
		fos.flush();
		fos.close();
	}	

	//新增照片 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
		}
	
}
