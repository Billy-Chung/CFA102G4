package com.generalMemberPet.model;

import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportDAO;
import com.adoptMemberReport.model.AdoptMemberReportDAO_Interface;
import com.adoptMemberReport.model.AdoptMemberReportVO;

public class GmpTest {
	public static void main(String[] args) {
		// 新增
//	GeneralMemberPetVO gmp = new GeneralMemberPetVO();
//	GeneralMemberPetDAO_Interface gmpdao = new GeneralMemberPetDAO();
//	gmp.setGen_meb_pet_no(3);
//	gmp.setAdopt_pet_no(2);
//	gmp.setPet_class_no(2);
//	gmp.setGen_meb_no(5);
//	gmp.setGen_meb_pet_breeds("1");
//	gmp.setGen_meb_pet_gender("1");
//	gmp.setGen_meb_pet_chip("13232");
//	gmp.setGen_meb_pet_sterilization("1");
//	gmp.setGen_pet_color("1");
//	gmp.setGen_pet_comment("1");
//	gmp.setGen_pet_state("1");
//	gmpdao.insert(gmp);
//	System.out.println("新增成功");

		 //更新
		GeneralMemberPetVO gmp = new GeneralMemberPetVO();
		GeneralMemberPetDAO_Interface gmpdao = new GeneralMemberPetDAO();
		
		gmp.setGen_meb_pet_no(4);
		gmp.setAdopt_pet_no(3);
		gmp.setPet_class_no(2);
		gmp.setGen_meb_no(5);
		gmp.setGen_meb_pet_breeds("1");
		gmp.setGen_meb_pet_gender("1");
		gmp.setGen_meb_pet_chip("132322");
		gmp.setGen_meb_pet_sterilization("1");
		gmp.setGen_pet_color("1");
		gmp.setGen_pet_comment("1");
		gmp.setGen_pet_state("0");
		gmpdao.update(gmp);
		System.out.println("更新成功");

		// 刪除
//		GeneralMemberPetVO gmp = new GeneralMemberPetVO();
//		GeneralMemberPetDAO_Interface gmpdao = new GeneralMemberPetDAO();
//		gmpdao.delete(3);
//		System.out.println("已刪除");

		// 查詢單一

//		GeneralMemberPetDAO_Interface gmpdao = new GeneralMemberPetDAO();
//		GeneralMemberPetVO gmp = gmpdao.findByPrimaryKey(2);
//		System.out.println(gmp.getGen_meb_pet_no() + ",");
//		System.out.println(gmp.getAdopt_pet_no() + ",");
//		System.out.println(gmp.getGen_meb_no() + ",");
//		System.out.println(gmp.getPet_class_no() + ",");
//		System.out.println(gmp.getGen_meb_no() + ",");
//		System.out.println(gmp.getGen_meb_pet_breeds() + ",");
//		System.out.println(gmp.getGen_meb_pet_gender() + ",");
//		System.out.println(gmp.getGen_meb_pet_chip() + ",");
//		System.out.println(gmp.getGen_meb_pet_sterilization() + ",");
//		System.out.println(gmp.getGen_pet_color() + ",");
//		System.out.println(gmp.getGen_pet_comment() + ",");
//		System.out.println(gmp.getGen_pet_state());
//		System.out.println();

		// 查詢全部

//		GeneralMemberPetDAO_Interface gmpdao = new GeneralMemberPetDAO();
//		List<GeneralMemberPetVO> list = gmpdao.getAll();
//		for (GeneralMemberPetVO gmp : list) {
//			System.out.println(gmp.getGen_meb_pet_no() + ",");
//			System.out.println(gmp.getAdopt_pet_no() + ",");
//			System.out.println(gmp.getGen_meb_no() + ",");
//			System.out.println(gmp.getPet_class_no() + ",");
//			System.out.println(gmp.getGen_meb_no() + ",");
//			System.out.println(gmp.getGen_meb_pet_breeds() + ",");
//			System.out.println(gmp.getGen_meb_pet_gender() + ",");
//			System.out.println(gmp.getGen_meb_pet_chip() + ",");
//			System.out.println(gmp.getGen_meb_pet_sterilization() + ",");
//			System.out.println(gmp.getGen_pet_color() + ",");
//			System.out.println(gmp.getGen_pet_comment() + ",");
//			System.out.println(gmp.getGen_pet_state());
//			System.out.println();
//		}
	}
}

