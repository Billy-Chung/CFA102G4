package com.product_promotions_detail.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class product_promotions_detailDAO implements product_promotions_detailDAO_interface{
//	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
//	public static final String USER = "David";
//	public static final String PASSWORD = "123456";
	//  這樣寫就吃不到，想看看
	
	private static final String INSERT_STMT = "insert into PRODUCT_PROMOTIONS_DETAIL(promot_no, product_no, product_pro_price, product_pro_special_price) values ( ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "update PRODUCT_PROMOTIONS_DETAIL set promot_no=?,product_no=?,product_pro_price=?,product_pro_special_price=? WHERE product_pro_detail_no=?";
	private static final String DELETE_STMT = "delete from PRODUCT_PROMOTIONS_DETAIL where product_pro_detail_no=?";
	private static final String FIND_BY_PK = "select * from PRODUCT_PROMOTIONS_DETAIL where product_pro_detail_no=?";
	private static final String GET_ALL = "select * from PRODUCT_PROMOTIONS_DETAIL";
	
	
	static {
		try {
//			Class.forName("DRIVER");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}	

	@Override
	public void add(product_promotions_detailVO product_promotions_detail) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
                                                                                                    
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(INSERT_STMT);//新增
			int i=1;
			pstmt.setInt(i++, product_promotions_detail.getPromot_no());
			pstmt.setInt(i++, product_promotions_detail.getProduct_no());
			pstmt.setInt(i++, product_promotions_detail.getProduct_pro_price());
			pstmt.setInt(i++, product_promotions_detail.getProduct_pro_special_price());
			pstmt.executeUpdate();//執行		
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	
	@Override
	public void update(product_promotions_detailVO product_promotions_detail) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			pstmt.setInt(i++, product_promotions_detail.getPromot_no());
			pstmt.setInt(i++, product_promotions_detail.getProduct_no());
			pstmt.setInt(i++, product_promotions_detail.getProduct_pro_price());
			pstmt.setInt(i++, product_promotions_detail.getProduct_pro_special_price());
			pstmt.setInt(i++, product_promotions_detail.getProduct_pro_detail_no());//WHERE 條件			                                             
			pstmt.executeUpdate();//執行		
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}	  
	
	public void delete1(Integer product_pro_detail_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(DELETE_STMT);//刪除
			pstmt.setInt(1, product_pro_detail_no);			
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public product_promotions_detailVO findByProductPro_DetailPK(Integer product_pro_detail_no) {//主鍵名稱
		product_promotions_detailVO product_promotions_detail = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
			pstmt.setInt(1, product_pro_detail_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				product_promotions_detail = new product_promotions_detailVO();
				product_promotions_detail.setProduct_pro_detail_no(rs.getInt("product_pro_detail_no"));			
				product_promotions_detail.setPromot_no(rs.getInt("promot_no"));
				product_promotions_detail.setProduct_no(rs.getInt("product_no"));
				product_promotions_detail.setProduct_pro_price(rs.getInt("product_pro_price"));
				product_promotions_detail.setProduct_pro_special_price(rs.getInt("product_pro_special_price"));				
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return product_promotions_detail;
	}	
	
	@Override
	public List<product_promotions_detailVO> getAllproductPromotions_Detail() {//列表
		List<product_promotions_detailVO> product_promotions_detailList = new ArrayList<>();
		product_promotions_detailVO product_promotions_detail = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				

		try {

//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				product_promotions_detail = new product_promotions_detailVO();				
				product_promotions_detail.setProduct_pro_detail_no(rs.getInt("product_pro_detail_no"));			
				product_promotions_detail.setPromot_no(rs.getInt("promot_no"));
				product_promotions_detail.setProduct_no(rs.getInt("product_no"));
				product_promotions_detail.setProduct_pro_price(rs.getInt("product_pro_price"));
				product_promotions_detail.setProduct_pro_special_price(rs.getInt("product_pro_special_price"));				
				product_promotions_detailList.add(product_promotions_detail);
			}


		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return product_promotions_detailList;
			}


	@Override
	public void delete(Integer product_pro_detail_no) {
		// TODO Auto-generated method stub
		
	}
	
}




	



	