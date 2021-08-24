package com.adopt.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class adoptMemberDAO implements adoptMemberDAO_interface {
	
	private static final String insertSQL = "insert into ADOPT_MEMBER (ADOPT_MEB_NAME,ADOPT_MEB_COMMENT,ADOPT_MEB_PHOTO,ADOPT_MEB_ADDRESS,ADOPT_MEB_PHONE,ADOPT_MEB_EMAIL,ADOPT_MEB_ACCOUNT,ADOPT_MEB_PASSWORD,ADOPT_MEB_STATE,ADOPT_MEB_AUTH,ADOPT_MEB_HOLIDAY,ADOPT_MEB_LIMIT) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String updateSQL = "update ADOPT_MEMBER set ADOPT_MEB_NAME = ?, ADOPT_MEB_COMMENT = ?, ADOPT_MEB_PHOTO = ?, ADOPT_MEB_ADDRESS = ?, ADOPT_MEB_PHONE = ?, ADOPT_MEB_EMAIL = ?, ADOPT_MEB_ACCOUNT = ?, ADOPT_MEB_PASSWORD = ?, ADOPT_MEB_STATE = ?, ADOPT_MEB_AUTH = ?, ADOPT_MEB_HOLIDAY = ?, ADOPT_MEB_LIMIT = ? where ADOPT_MEB_NO = ?";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}


	public adoptMemberVO insert(adoptMemberVO adoptMember) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			String[] cols = { "ADOPT_MEB_NO" };
			pstmt = con.prepareStatement(insertSQL,cols);			

			pstmt.setString(1, adoptMember.getADOPT_MEB_NAME());
			pstmt.setString(2, adoptMember.getADOPT_MEB_COMMENT());
			pstmt.setBytes(3, adoptMember.getADOPT_MEB_PHOTO());
			pstmt.setString(4, adoptMember.getADOPT_MEB_ADDRESS());
			pstmt.setString(5, adoptMember.getADOPT_MEB_PHONE());
			pstmt.setString(6, adoptMember.getADOPT_MEB_EMAIL());
			pstmt.setString(7, adoptMember.getADOPT_MEB_ACCOUNT());
			pstmt.setString(8, adoptMember.getADOPT_MEB_PASSWORD());
			pstmt.setString(9, adoptMember.getADOPT_MEB_STATE());
			pstmt.setString(10, adoptMember.getADOPT_MEB_AUTH());
			pstmt.setString(11, adoptMember.getADOPT_MEB_HOLIDAY());
			pstmt.setString(12, adoptMember.getADOPT_MEB_LIMIT());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				System.out.println("自增主鍵值 = " + key + "(剛新增成功的會員編號)");
			} else {
				System.out.println("沒有自增主鍵值被建立 ");
			}
			
			rs.close();		
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
		return adoptMember;
	}

	@Override
	public void update(adoptMemberVO adoptMember) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(updateSQL);			

			pstmt.setString(1, adoptMember.getADOPT_MEB_NAME());
			pstmt.setString(2, adoptMember.getADOPT_MEB_COMMENT());
			pstmt.setBytes(3, adoptMember.getADOPT_MEB_PHOTO());
			pstmt.setString(4, adoptMember.getADOPT_MEB_ADDRESS());
			pstmt.setString(5, adoptMember.getADOPT_MEB_PHONE());
			pstmt.setString(6, adoptMember.getADOPT_MEB_EMAIL());
			pstmt.setString(7, adoptMember.getADOPT_MEB_ACCOUNT());
			pstmt.setString(8, adoptMember.getADOPT_MEB_PASSWORD());
			pstmt.setString(9, adoptMember.getADOPT_MEB_STATE());
			pstmt.setString(10, adoptMember.getADOPT_MEB_AUTH());
			pstmt.setString(11, adoptMember.getADOPT_MEB_HOLIDAY());
			pstmt.setString(12, adoptMember.getADOPT_MEB_LIMIT());
			pstmt.setInt(13, adoptMember.getADOPT_MEB_NO());			

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
	
	public static void main(String[] args) {
//		insert test
//		adoptMemberDAO_interface dao = new adoptMemberDAO();
//		adoptMemberVO adoptMemberVO1 = new adoptMemberVO();
//		
//		adoptMemberVO1.setADOPT_MEB_NAME("kitty");
//		adoptMemberVO1.setADOPT_MEB_COMMENT("我是kitty領養機構");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			adoptMemberVO1.setADOPT_MEB_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		adoptMemberVO1.setADOPT_MEB_ADDRESS("桃園市中壢區復興路8號4樓");
//		adoptMemberVO1.setADOPT_MEB_PHONE("0987546695");
//		adoptMemberVO1.setADOPT_MEB_EMAIL("frtyed@gmail.com");
//		adoptMemberVO1.setADOPT_MEB_ACCOUNT("kitty123");
//		adoptMemberVO1.setADOPT_MEB_PASSWORD("123456");
//		adoptMemberVO1.setADOPT_MEB_STATE("1");
//		adoptMemberVO1.setADOPT_MEB_AUTH("1");
//		adoptMemberVO1.setADOPT_MEB_HOLIDAY("0111110");
//		adoptMemberVO1.setADOPT_MEB_LIMIT("000000003333333333000000");
//		adoptMemberVO adoptMember =  dao.insert(adoptMemberVO1);
//		System.out.println(adoptMember.getADOPT_MEB_NAME());
		
// 		update test
		adoptMemberDAO_interface dao = new adoptMemberDAO();
		adoptMemberVO adoptMemberVO2 = new adoptMemberVO();
		
		adoptMemberVO2.setADOPT_MEB_NAME("mos");
		adoptMemberVO2.setADOPT_MEB_COMMENT("我是mos領養機構");
		try {
			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
			adoptMemberVO2.setADOPT_MEB_PHOTO(pic);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		adoptMemberVO2.setADOPT_MEB_ADDRESS("桃園市中壢區復興路8號4樓");
		adoptMemberVO2.setADOPT_MEB_PHONE("0987546695");
		adoptMemberVO2.setADOPT_MEB_EMAIL("frtyed@gmail.com");
		adoptMemberVO2.setADOPT_MEB_ACCOUNT("kitty123");
		adoptMemberVO2.setADOPT_MEB_PASSWORD("123456");
		adoptMemberVO2.setADOPT_MEB_STATE("1");
		adoptMemberVO2.setADOPT_MEB_AUTH("1");
		adoptMemberVO2.setADOPT_MEB_HOLIDAY("0111110");
		adoptMemberVO2.setADOPT_MEB_LIMIT("000000003333333333000000");
		adoptMemberVO2.setADOPT_MEB_NO(3);
		dao.update(adoptMemberVO2);		
		
		
		
		
		
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
