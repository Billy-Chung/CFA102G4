package com.logistics.model;

import java.util.List;

import com.promotions.model.promotionsDAO;
import com.promotions.model.promotionsDAO_interface;
import com.promotions.model.promotionsVO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class logisticsTest {
	public static void main(String[] args) {
		//實作DAO
		logisticsDAO_interface dao = new logisticsDAO();
		// 新增
		logisticsVO logistics1 = new logisticsVO();
		logistics1.setLogistics_no(3);
		logistics1.setLogistics_name("黑貓宅急便");
		dao.add(logistics1);
		System.out.println("新增成功");
			
		// 修改
//		logisticsVO logistics2 = new logisticsVO();
//		logistics2.setLogistics_no(1);//修改目標
//		logistics2.setLogistics_name("統一速達");
//		dao.update(logistics2);
//		System.out.println("更新成功");
		
		// 刪除，有綁FK參考表要先砍
//		dao.delete(1);
//		System.out.println("刪除成功");
		
		//主鍵查詢
		logisticsVO logistics3 =dao.findByLogisticsPk(2);//主鍵名稱
//		System.out.print(logistics3.getLogistics_no()+ ",");
//		System.out.print(logistics3.getLogistics_name());
	
	    // 查詢
//		List<logisticsVO> list = dao.getAllLogistics();
//		for (logisticsVO logistics : list) {
//			System.out.print(logistics.getLogistics_no()+ ",");
//			System.out.print(logistics.getLogistics_name());		
//			System.out.println();
//		}		
	
	
	}
	
}
