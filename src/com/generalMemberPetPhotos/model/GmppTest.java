package com.generalMemberPetPhotos.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.generalMemberPet.model.GeneralMemberPetDAO;
import com.generalMemberPet.model.GeneralMemberPetDAO_Interface;
import com.generalMemberPet.model.GeneralMemberPetVO;
import com.storedValRecord.model.StoredValRecodeDAO;
import com.storedValRecord.model.StoredValRecodeDAO_Interface;
import com.storedValRecord.model.StoredValRecodeVO;

public class GmppTest {

	public static void main(String[] args) throws IOException {
		
		
		
		//新增
//		GeneralMemberPetPhotosVO gmpp = new GeneralMemberPetPhotosVO();
//		GeneralMemberPetPhotosDAO_Interface gmppdao = new GeneralMemberPetPhotosDAO();
//		gmpp.setGen_meb_photo_no(3);
//		gmpp.setGen_meb_no(3);
//		byte[] pic = getPictureByteArray("image/123.jpg");
//		gmpp.setGen_meb_pet_photo(pic);
//		gmppdao.insert(gmpp);
//		System.out.println("新增成功");
		
		//更新
//		GeneralMemberPetPhotosVO gmpp = new GeneralMemberPetPhotosVO();
//		GeneralMemberPetPhotosDAO_Interface gmppdao = new GeneralMemberPetPhotosDAO();
//		gmpp.setGen_meb_photo_no(1);
//		gmpp.setGen_meb_no(4);
//		byte[] pic = getPictureByteArray("image/123.jpg");
//		gmpp.setGen_meb_pet_photo(pic);
//		gmppdao.update(gmpp);
//		System.out.println("更新成功");
		
		//刪除
//		GeneralMemberPetPhotosVO gmpp = new GeneralMemberPetPhotosVO();
//		GeneralMemberPetPhotosDAO_Interface gmppdao = new GeneralMemberPetPhotosDAO();
//		gmppdao.delete(1);
//		System.out.println("刪除成功");
		
		
		//查詢單一
//		GeneralMemberPetPhotosDAO_Interface gmppdao = new GeneralMemberPetPhotosDAO();
//		GeneralMemberPetPhotosVO gmpps = gmppdao.findByPrimaryKey(2);
//		System.out.print(gmpps.getGen_meb_photo_no() + ",");
//		System.out.print(gmpps.getGen_meb_no() + ",");
//		System.out.print(gmpps.getGen_meb_pet_photo() + ",");
//		
//		System.out.println();
		
		//查詢全部
		GeneralMemberPetPhotosDAO_Interface gmppdao = new GeneralMemberPetPhotosDAO();		
		List<GeneralMemberPetPhotosVO> gmpplist = gmppdao.getAll();
			for (GeneralMemberPetPhotosVO gmpps :gmpplist) {
				System.out.print(gmpps.getGen_meb_photo_no() + ",");
				System.out.print(gmpps.getGen_meb_no() + ",");
				System.out.print(gmpps.getGen_meb_pet_photo() + ",");
				System.out.println();
				}
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
