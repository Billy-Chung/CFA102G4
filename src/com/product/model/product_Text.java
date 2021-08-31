package com.product.model;

import java.util.List;

public class product_Text {
	
public static void main(String[] args) {
		
		productVO p = new productVO();
		productDAO_interface pdao = new productDAO();
		
		//新增
//		p.setProduct_no(4);
//		p.setProduct_type_no(2);
//		p.setProduct_name("B牌貓咪飼料");
//		p.setProduct_price(999);
//		p.setProduct_comment("頂級鮭魚口味，並附贈主子試吃包");
//		p.setProduct_status("0");
//		p.setProduct_all_stars(0);
//		p.setProduct_all_comments(0);
//		pdao.insert(p);
//		System.out.println("新增成功");
		
		//更新
//		p.setProduct_no(3);
//		p.setProduct_type_no(2);
//		p.setProduct_name("A牌貓咪飼料");
//		p.setProduct_price(1100);
//		p.setProduct_comment("雞肉碗豆口味，特價中!");
//		p.setProduct_status("1");
//		p.setProduct_all_stars(5);
//		p.setProduct_all_comments(999);
//		pdao.update(p);
//		System.out.println("更新成功");
		
		//刪除單一
//		pdao.delete(2);
//		System.out.println("刪除成功");
		
		//查詢單一
//		productVO p1 = pdao.findByPrimaryKey(1);
//		System.out.print(p1.getProduct_no() + ",");
//		System.out.print(p1.getProduct_type_no() + ",");
//		System.out.print(p1.getProduct_name() + ",");
//		System.out.print(p1.getProduct_price() + ",");
//		System.out.print(p1.getProduct_comment() + ",");
//		System.out.print(p1.getProduct_status() + ",");
//		System.out.print(p1.getProduct_all_stars() + ",");
//		System.out.print(p1.getProduct_all_comments() + ",");
//		System.out.println();
		
		//查詢全部
		List<productVO> list = pdao.getAll();
		for (productVO p2 : list) {
			System.out.print(p2.getProduct_no() + ",");
			System.out.print(p2.getProduct_type_no() + ",");
			System.out.print(p2.getProduct_name() + ",");
			System.out.print(p2.getProduct_price() + ",");
			System.out.print(p2.getProduct_comment() + ",");
			System.out.print(p2.getProduct_status() + ",");
			System.out.print(p2.getProduct_all_stars() + ",");
			System.out.print(p2.getProduct_all_comments() + ",");
			System.out.println();
		}
	}
}
