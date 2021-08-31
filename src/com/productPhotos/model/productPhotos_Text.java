package com.productPhotos.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class productPhotos_Text {
	
public static void main(String[] args) {
		
		productPhotosVO pp = new productPhotosVO();
		productPhotosDAO_interface ppdao = new productPhotosDAO();
		
		//新增
//		pp.setProduct_photo_no(3);
//		pp.setProduct_no(3);
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			pp.setProduct_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		ppdao.insert(pp);
//		System.out.println("新增成功");
		
		//更新
//		pp.setProduct_photo_no(1);
//		pp.setProduct_no(1);
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.png");
//			pp.setProduct_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		ppdao.update(pp);
//		System.out.println("更新成功");
		
		//刪除單一
//		ppdao.delete(3);
//		System.out.println("刪除成功");
		
		//查詢單一
//		productPhotosVO pp1 = ppdao.findByPrimaryKey(1);
//		System.out.print(pp1.getProduct_photo_no() + ",");
//		System.out.print(pp1.getProduct_no() + ",");
//		System.out.print(pp1.getProduct_photo() + ",");
//		System.out.println();
		
		//查詢全部
		List<productPhotosVO> list = ppdao.getAll();
		for (productPhotosVO pp2 : list) {
			System.out.print(pp2.getProduct_photo_no() + ",");
			System.out.print(pp2.getProduct_no() + ",");
			System.out.print(pp2.getProduct_photo() + ",");
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

