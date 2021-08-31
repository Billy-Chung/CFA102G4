package com.promotions.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//此類別實作DAO interface，並將資料庫操作細節封裝起來
public class promotionsDAO implements promotionsDAO_interface {
	
//	private static final String SQL = "";
	private static final String INSERT_STMT = "insert into PROMOTIONS(promot_name, promot_date_start, promot_date_end, promot_status, promot_type, PROMOT_DISCOUNT_TYPE, promot_discount, promot_reduce, promot_comment , promot_photo) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	promot_no,自動生成流水號不用
	private static final String UPDATE_STMT = "update PROMOTIONS set promot_name=?, promot_date_start=?, promot_date_end=?, promot_status=?, promot_type=?, PROMOT_DISCOUNT_TYPE=?, promot_discount=?, promot_reduce=?, promot_comment=?, promot_photo=? WHERE promot_no=?";
//  圖片
	private static final String DELETE_STMT = "delete from PROMOTIONS where promot_no = ?";
	private static final String FIND_BY_PK = "select * from PROMOTIONS where promot_no = ?";
	private static final String GET_ALL = "select * from PROMOTIONS";
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Util.DRIVER
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}	

	@Override
	public void add(promotionsVO promotions) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
                                                                                                     //URL     //USER     //PASSWORD
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(INSERT_STMT);//新增
			int i=1;
			
//			pstmt.setInt(i++, promotions.getPromot_no()); //自動生成流水號不可用set
			pstmt.setString(i++, promotions.getPromot_name());
			pstmt.setDate(i++, promotions.getPromot_date_start());
			pstmt.setDate(i++, promotions.getPromot_date_end());
			pstmt.setString(i++, promotions.getPromot_status());
			pstmt.setString(i++, promotions.getPromot_type());
			pstmt.setString(i++, promotions.getPromot_discount_type());
			pstmt.setString(i++, promotions.getPromot_discount());
			pstmt.setString(i++, promotions.getPromot_reduce());
			pstmt.setString(i++, promotions.getPromot_comment());
			pstmt.setBytes(i++, promotions.getPromot_photo());
			pstmt.executeUpdate();//執行		
		
			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
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
	public void update(promotionsVO promotions) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			
			pstmt.setString(i++, promotions.getPromot_name());
			pstmt.setDate(i++, promotions.getPromot_date_start());
			pstmt.setDate(i++, promotions.getPromot_date_end());
			pstmt.setString(i++, promotions.getPromot_status());
			pstmt.setString(i++, promotions.getPromot_type());
			pstmt.setString(i++, promotions.getPromot_discount_type());
			pstmt.setString(i++, promotions.getPromot_discount());
			pstmt.setString(i++, promotions.getPromot_reduce());
			pstmt.setString(i++, promotions.getPromot_comment());
			pstmt.setBytes(i++, promotions.getPromot_photo());
			pstmt.setInt(i++, promotions.getPromot_no());//WHERE 條件
			pstmt.executeUpdate();//執行		
			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
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
	public void delete(int promot_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(DELETE_STMT);//刪除
			pstmt.setInt(1, promot_no);			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
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
	public promotionsVO findByPromotNoPk(int promot_no) {
		promotionsVO promotions = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
			pstmt.setInt(1, promot_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				promotions = new promotionsVO();
				promotions.setPromot_no(rs.getInt("promot_no"));
				promotions.setPromot_name(rs.getString("promot_name"));
				promotions.setPromot_date_start(rs.getDate("promot_date_start"));
				promotions.setPromot_date_end(rs.getDate("promot_date_end"));
				promotions.setPromot_status(rs.getString("promot_status"));
				promotions.setPromot_type(rs.getString("promot_type"));
				promotions.setPromot_discount_type(rs.getString("PROMOT_DISCOUNT_TYPE"));
				promotions.setPromot_discount(rs.getString("promot_discount"));
				promotions.setPromot_reduce(rs.getString("promot_reduce"));
				promotions.setPromot_comment(rs.getString("promot_comment"));
				promotions.setPromot_photo(rs.getBytes("promot_photo()"));
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

		return promotions;
	}
	@Override
	public List<promotionsVO> getAll() {//列表
		List<promotionsVO> promotionsList = new ArrayList<>();
		promotionsVO promotions = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				promotions = new promotionsVO();
				promotions.setPromot_no(rs.getInt("promot_no"));
				promotions.setPromot_name(rs.getString("promot_name"));
				promotions.setPromot_date_start(rs.getDate("promot_date_start"));
				promotions.setPromot_date_end(rs.getDate("promot_date_end"));
				promotions.setPromot_status(rs.getString("promot_status"));
				promotions.setPromot_type(rs.getString("promot_type"));
				promotions.setPromot_discount_type(rs.getString("PROMOT_DISCOUNT_TYPE"));
				promotions.setPromot_discount(rs.getString("promot_discount"));
				promotions.setPromot_reduce(rs.getString("promot_reduce"));
				promotions.setPromot_comment(rs.getString("promot_comment"));
				promotions.setPromot_photo(rs.getBytes("promot_photo()"));	
				promotionsList.add(promotions);
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
		return promotionsList;
			}

}
