package com.logistics.model;

import com.logistics.model.logisticsDAO;
import com.logistics.model.logisticsDAO_interface;
import com.logistics.model.logisticsVO;
import com.order_detail.model.order_detailDAO;
import com.order_detail.model.order_detailDAO_interface;
import com.order_detail.model.order_detailVO;
import com.pay_method.model.pay_methodVO;
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
import java.util.List;

public class order_detailTest {
	public static void main(String[] args) {
		//實作DAO
		order_detailDAO_interface dao = new order_detailDAO();

		
		// 新增
//		order_detailVO order_detail1 = new order_detailVO();
//		order_detail1.setOrder_no(1);
//		order_detail1.setProduct_no(1);
//		order_detail1.setOrder_product_number(3);
//		order_detail1.setOrder_product_comment("毛小孩非常喜歡");
//		order_detail1.setOrder_product_stars(5);
//		order_detail1.setOrder_product_comment_state("1");	
//		dao.add(order_detail1);
//		System.out.println("新增成功");
			
		// 修改
//		order_detailVO order_detail2 = new order_detailVO();			
//		order_detail2.setOrder_detail_no(1);//修改目標
//		order_detail2.setOrder_no(1);
//		order_detail2.setProduct_no(1);
//		order_detail2.setOrder_product_number(3);
//		order_detail2.setOrder_product_comment("貓砂吸收不好");
//		order_detail2.setOrder_product_stars(5);
//		order_detail2.setOrder_product_comment_state("1");		
//		dao.update(order_detail2);
//		System.out.println("更新成功");
		
		// 刪除，有綁FK參考表要先砍
//		dao.delete(1);
//		System.out.println("刪除成功");
		
		//主鍵查詢
//		order_detailVO order_detail3 =dao.findOrderDetailPk(1);//主鍵名稱
//		System.out.print(order_detail3.getOrder_detail_no()+ ",");
//		System.out.print(order_detail3.getOrder_no()+ ",");
//		System.out.print(order_detail3.getProduct_no()+ ",");
//		System.out.print(order_detail3.getOrder_product_number()+ ",");
//		System.out.print(order_detail3.getOrder_product_comment()+ ",");
//		System.out.print(order_detail3.getOrder_product_stars()+ ",");
//		System.out.print(order_detail3.getOrder_product_comment_state());
		
	    // 查詢
		List<order_detailVO> list = dao.getAllorder_detail();
		for (order_detailVO order_detail : list) {
			System.out.print(order_detail.getOrder_detail_no()+ ",");
			System.out.print(order_detail.getOrder_no()+ ",");
			System.out.print(order_detail.getProduct_no()+ ",");
			System.out.print(order_detail.getOrder_product_number()+ ",");
			System.out.print(order_detail.getOrder_product_comment()+ ",");
			System.out.print(order_detail.getOrder_product_stars()+ ",");
			System.out.print(order_detail.getOrder_product_comment_state());												
			System.out.println();
		}			
	}	
	
}
