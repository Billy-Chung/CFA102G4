package com.adopt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class adoptMemberDAO implements adoptMemberDAO_interface {
	
	private static final String SQL = "";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}


	public void insert(adoptMemberVO adoptMember) {
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
	public void update(adoptMemberVO adoptMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer ADOPT_MEB_NO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public adoptMemberVO findByAdoptMebNoPK(Integer ADOPT_MEB_NO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<adoptMemberVO> getAllAdoptMeb() {
		// TODO Auto-generated method stub
		return null;
	}

}
