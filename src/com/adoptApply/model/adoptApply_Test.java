package com.adoptApply.model;

import java.util.List;

public class adoptApply_Test {
	
public static void main(String[] args) {
		
		adoptApplyVO aa = new adoptApplyVO();
		adoptApplyDAO_interface aadao = new adoptApplyDAO();
		
		//新增
//		aa.setAdopt_apply_no(2);
//		aa.setAdopt_meb_no(2);
//		aa.setGen_meb_no(2);
//		aa.setAdopt_pet_no(2);
//		aa.setAdopt_audit_state("1");
//		aa.setAdopt_apply_people_id("E192245198");
//		aa.setAdopt_apply_date(java.sql.Date.valueOf("2021-08-26"));
//		aa.setAdopt_apply_state("0");
//		aadao.insert(aa);
//		System.out.println("新增成功");
		
		//更新
//		aa.setAdopt_apply_no(1);
//		aa.setAdopt_meb_no(2);
//		aa.setGen_meb_no(2);
//		aa.setAdopt_pet_no(2);
//		aa.setAdopt_audit_state("2");
//		aa.setAdopt_apply_people_id("A112107917");
//		aa.setAdopt_apply_date(java.sql.Date.valueOf("2021-08-26"));
//		aa.setAdopt_apply_state("1");
//		aadao.update(aa);
//		System.out.println("更新成功");
		
		//刪除單一
//		aadao.delete(2);
//		System.out.println("刪除成功");
		
		//查詢單一
//		adoptApplyVO aa1 = aadao.findByPrimaryKey(1);
//		System.out.print(aa1.getAdopt_apply_no() + ",");
//		System.out.print(aa1.getAdopt_meb_no() + ",");
//		System.out.print(aa1.getGen_meb_no() + ",");
//		System.out.print(aa1.getAdopt_pet_no() + ",");
//		System.out.print(aa1.getAdopt_audit_state() + ",");
//		System.out.print(aa1.getAdopt_apply_people_id() + ",");
//		System.out.print(aa1.getAdopt_apply_date() + ",");
//		System.out.print(aa1.getAdopt_apply_state() + ",");
//		System.out.println();
		
		//查詢全部
		List<adoptApplyVO> list = aadao.getAll();
		for (adoptApplyVO aa2 : list) {
			System.out.print(aa2.getAdopt_apply_no() + ",");
			System.out.print(aa2.getAdopt_meb_no() + ",");
			System.out.print(aa2.getGen_meb_no() + ",");
			System.out.print(aa2.getAdopt_pet_no() + ",");
			System.out.print(aa2.getAdopt_audit_state() + ",");
			System.out.print(aa2.getAdopt_apply_people_id() + ",");
			System.out.print(aa2.getAdopt_apply_date() + ",");
			System.out.print(aa2.getAdopt_apply_state() + ",");
			System.out.println();
		}
	}
}
