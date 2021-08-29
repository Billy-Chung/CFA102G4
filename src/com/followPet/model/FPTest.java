package com.followPet.model;

import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class FPTest {

	public static void main(String[] args) {
		//新增
//		FollowPetVO fp = new FollowPetVO();
//		FollowPetDAO_Interface fpdao = new FollowPetDAO();
//		fp.setGen_meb_no(4);
//		fp.setAdopt_pet_no(3);
//		fpdao.insert(fp);
//		System.out.println("新增成功");
		
		//更新(雙主鍵不ok)
		FollowPetVO fp = new FollowPetVO();
		FollowPetDAO_Interface fpdao = new FollowPetDAO();
		fp.setGen_meb_no(4);
		fp.setAdopt_pet_no(4);
//		
//		
//		fpdao.update(fp);
//		System.out.println("更新成功");
		
		//刪除
//		FollowPetVO fp = new FollowPetVO();
//		FollowPetDAO_Interface fpdao = new FollowPetDAO();
//		fpdao.delete(1,2);
		
		//查詢單一
//		FollowPetDAO_Interface fpdao = new FollowPetDAO();
//		FollowPetVO fp1 = fpdao.findByPrimaryKey(2,3);
//				System.out.print(fp1.getGen_meb_no() + ",");
//				System.out.print(fp1.getAdopt_pet_no() + ",");
//				System.out.println();
		
		//查詢全部
//		FollowPetDAO_Interface fpdao = new FollowPetDAO();
//		List<FollowPetVO> list = fpdao.getAll();
//		for (FollowPetVO fp1 : list) {
//			System.out.print(fp1.getGen_meb_no() + ",");
//			System.out.print(fp1.getAdopt_pet_no());
//	
//			System.out.println();
//		}
	}
}
