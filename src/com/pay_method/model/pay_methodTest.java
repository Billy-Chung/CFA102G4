package com.pay_method.model;

import java.util.List;

import com.logistics.model.logisticsDAO;
import com.logistics.model.logisticsDAO_interface;
import com.logistics.model.logisticsVO;
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


public class pay_methodTest {
	public static void main(String[] args) {
		//實作DAO
		pay_methodDAO_interface dao = new pay_methodDAO();

		
//		// 新增
//		pay_methodVO pay_method1 = new pay_methodVO();
//		pay_method1.setPay_no(11);
//		pay_method1.setPay_name("臺灣pay");
//		dao.add(pay_method1);
//		System.out.println("新增成功");
			
		// 修改
//		pay_methodVO pay_method2 = new pay_methodVO();
//		pay_method2.setPay_no(1);//修改目標
//		pay_method2.setPay_name("applepay");
//		dao.update(pay_method2);
//		System.out.println("更新成功");
		
		// 刪除，有綁FK參考表要先砍
//		dao.delete(1);
//		System.out.println("刪除成功");
		
		//主鍵查詢
//		pay_methodVO pay_method3 =dao.findPayMethodPk(1);//主鍵名稱
//		System.out.print(pay_method3.getPay_no()+ ",");
//		System.out.print(pay_method3.getPay_name());
	
	    // 查詢
		List<pay_methodVO> list = dao.getAllpay_method();
		for (pay_methodVO pay_method : list) {
			System.out.print(pay_method.getPay_no()+ ",");
			System.out.print(pay_method.getPay_name());
			System.out.println();
		}		
	
	
	
	
	
	
	}	
	
	
	
}
