package com.trackProduct.model;

import java.util.List;

public class trackProduct_Text {

	public static void main(String[] args) {
		
		trackProductVO tp = new trackProductVO();
		trackProductDAO_interface tpdao = new trackProductDAO();
		
		//新增
//		tp.setGen_meb_no(1);
//		tp.setProduct_no(1);
//		tpdao.insert(tp);
//		System.out.println("新增成功");
		
		//更新
//		tp.setGen_meb_no(1);
//		tp.setProduct_no(2);
//		tpdao.update(tp);
//		System.out.println("更新成功");
		
		//刪除
//		tpdao.delete(1,2);
//		System.out.println("刪除成功");
		
		//查詢單一
//		trackProductVO tp1 = tpdao.findByPrimaryKey(2,3);
//		System.out.print(tp1.getGen_meb_no() + ",");
//		System.out.print(tp1.getProduct_no() + ",");
//		System.out.println();
		
		//查詢全部
		List<trackProductVO> list = tpdao.getAll();
		for (trackProductVO tp2 : list) {
			System.out.print(tp2.getGen_meb_no() + ",");
			System.out.print(tp2.getProduct_no());
			System.out.println();
		}
	}
}
