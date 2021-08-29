package com.productType.model;

import java.util.List;

public class productType_Text {
	
public static void main(String[] args) {
		
		productTypeVO pt = new productTypeVO();
		productTypeDAO_interface ptdao = new productTypeDAO();
		
		//新增
//		pt.setProduct_type_no(3);
//		pt.setProduct_type_name("綜合寵物飼料");
//		ptdao.insert(pt);
//		System.out.println("新增成功");
		
		//更新
//		pt.setProduct_type_no(2);
//		pt.setProduct_type_name("主子的滿漢全席");
//		ptdao.update(pt);
//		System.out.println("更新成功");
		
		//刪除單一
//		ptdao.delete(2);
//		System.out.println("刪除成功");
		
		//查詢單一
//		productTypeVO pt1 = ptdao.findByPrimaryKey(1);
//		System.out.print(pt1.getProduct_type_no() + ",");
//		System.out.print(pt1.getProduct_type_name() + ",");
//		System.out.println();
		
		//查詢全部
		List<productTypeVO> list = ptdao.getAll();
		for (productTypeVO pt2 : list) {
			System.out.print(pt2.getProduct_type_no() + ",");
			System.out.print(pt2.getProduct_type_name() + ",");
			System.out.println();
		}
	}
}