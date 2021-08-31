package com.adoptPetPhoto.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class AdoptPetPhotoService {
	AdoptPetPhoto_interface dao ;
	
	public AdoptPetPhotoService() {
		dao = new AdoptPetPhotoDAO() ;
	}
	
	public AdoptPetPhotoVO insertAdoptPetPhoto(Integer adopt_pet_no,byte[] adopt_pet_photo) {
		AdoptPetPhotoVO adoptPetPhoto = new AdoptPetPhotoVO();
		
		adoptPetPhoto.setAdopt_pet_no(adopt_pet_no);	
		adoptPetPhoto.setAdopt_pet_photo(adopt_pet_photo);				
		adoptPetPhoto =  dao.insert(adoptPetPhoto);
		
		return adoptPetPhoto;
	}
	
	public void updateAdoptPetPhoto(byte[] adopt_pet_photo,Integer adopt_pet_no) {
		AdoptPetPhotoVO adoptPetPhoto = new AdoptPetPhotoVO();
		
		adoptPetPhoto.setAdopt_pet_photo(adopt_pet_photo);				
		adoptPetPhoto.setAdopt_pet_photo_no(adopt_pet_no);	
		
		dao.update(adoptPetPhoto);
	}
	

	public void deleteAdoptPetPhoto(Integer adopt_pet_photo_no) {	
		dao.delete(adopt_pet_photo_no);
	}
	
	public List<AdoptPetPhotoVO> findByadoptPetNo(Integer adopt_pet_no){
		
		List<AdoptPetPhotoVO> adoptMemberPhotoList = dao.findByadoptPetNo(adopt_pet_no);
		
		return adoptMemberPhotoList;
	}

	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
}
