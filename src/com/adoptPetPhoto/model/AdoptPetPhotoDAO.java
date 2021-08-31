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

	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into ADOPT_PET_PHOTO (ADOPT_PET_NO,ADOPT_PET_PHOTO) values(?,?)";
	private static final String UPDATE_SQL = "update ADOPT_PET_PHOTO set ADOPT_PET_PHOTO = ? where ADOPT_PET_PHOTO_NO = ?";
	private static final String DELETE_SQL = "delete from ADOPT_PET_PHOTO where ADOPT_PET_PHOTO_NO = ?";
	private static final String FIND_BY_PET_NO = "SELECT * FROM ADOPT_PET_PHOTO WHERE ADOPT_PET_NO = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public AdoptPetPhotoVO insert(AdoptPetPhotoVO adoptPetPhoto) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "ADOPT_PET_PHOTO_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptPetPhoto, INSERT_SQL, cols);
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
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptPetPhoto, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	

	@Override
	public void delete(Integer adopt_pet_photo_no) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createDeletePreparedStatement(con, adopt_pet_photo_no, DELETE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}

	@Override
	public List<AdoptPetPhotoVO> findByadoptPetNo(Integer adopt_pet_no) {
		List<AdoptPetPhotoVO> adoptMemberPhotoList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PET_NO);
			pstmt.setInt(1, adopt_pet_no);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberPhotoList = selectAdoptMebPhotos(adoptMemberPhotoList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberPhotoList;
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
