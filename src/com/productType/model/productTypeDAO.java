package com.productType.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productTypeDAO implements productTypeDAO_interface{
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into PRODUCT_TYPE (PRODUCT_TYPE_NO) values(?)";
	private static final String updateSQL = "update PRODUCT_TYPE set PRODUCT_TYPE_NO = ? where PRODUCT_TYPE_NAME = ?";
	private static final String findByClassNo = "SELECT * FROM PRODUCT_TYPES WHERE PRODUCT_TYPE_NO = ?";
	private static final String selectAll = "SELECT * FROM PRODUCT_TYPE";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public productTypeVO insert(productTypeVO productType) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PRODUCT_TYPE_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, productType, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				productType.setPRODUCT_TYPE_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productType;
	}

	

	@Override
	public void update(productTypeVO productType) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, productType, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public productTypeVO findByproductTypeNo(Integer PRODUCT_TYPE_NO) {
		productTypeVO productType = new productTypeVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, PRODUCT_TYPE_NO);
			ResultSet rs = pstmt.executeQuery();
			productType = selectOneByproductTypeNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productType;
	}

	

	@Override
	public List<productTypeVO> getAllproductType() {
		List<productTypeVO> productTypeList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			productTypeList = selectAllproductType(productTypeList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productTypeList;
	}

	

	public static void main(String[] args) {
		productTypeDAO_interface dao = new productTypeDAO();
		

//		//test insert pet class
//		productTypeVO productTypeVO1 = new productTypeVO();
//		productTypeVO1.setPRODUCT_TYPE_NAME("寵物用品");
//		productTypeVO productType =  dao.insert(productTypeVO1);
//		System.out.println(productTypeVO1.getPRODUCT_TYPE_NO());

//		//test update pet class
//		productTypeVO productTypeVO2 = new productTypeVO();
//		productTypeVO2.setPRODUCT_TYPE_NAME("寵物衣服");
//		productTypeVO2.setPRODUCT_TYPE_NO(3);
//		dao.update(productTypeVO2);

//		//test select one pet class
//		productTypeVO productTypeVO = new productTypeVO();
//		productTypeVO productType3 = dao.findByproductTypeNo(2);
//		System.out.print(productType3.getPRODUCT_TYPE_NO() + ",");
//		System.out.print(productType3.getPRODUCT_TYPE_NAME() + ",");
//		System.out.println("---------------------");
		
		//test select all pet class
		productTypeVO productTypeVO = new productTypeVO();
		List<productTypeVO> productTypeList = dao.getAllproductType();
		for (productTypeVO productType4 : productTypeList) {
			System.out.print(productType4.getPRODUCT_TYPE_NO() + ",");
			System.out.println(productType4.getPRODUCT_TYPE_NAME() + ",");
			System.out.println("---------------------");
		}

	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, productTypeVO productType, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setString(1, productType.getPRODUCT_TYPE_NAME());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, productTypeVO productType, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, productType.getPRODUCT_TYPE_NAME());
		pstmt.setInt(2, productType.getPRODUCT_TYPE_NO());
		return pstmt;
	}
	
	private productTypeVO selectOneByproductTypeNo(ResultSet rs) {
		productTypeVO productType = new productTypeVO();
		try {
			while (rs.next()) {
				productType.setPRODUCT_TYPE_NO(rs.getInt("PRODUCT_TYPE_NO"));
				productType.setPRODUCT_TYPE_NAME(rs.getString("PRODUCT_TYPE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productType;
	}
	
	private List<productTypeVO> selectAllproductType(List<productTypeVO> productTypeList, ResultSet rs) {
		try {
			while (rs.next()) {
				productTypeVO productType = new productTypeVO();
				productType.setPRODUCT_TYPE_NO(rs.getInt("PRODUCT_TYPE_NO"));
				productType.setPRODUCT_TYPE_NAME(rs.getString("PRODUCT_TYPE_NAME"));
				productTypeList.add(productType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productTypeList;

	}
	

}
