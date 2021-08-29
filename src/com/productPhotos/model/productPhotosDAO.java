package com.productPhotos.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productPhotosDAO implements productPhotosDAO_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into PRODUCT_PHOTOS (PRODUCT_NO, PRODUCT_PHOTO) values(?,?)";
	private static final String updateSQL = "update PRODUCT_PHOTOS set  = ?, PRODUCT_NO = ?, PRODUCT_PHOTO = ? where PRODUCT_PHOTO_NO = ?";
	private static final String findByClassNo = "SELECT * FROM PRODUCT_PHOTOSS WHERE PRODUCT_PHOTO_NO = ?";
	private static final String selectAll = "SELECT * FROM PRODUCT_PHOTOS";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public productPhotosVO insert(productPhotosVO productPhotos) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PRODUCT_PHOTO_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, productPhotos, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				productPhotos.setPRODUCT_PHOTO_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productPhotos;
	}

	

	@Override
	public void update(productPhotosVO productPhotos) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, productPhotos, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public productPhotosVO findByproductPhotosNo(Integer PRODUCT_PHOTO_NO) {
		productPhotosVO productPhotos = new productPhotosVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, PRODUCT_PHOTO_NO);
			ResultSet rs = pstmt.executeQuery();
			productPhotos = selectOneByproductPhotosNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productPhotos;
	}

	

	@Override
	public List<productPhotosVO> getAllproductPhotos() {
		List<productPhotosVO> productPhotosList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			productPhotosList = selectAllproductPhotos(productPhotosList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productPhotosList;
	}

	

	public static void main(String[] args) {
		productPhotosDAO_interface dao = new productPhotosDAO();
		

//		//test insert pet class
//		productPhotosVO productPhotosVO1 = new productPhotosVO();
//		productPhotosVO1.setPRODUCT_NO(1);
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			productPhotosVO1.setPRODUCT_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		productPhotosVO productPhotos =  dao.insert(productPhotosVO1);
//		System.out.println(productPhotosVO1.getPRODUCT_PHOTO_NO());

//		//test update pet class
//		productPhotosVO productPhotosVO2 = new productPhotosVO();
//		productPhotosVO2.setPRODUCT_NO(1);
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.png");
//			productPhotosVO2.setPRODUCT_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		productPhotosVO2.setPRODUCT_PHOTO_NO(2);
//		dao.update(productPhotosVO2);

//		//test select one pet class
//		productPhotosVO productPhotosVO = new productPhotosVO();
//		productPhotosVO productPhotos3 = dao.findByproductPhotosNo(2);
//		System.out.print(productPhotos3.getPRODUCT_PHOTO_NO() + ",");
//		System.out.print(productPhotos3.getPRODUCT_NO() + ",");
//		System.out.println(productPhotos3.getPRODUCT_PHOTO() + ",");
//		System.out.println("---------------------");
		
		//test select all pet class
		productPhotosVO productPhotosVO = new productPhotosVO();
		List<productPhotosVO> productPhotosList = dao.getAllproductPhotos();
		for (productPhotosVO productPhotos4 : productPhotosList) {
			System.out.print(productPhotos4.getPRODUCT_PHOTO_NO() + ",");
			System.out.print(productPhotos4.getPRODUCT_NO() + ",");
			System.out.println(productPhotos4.getPRODUCT_PHOTO() + ",");
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

	
	private PreparedStatement createInsertPreparedStatement(Connection con, productPhotosVO productPhotos, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, productPhotos.getPRODUCT_NO());
		pstmt.setBytes(2, productPhotos.getPRODUCT_PHOTO());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, productPhotosVO productPhotos, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, productPhotos.getPRODUCT_NO());
		pstmt.setBytes(2, productPhotos.getPRODUCT_PHOTO());
		pstmt.setInt(8, productPhotos.getPRODUCT_PHOTO_NO());
		return pstmt;
	}
	
	private productPhotosVO selectOneByproductPhotosNo(ResultSet rs) {
		productPhotosVO productPhotos = new productPhotosVO();
		try {
			while (rs.next()) {
				productPhotos.setPRODUCT_PHOTO_NO(rs.getInt("PRODUCT_PHOTO_NO"));
				productPhotos.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				productPhotos.setPRODUCT_PHOTO(rs.getBytes("PRODUCT_PHOTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productPhotos;
	}
	
	private List<productPhotosVO> selectAllproductPhotos(List<productPhotosVO> productPhotosList, ResultSet rs) {
		try {
			while (rs.next()) {
				productPhotosVO productPhotos = new productPhotosVO();
				productPhotos.setPRODUCT_PHOTO_NO(rs.getInt("PRODUCT_PHOTO_NO"));
				productPhotos.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				productPhotos.setPRODUCT_PHOTO(rs.getBytes("PRODUCT_PHOTO"));
				productPhotosList.add(productPhotos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productPhotosList;

	}
}
