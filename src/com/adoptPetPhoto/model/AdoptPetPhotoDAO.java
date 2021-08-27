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

public class AdoptPetPhotoDAO implements AdoptPetPhoto_interface {

	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_PET_PHOTO (ADOPT_PET_NO,ADOPT_PET_PHOTO) values(?,?)";
	private static final String updateSQL = "update ADOPT_PET_PHOTO set ADOPT_PET_PHOTO = ? where ADOPT_PET_PHOTO_NO = ?";
	private static final String deleteSQL = "delete from ADOPT_PET_PHOTO where ADOPT_PET_PHOTO_NO = ?";
	private static final String findByPetNo = "SELECT * FROM ADOPT_PET_PHOTO WHERE ADOPT_PET_NO = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public AdoptPetPhotoVO insert(AdoptPetPhotoVO adoptPetPhoto) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "ADOPT_PET_PHOTO_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptPetPhoto, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptPetPhoto.setAdopt_pet_photo_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPetPhoto;
	}

	@Override
	public void update(AdoptPetPhotoVO adoptPetPhoto) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptPetPhoto, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	

	@Override
	public void delete(Integer adopt_pet_photo_no) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createDeletePreparedStatement(con, adopt_pet_photo_no, deleteSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}

	@Override
	public List<AdoptPetPhotoVO> findByadoptPetNo(Integer adopt_pet_no) {
		List<AdoptPetPhotoVO> adoptMemberPhotoList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByPetNo);
			pstmt.setInt(1, adopt_pet_no);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberPhotoList = selectAdoptMebPhotos(adoptMemberPhotoList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberPhotoList;
	}

	public static void main(String[] args) {
		AdoptPetPhoto_interface dao = new AdoptPetPhotoDAO();
		AdoptPetPhotoVO AdoptPetPhotoVO = new AdoptPetPhotoVO();

//		test insert
//		AdoptPetPhotoVO.setAdopt_pet_no(2);		
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			AdoptPetPhotoVO.setAdopt_pet_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}				
//		AdoptPetPhotoVO adoptMember =  dao.insert(AdoptPetPhotoVO);
//		System.out.println(adoptMember.getAdopt_pet_photo_no());

//		test update

//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			AdoptPetPhotoVO.setAdopt_pet_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}	
//		
//		AdoptPetPhotoVO.setAdopt_pet_photo_no(1);	
//		dao.update(AdoptPetPhotoVO);

//		test find by pet No
//		List<AdoptPetPhotoVO> adoptMemberPhotoList = dao.findByadoptPetNo(2);
//		for (AdoptPetPhotoVO adoptPetPhoto : adoptMemberPhotoList) {
//			System.out.print(adoptPetPhoto.getAdopt_pet_photo_no() + ",");
//			System.out.print(adoptPetPhoto.getAdopt_pet_no() + ",");
//			System.out.print(adoptPetPhoto.getAdopt_pet_photo() + ",");
//			System.out.println("---------------------");
//		}
		
//		test delete
//		dao.delete(1);
		
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, AdoptPetPhotoVO adoptPetPhoto, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptPetPhoto.getAdopt_pet_no());
		pstmt.setBytes(2, adoptPetPhoto.getAdopt_pet_photo());
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, AdoptPetPhotoVO adoptPetPhoto, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setBytes(1, adoptPetPhoto.getAdopt_pet_photo());
		pstmt.setInt(2, adoptPetPhoto.getAdopt_pet_photo_no());
		return pstmt;
	}
	
	private PreparedStatement createDeletePreparedStatement(Connection con, Integer adopt_pet_photo_no, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);		
		pstmt.setInt(1, adopt_pet_photo_no);
		return pstmt;
	}

	private List<AdoptPetPhotoVO> selectAdoptMebPhotos(List<AdoptPetPhotoVO> adoptMemberPhotoList, ResultSet rs) {

		try {
			while (rs.next()) {
				AdoptPetPhotoVO adoptPetPhoto = new AdoptPetPhotoVO();
				adoptPetPhoto.setAdopt_pet_photo_no(rs.getInt("ADOPT_PET_PHOTO_NO"));
				adoptPetPhoto.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				adoptPetPhoto.setAdopt_pet_photo(rs.getBytes("ADOPT_PET_PHOTO"));
				adoptMemberPhotoList.add(adoptPetPhoto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberPhotoList;
	}

}
