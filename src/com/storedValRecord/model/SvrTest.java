package com.storedValRecord.model;

import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class SvrTest {

	public static void main(String[] args) {
		
		//新增
//		StoredValRecodeVO svr = new StoredValRecodeVO();
//		StoredValRecodeDAO_Interface svrdao = new StoredValRecodeDAO();
//		svr.setStored_val_recode_no(6);
//		svr.setGer_meb_no(2);
//		svr.setStored_val_date(java.sql.Date.valueOf("2016-01-01"));
//		svr.setStored_val_amout(700);
//		
//		svrdao.insert(svr);
//		System.out.println("新增成功");
		
		//更新
//		StoredValRecodeVO svr = new StoredValRecodeVO();
//		StoredValRecodeDAO_Interface svrdao = new StoredValRecodeDAO();
//		svr.setStored_val_recode_no(6);
//		svr.setGer_meb_no(2);
//		svr.setStored_val_date(java.sql.Date.valueOf("2016-01-01"));
//		svr.setStored_val_amout(800);
//		
//		
//		svrdao.update(svr);
//		System.out.println("更新成功");
		
		//刪除
//		StoredValRecodeVO svr = new StoredValRecodeVO();
//		StoredValRecodeDAO_Interface svrdao = new StoredValRecodeDAO();
//		svrdao.delete(6);
//		System.out.println("刪除成功");
		
		
		//查詢單一
//		StoredValRecodeDAO_Interface svrdao = new StoredValRecodeDAO();
//		StoredValRecodeVO svr = svrdao.findByPrimaryKey(2);
//		System.out.print(svr.getStored_val_recode_no() + ",");
//		System.out.print(svr.getGer_meb_no() + ",");
//		System.out.print(svr.getStored_val_date() + ",");
//		System.out.print(svr.getStored_val_amout() + ",");
//		System.out.println();
		
		//查詢全部
		StoredValRecodeDAO_Interface svrdao = new StoredValRecodeDAO();
		List<StoredValRecodeVO> svrlist = svrdao.getAll();
		for (StoredValRecodeVO svr : svrlist) {
			System.out.print(svr.getStored_val_recode_no() + ",");
			System.out.print(svr.getGer_meb_no() + ",");
			System.out.print(svr.getStored_val_date() + ",");
			System.out.print(svr.getStored_val_amout() + ",");
			System.out.println();
		}
	}

}
