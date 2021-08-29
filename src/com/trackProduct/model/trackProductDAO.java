package com.trackProduct.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trackProductDAO implements trackProductDAO_interface {

	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into TRACK_PRODUCT (GEN_MEB_NO, PRODUCT_NO) values(?,?)";
	private static final String updateSQL = "update TRACK_PRODUCT set PRODUCT_NO = ? where GEN_MEB_NO = ?";
	private static final String findByClassNo = "SELECT * FROM TRACK_PRODUCTS WHERE GEN_MEB_NO = ?";
	private static final String selectAll = "SELECT * FROM TRACK_PRODUCT";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	@Override
	public trackProductVO insert(trackProductVO trackProduct) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "GEN_MEB_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, trackProduct, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				trackProduct.setGEN_MEB_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return trackProduct;
	}

	

	@Override
	public void update(trackProductVO trackProduct) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, trackProduct, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public trackProductVO findBytrackProductNo(Integer GEN_MEB_NO, Integer PRODUCT_NO) {
		trackProductVO trackProduct = new trackProductVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, GEN_MEB_NO);
			ResultSet rs = pstmt.executeQuery();
			trackProduct = selectOneBytrackProductNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return trackProduct;
	}

	

	@Override
	public List<trackProductVO> getAlltrackProduct() {
		List<trackProductVO> trackProductList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			trackProductList = selectAlltrackProduct(trackProductList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return trackProductList;
	}

	

	public static void main(String[] args) {
		trackProductDAO_interface dao = new trackProductDAO();
		

//		//test insert pet class
//		trackProductVO trackProductVO1 = new trackProductVO();
//		trackProductVO1.setPRODUCT_NO(1);
//		trackProductVO1.setGEN_MEB_NO(2);
//		trackProductVO trackProduct =  dao.insert(trackProductVO1);
//		System.out.println(trackProductVO1.getGEN_MEB_NO());

//		//test update pet class
//		trackProductVO trackProductVO2 = new trackProductVO();
//		trackProductVO2.setPRODUCT_NO(1);
//		trackProductVO2.setGEN_MEB_NO(2);
//		dao.update(trackProductVO2);

//		//test select one pet class
//		trackProductVO trackProductVO = new trackProductVO();
//		trackProductVO trackProduct3 = dao.findBytrackProductNo(2);
//		System.out.print(trackProduct3.getGEN_MEB_NO() + ",");
//		System.out.print(trackProduct3.getPRODUCT_NO() + ",");
//		System.out.println("---------------------");
		
		//test select all pet class
		trackProductVO trackProductVO = new trackProductVO();
		List<trackProductVO> trackProductList = dao.getAlltrackProduct();
		for (trackProductVO trackProduct4 : trackProductList) {
			System.out.print(trackProduct4.getGEN_MEB_NO() + ",");
			System.out.print(trackProduct4.getPRODUCT_NO() + ",");
			System.out.println("---------------------");
		}

	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, trackProductVO trackProduct, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, trackProduct.getGEN_MEB_NO());
		pstmt.setInt(2, trackProduct.getPRODUCT_NO());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, trackProductVO trackProduct, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, trackProduct.getPRODUCT_NO());
		pstmt.setInt(2, trackProduct.getGEN_MEB_NO());
		return pstmt;
	}
	
	private trackProductVO selectOneBytrackProductNo(ResultSet rs) {
		trackProductVO trackProduct = new trackProductVO();
		try {
			while (rs.next()) {
				trackProduct.setGEN_MEB_NO(rs.getInt("GEN_MEB_NO"));
				trackProduct.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trackProduct;
	}
	
	private List<trackProductVO> selectAlltrackProduct(List<trackProductVO> trackProductList, ResultSet rs) {
		try {
			while (rs.next()) {
				trackProductVO trackProduct = new trackProductVO();
				trackProduct.setGEN_MEB_NO(rs.getInt("GEN_MEB_NO"));
				trackProduct.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				trackProductList.add(trackProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trackProductList;

	}
}
