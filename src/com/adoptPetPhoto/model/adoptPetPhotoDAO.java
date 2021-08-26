package com.adoptPetPhoto.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberNews.model.adoptMemberNewsVo;

public class adoptPetPhotoDAO implements adoptPetPhoto_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_PET_PHOTO (ADOPT_PET_NO,ADOPT_PET_PHOTO) values(?,?)";
	private static final String updateSQL = "update ADOPT_PET_PHOTO set ADOPT_PET_PHOTO = ? where ADOPT_PET_PHOTO_NO = ?";
	private static final String findByPetNo = "SELECT * FROM ADOPT_PET_PHOTO WHERE ADOPT_PET_NO = ?";

	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	

	@Override
	public adoptPetPhotoVO insert(adoptPetPhotoVO adoptPetPhoto) {
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){
			String[] cols = { "ADOPT_PET_PHOTO_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con,adoptPetPhoto,insertSQL, cols);
			pstmt.executeUpdate();			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptPetPhoto.setADOPT_PET_PHOTO_NO(key);
			} 
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPetPhoto;
	}
	
	private PreparedStatement createInsertPreparedStatement (Connection con,adoptPetPhotoVO adoptPetPhoto,String SQL, String[] cols) throws SQLException {
		
		PreparedStatement pstmt = con.prepareStatement(SQL,cols);
		pstmt.setInt(1, adoptPetPhoto.getADOPT_PET_NO());
	    pstmt.setBytes(2, adoptPetPhoto.getADOPT_PET_PHOTO());		
	    return pstmt;
	}

	@Override
	public void update(adoptPetPhotoVO adoptPetPhoto) {
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = createUpdatePreparedStatement(con,adoptPetPhoto,updateSQL);
			pstmt.executeUpdate();	
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
		
	}
	
	private PreparedStatement createUpdatePreparedStatement (Connection con,adoptPetPhotoVO adoptPetPhoto,String SQL) throws SQLException {
		
		 PreparedStatement pstmt = con.prepareStatement(SQL);
		 pstmt.setBytes(1, adoptPetPhoto.getADOPT_PET_PHOTO());
		 pstmt.setInt(2, adoptPetPhoto.getADOPT_PET_PHOTO_NO());		 
		 return pstmt;
	}
	

	@Override
	public List<adoptPetPhotoVO> findByadoptPetNo(Integer ADOPT_PET_NO) {
			List<adoptPetPhotoVO> adoptMemberPhotoList  = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = con.prepareStatement(findByPetNo);
			pstmt.setInt(1, ADOPT_PET_NO);					
			ResultSet rs = pstmt.executeQuery();
			adoptMemberPhotoList = selectAdoptMebPhotos(adoptMemberPhotoList,rs);
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
		return adoptMemberPhotoList;	
	}
	
	public List<adoptPetPhotoVO> selectAdoptMebPhotos (List<adoptPetPhotoVO> adoptMemberPhotoList,ResultSet rs){
		
		try {
			while (rs.next()) {
				adoptPetPhotoVO adoptPetPhoto = new adoptPetPhotoVO();
				adoptPetPhoto.setADOPT_PET_PHOTO_NO(rs.getInt("ADOPT_PET_PHOTO_NO"));
				adoptPetPhoto.setADOPT_PET_NO(rs.getInt("ADOPT_PET_NO"));
				adoptPetPhoto.setADOPT_PET_PHOTO(rs.getBytes("ADOPT_PET_PHOTO"));				
				adoptMemberPhotoList.add(adoptPetPhoto);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}		
		return adoptMemberPhotoList;
	}


	public static void main(String[] args) {
		adoptPetPhoto_interface dao = new adoptPetPhotoDAO();
		adoptPetPhotoVO adoptPetPhotoVO = new adoptPetPhotoVO();
		
//		test insert
//		adoptPetPhotoVO.setADOPT_PET_NO(2);		
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			adoptPetPhotoVO.setADOPT_PET_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}				
//		adoptPetPhotoVO adoptMember =  dao.insert(adoptPetPhotoVO);
//		System.out.println(adoptMember.getADOPT_PET_PHOTO_NO());
		
//		test update
						
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			adoptPetPhotoVO.setADOPT_PET_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}	
//		
//		adoptPetPhotoVO.setADOPT_PET_PHOTO_NO(1);	
//		dao.update(adoptPetPhotoVO);
		
//		test find by pet No
		List<adoptPetPhotoVO> adoptMemberPhotoList = dao.findByadoptPetNo(1);	
		for (adoptPetPhotoVO adoptPetPhoto : adoptMemberPhotoList) {			
			System.out.print(adoptPetPhoto.getADOPT_PET_PHOTO_NO() + ",");
			System.out.print(adoptPetPhoto.getADOPT_PET_NO() + ",");
			System.out.print(adoptPetPhoto.getADOPT_PET_PHOTO() + ",");				
			System.out.println("---------------------");
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
