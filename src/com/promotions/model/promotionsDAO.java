package com.promotions.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class promotionsDAO implements promotionsDAO_interface {
	
	private static final String SQL = "";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}


	public void insert(promotionsVO promotions) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(SQL);

			

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
	public void update(promotionsVO promotions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer PROMOT_NO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public promotionsVO findByPromotNoPk(Integer PROMOT_NO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<promotionsVO> getAllPromot() {
		// TODO Auto-generated method stub
		return null;
	}

}
