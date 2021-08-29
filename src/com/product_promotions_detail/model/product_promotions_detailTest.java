package com.product_promotions_detail.model;

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

public class product_promotions_detailTest {
	public static void main(String[] args) {
		//實作DAO
		product_promotions_detailDAO_interface dao = new product_promotions_detailDAO();
		// 新增
//		product_promotions_detailVO product_promotions_detail1 = new product_promotions_detailVO();
//		product_promotions_detail1.setPromot_no(1);
//		product_promotions_detail1.setProduct_no(2);
//		product_promotions_detail1.setProduct_pro_price(1000);
//		product_promotions_detail1.setProduct_pro_special_price(915);							
//		dao.add(product_promotions_detail1);
//		System.out.println("新增成功");
		
		// 修改
//		product_promotions_detailVO product_promotions_detail2 = new product_promotions_detailVO();
//		product_promotions_detail2.setProduct_pro_detail_no(2);//修改目標
//		product_promotions_detail2.setPromot_no(1);
//		product_promotions_detail2.setProduct_no(3);
//		product_promotions_detail2.setProduct_pro_price(500);
//		product_promotions_detail2.setProduct_pro_special_price(168);
//		dao.update(product_promotions_detail2);
//		System.out.println("更新成功");
		
		// 刪除，有綁FK參考表要先砍
//		dao.delete(1);
//		System.out.println("刪除成功");
		
		//主鍵查詢
//		product_promotions_detailVO product_promotions_detail3 =dao.findByProductPro_DetailPK(2);//主鍵名稱
//		System.out.print(product_promotions_detail3.getProduct_pro_detail_no()+ ",");
//		System.out.print(product_promotions_detail3.getPromot_no()+ ",");
//		System.out.print(product_promotions_detail3.getProduct_no()+ ",");
//		System.out.print(product_promotions_detail3.getProduct_pro_price()+ ",");
//		System.out.print(product_promotions_detail3.getProduct_pro_special_price());
		
	    // 查詢
//		List<product_promotions_detailVO> list = dao.getAllproductPromotions_Detail();
//		for (product_promotions_detailVO product_promotions_detail : list) {
//			System.out.print(product_promotions_detail.getProduct_pro_detail_no()+ ",");
//			System.out.print(product_promotions_detail.getPromot_no()+ ",");
//			System.out.print(product_promotions_detail.getProduct_no()+ ",");
//			System.out.print(product_promotions_detail.getProduct_pro_price()+ ",");
//			System.out.print(product_promotions_detail.getProduct_pro_special_price());			
//			System.out.println();
//		}		
	}
}