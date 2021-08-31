package com.order_form.model;

import java.util.List;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class order_formTest {
		public static void main(String[] args) {
			//實作DAO
			order_formDAO_interface dao = new order_formDAO();

			
//////有問題無法執行新增 外來鍵			
//			// 新增
			order_formVO order_form1= new order_formVO();
			order_form1.setGen_meb_no(1);
			order_form1.setPay_no(1);
			order_form1.setLogistics_no(1);
			order_form1.setPromot_no(1);
			order_form1.setBefort_amount(1800);
			order_form1.setOrder_amount(1700);
			order_form1.setDelivery_address("桃園市龜山區萬壽路二段45號");
			order_form1.setOrder_time(java.sql.Date.valueOf("2021-08-29"));
			order_form1.setOrder_status("1");	
			dao.add(order_form1);
////			System.out.println("新增成功");

////有問題無法執行 多一個?
//			// 修改
//			order_formVO order_form2 = new order_formVO();
//			order_form2.setOrder_no(1);//修改目標
//			order_form2.setGen_meb_no(1);
//			order_form2.setPay_no(1);
//			order_form2.setLogistics_no(1);
//			order_form2.setPromot_no(1);
//			order_form2.setBefort_amount(100);
//			order_form2.setOrder_amount(89);
//			order_form2.setDelivery_address("桃園市桃園區中正1號");
//			order_form2.setOrder_time(java.sql.Date.valueOf("2021-08-30"));
//			order_form2.setOrder_status("1");				
//			dao.update(order_form2);
//			System.out.println("更新成功");
			
//			 刪除，有綁FK參考表要先砍
//			dao.delete(1);
//			System.out.println("刪除成功");
			
			//主鍵查詢
//			order_formVO order_form3 =dao.findOrderFormPk(1);//主鍵名稱
//			System.out.print(order_form3.getOrder_no()+ ",");
//			System.out.print(order_form3.getGen_meb_no()+ ",");
//			System.out.print(order_form3.getPay_no()+ ",");
//			System.out.print(order_form3.getLogistics_no()+ ",");
//			System.out.print(order_form3.getPromot_no()+ ",");	
//			System.out.print(order_form3.getBefort_amount());
//			System.out.print(order_form3.getOrder_amount());
//			System.out.print(order_form3.getDelivery_address());
//			System.out.print(order_form3.getOrder_time());
//			System.out.print(order_form3.getOrder_status());

			
		    // 查詢
//			List<order_formVO> list = dao.getAllorderForm();		
//			for (order_formVO order_form : list) {
//				order_formVO order_form3 =dao.findOrderFormPk(1);
//				System.out.print(order_form3.getOrder_no()+ ",");
//				System.out.print(order_form3.getGen_meb_no()+ ",");
//				System.out.print(order_form3.getPay_no()+ ",");
//				System.out.print(order_form3.getLogistics_no()+ ",");
//				System.out.print(order_form3.getPromot_no()+ ",");	
//				System.out.print(order_form3.getBefort_amount());
//				System.out.print(order_form3.getOrder_amount());
//				System.out.print(order_form3.getDelivery_address());
//				System.out.print(order_form3.getOrder_time());
//				System.out.print(order_form3.getOrder_status());			
//				System.out.println();
//			}		
		}
	}
	
	
	
	
	
