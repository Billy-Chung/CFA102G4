package com.adoptPetPhoto.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class adoptPetPhotoDAO implements adoptPetPhoto_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_PET_PHOTO (ADOPT_PET_NO,ADOPT_PET_PHOTO) values(?,?)";
	private static final String updateSQL = "update ADOPT_PET_PHOTO set ADOPT_PET_PHOTO = ? where ADOPT_PET_PHOTO_NO = ?";
	private static final String findByPetNo = "SELECT * FROM ADOPT_PET_PHOTO WHERE ADOPT_PET_NO = ?";
	private static final String selectAll = "SELECT * FROM ADOPT_PET_PHOTO";
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<adoptPetPhotoVO> getAlladoptPetPhoto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		adoptPetPhoto_interface dao = new adoptPetPhotoDAO();
		adoptPetPhotoVO adoptPetPhotoVO = new adoptPetPhotoVO();
		
//		test insert
//		adoptPetPhotoVO.setADOPT_PET_NO(1);		
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			adoptPetPhotoVO.setADOPT_PET_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}				
//		adoptPetPhotoVO adoptMember =  dao.insert(adoptPetPhotoVO);
//		System.out.println(adoptMember.getADOPT_PET_PHOTO_NO());
		
//		test update
						
		try {
			byte[] pic = getPictureByteArray("images/adoptMember1.png");
			adoptPetPhotoVO.setADOPT_PET_PHOTO(pic);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		adoptPetPhotoVO.setADOPT_PET_PHOTO_NO(1);	
		dao.update(adoptPetPhotoVO);
		
		
		
		
		
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
