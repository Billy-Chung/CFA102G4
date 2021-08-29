package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDAO implements productDAO_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into PRODUCT (PRODUCT_TYPE_NO, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_COMMENT, PRODUCT_STATUS, PRODUCT_ALL_STARS, PRODUCT_ALL_COMMENTS) values(?,?,?,?,?,?,?)";
	private static final String updateSQL = "update PRODUCT set RODUCT_TYPE_NO = ?, PRODUCT_NAME = ?, PRODUCT_PRICE = ?, PRODUCT_COMMENT = ?, PRODUCT_STATUS = ?, PRODUCT_ALL_STARS = ?, PRODUCT_ALL_COMMENTS = ? where PRODUCT_NO = ?";
	private static final String findByClassNo = "SELECT * FROM PRODUCTS WHERE PRODUCT_NO = ?";
	private static final String selectAll = "SELECT * FROM PRODUCT";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public productVO insert(productVO product) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PRODUCT_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, product, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				product.setPRODUCT_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return product;
	}

	

	@Override
	public void update(productVO product) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, product, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public productVO findByproductNo(Integer PRODUCT_NO) {
		productVO product = new productVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, PRODUCT_NO);
			ResultSet rs = pstmt.executeQuery();
			product = selectOneByproductNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return product;
	}

	

	@Override
	public List<productVO> getAllproduct() {
		List<productVO> productList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			productList = selectAllproduct(productList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return productList;
	}

	

	public static void main(String[] args) {
		productDAO_interface dao = new productDAO();
		

//		//test insert pet class
//		productVO productVO1 = new productVO();
//		productVO1.setPRODUCT_TYPE_NO(1);
//		productVO1.setPRODUCT_NAME("AB牌綜合飼料");
//		productVO1.setPRODUCT_PRICE(1500);
//		productVO1.setPRODUCT_COMMENT("寵物通用飼料");
//		productVO1.setPRODUCT_STATUS("0");
//		productVO1.setPRODUCT_ALL_STARS(4);
//		productVO1.setPRODUCT_ALL_COMMENTS(50);		
//		productVO product =  dao.insert(productVO1);
//		System.out.println(productVO1.getPRODUCT_NO());

//		//test update pet class
//		productVO productVO2 = new productVO();
//		productVO2.setPRODUCT_TYPE_NO(2);
//		productVO2.setPRODUCT_NAME("A牌貓咪飼料");
//		productVO2.setPRODUCT_PRICE(899);
//		productVO2.setPRODUCT_COMMENT("頂級鮭魚口味");
//		productVO2.setPRODUCT_STATUS("1");
//		productVO2.setPRODUCT_ALL_STARS(5);
//		productVO2.setPRODUCT_ALL_COMMENTS(585);
//		productVO2.setPRODUCT_NO(2);
//		dao.update(productVO2);

//		//test select one pet class
//		productVO productVO = new productVO();
//		productVO product3 = dao.findByproductNo(2);
//		System.out.print(product3.getPRODUCT_NO() + ",");
//		System.out.print(product3.getPRODUCT_TYPE_NO() + ",");
//		System.out.print(product3.getPRODUCT_NAME() + ",");
//		System.out.print(product3.getPRODUCT_PRICE() + ",");
//		System.out.print(product3.getPRODUCT_COMMENT() + ",");		
//		System.out.print(product3.getPRODUCT_STATUS() + ",");		
//		System.out.print(product3.getPRODUCT_ALL_STARS() + ",");		
//		System.out.println(product3.getPRODUCT_ALL_COMMENTS() + ",");
//		System.out.println("---------------------");
		
		//test select all pet class
		productVO productVO = new productVO();
		List<productVO> productList = dao.getAllproduct();
		for (productVO product4 : productList) {
			System.out.print(product4.getPRODUCT_NO() + ",");
			System.out.print(product4.getPRODUCT_TYPE_NO() + ",");
			System.out.print(product4.getPRODUCT_NAME() + ",");
			System.out.print(product4.getPRODUCT_PRICE() + ",");
			System.out.print(product4.getPRODUCT_COMMENT() + ",");		
			System.out.print(product4.getPRODUCT_STATUS() + ",");		
			System.out.print(product4.getPRODUCT_ALL_STARS() + ",");		
			System.out.println(product4.getPRODUCT_ALL_COMMENTS() + ",");		
			System.out.println("---------------------");
		}

	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, productVO product, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, product.getPRODUCT_TYPE_NO());
		pstmt.setString(2, product.getPRODUCT_NAME());
		pstmt.setInt(3, product.getPRODUCT_PRICE());
		pstmt.setString(4, product.getPRODUCT_COMMENT());
		pstmt.setString(5, product.getPRODUCT_STATUS());
		pstmt.setInt(6, product.getPRODUCT_ALL_STARS());
		pstmt.setInt(7, product.getPRODUCT_ALL_COMMENTS());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, productVO product, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, product.getPRODUCT_TYPE_NO());
		pstmt.setString(2, product.getPRODUCT_NAME());
		pstmt.setInt(3, product.getPRODUCT_PRICE());
		pstmt.setString(4, product.getPRODUCT_COMMENT());
		pstmt.setString(5, product.getPRODUCT_STATUS());
		pstmt.setInt(6, product.getPRODUCT_ALL_STARS());
		pstmt.setInt(7, product.getPRODUCT_ALL_COMMENTS());
		pstmt.setInt(8, product.getPRODUCT_NO());
		return pstmt;
	}
	
	private productVO selectOneByproductNo(ResultSet rs) {
		productVO product = new productVO();
		try {
			while (rs.next()) {
				product.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				product.setPRODUCT_TYPE_NO(rs.getInt("PRODUCT_TYPE_NO"));
				product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
				product.setPRODUCT_COMMENT(rs.getString("PRODUCT_COMMENT"));
				product.setPRODUCT_STATUS(rs.getString("PRODUCT_STATUS"));
				product.setPRODUCT_ALL_STARS(rs.getInt("PRODUCT_ALL_STARS"));
				product.setPRODUCT_ALL_COMMENTS(rs.getInt("PRODUCT_ALL_COMMENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	private List<productVO> selectAllproduct(List<productVO> productList, ResultSet rs) {
		try {
			while (rs.next()) {
				productVO product = new productVO();
				product.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				product.setPRODUCT_TYPE_NO(rs.getInt("PRODUCT_TYPE_NO"));
				product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
				product.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
				product.setPRODUCT_COMMENT(rs.getString("PRODUCT_COMMENT"));
				product.setPRODUCT_STATUS(rs.getString("PRODUCT_STATUS"));
				product.setPRODUCT_ALL_STARS(rs.getInt("PRODUCT_ALL_STARS"));
				product.setPRODUCT_ALL_COMMENTS(rs.getInt("PRODUCT_ALL_COMMENTS"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;

	}
}
