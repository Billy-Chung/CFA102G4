package com.adoptMemberReport.model;

import java.util.List;
import java.util.Scanner;

public class AMRDAOTest {

	public static void main(String[] args) {
		
		
//		//新增
//		AdoptMemberReportVO amr = new AdoptMemberReportVO();
//		AdoptMemberReportDAO_Interface amrdao = new AdoptMemberReportDAO();
//		amr.setAdopt_meb_report_no(3);
//		amr.setAdopt_meb_no(2);
//		amr.setGen_meb_no(2);
//		amr.setEport_comment("ddddd");
//		amr.setAdopt_meb_report_state("1");
//		amr.setAdopt_meb_report_date(java.sql.Date.valueOf("2016-01-01"));
//		amrdao.insert(amr);
//		System.out.println("新增成功");
		
		//更新
		AdoptMemberReportVO amr = new AdoptMemberReportVO();
		AdoptMemberReportDAO_Interface amrdao1 = new AdoptMemberReportDAO();
		
		amr.setAdopt_meb_report_no(2);
		amr.setAdopt_meb_no(2);
		amr.setGen_meb_no(2);
		amr.setEport_comment("dsdsdde");
		amr.setAdopt_meb_report_state("1");
		amr.setAdopt_meb_report_date(java.sql.Date.valueOf("2016-04-01"));
		
		amrdao1.update(amr);
		System.out.println("更新成功");
		
		//刪除單一
//		amrdao1.delete(3);
		
		//查詢單一
		AdoptMemberReportVO amr1 = amrdao1.findByPrimaryKey(2);
		System.out.print(amr1.getAdopt_meb_report_no() + ",");
		System.out.print(amr1.getAdopt_meb_no() + ",");
		System.out.print(amr1.getGen_meb_no() + ",");
		System.out.print(amr1.getEport_comment() + ",");
		System.out.print(amr1.getAdopt_meb_report_state() + ",");
		System.out.print(amr1.getAdopt_meb_report_date() + ",");
		System.out.println();
		
		//查詢全部
//		List<AdoptMemberReportVO> list = amrdao1.getAll();
//		for (AdoptMemberReportVO amp : list) {
//			System.out.print(amp.getAdopt_meb_report_no() + ",");
//			System.out.print(amp.getAdopt_meb_no() + ",");
//			System.out.print(amp.getGen_meb_no() + ",");
//			System.out.print(amp.getEport_comment() + ",");
//			System.out.print(amp.getAdopt_meb_report_state() + ",");
//			System.out.print(amp.getAdopt_meb_report_date() + ",");
//			System.out.println();
//		}
		
	}

}