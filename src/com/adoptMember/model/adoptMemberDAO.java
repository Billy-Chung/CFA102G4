package com.adoptMember.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adoptMemberDAO implements adoptMemberDAO_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_MEMBER (ADOPT_MEB_NAME,ADOPT_MEB_COMMENT,ADOPT_MEB_PHOTO,ADOPT_MEB_ADDRESS,ADOPT_MEB_PHONE,ADOPT_MEB_EMAIL,ADOPT_MEB_ACCOUNT,ADOPT_MEB_PASSWORD,ADOPT_MEB_STATE,ADOPT_MEB_AUTH,ADOPT_MEB_HOLIDAY,ADOPT_MEB_LIMIT) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String updateSQL = "update ADOPT_MEMBER set ADOPT_MEB_NAME = ?, ADOPT_MEB_COMMENT = ?, ADOPT_MEB_PHOTO = ?, ADOPT_MEB_ADDRESS = ?, ADOPT_MEB_PHONE = ?, ADOPT_MEB_EMAIL = ?, ADOPT_MEB_ACCOUNT = ?, ADOPT_MEB_PASSWORD = ?, ADOPT_MEB_STATE = ?, ADOPT_MEB_AUTH = ?, ADOPT_MEB_HOLIDAY = ?, ADOPT_MEB_LIMIT = ? where ADOPT_MEB_NO = ?";
	private static final String findByPK = "SELECT * FROM ADOPT_MEMBER WHERE ADOPT_MEB_NO = ?";
	private static final String findByName = "SELECT * FROM ADOPT_MEMBER WHERE ADOPT_MEB_NAME like ?";
	private static final String selectAll = "SELECT * FROM ADOPT_MEMBER";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public adoptMemberVO insert(adoptMemberVO adoptMember) {		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){
			String[] cols = { "ADOPT_MEB_NO" };			
			PreparedStatement pstmt = createInsertPreparedStatement(con,adoptMember,insertSQL, cols);
			pstmt.executeUpdate();			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptMember.setADOPT_MEB_NO(key);
			} 
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
		return adoptMember;
	}

	public void update(adoptMemberVO adoptMember) {		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = createUpdatePreparedStatement(con,adoptMember,updateSQL);
			pstmt.executeUpdate();	
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
	}

	@Override
	public adoptMemberVO findByAdoptMebNoPK(Integer ADOPT_MEB_NO) {
		adoptMemberVO adoptMember = null;
		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = con.prepareStatement(findByPK);
			pstmt.setInt(1, ADOPT_MEB_NO);				
			ResultSet rs = pstmt.executeQuery();
			adoptMember = selectOneAdoptMemberByNo(rs);
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
		return adoptMember;
	}
	
	

	@Override
	public List<adoptMemberVO> findByAdoptMebName(String ADOPT_MEB_NAME) {
		List<adoptMemberVO> adoptMemberList  = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = con.prepareStatement(findByName);
			pstmt.setString(1, "%" + ADOPT_MEB_NAME + "%");				
			ResultSet rs = pstmt.executeQuery();
			adoptMemberList = selectOneAdoptMemberByName(adoptMemberList,rs);
		}  catch (SQLException se) {
			se.printStackTrace();
		}	
		return adoptMemberList;
	}		
		
	
	

	@Override
	public List<adoptMemberVO> getAllAdoptMeb() {
		List<adoptMemberVO> adoptMemberList = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASSWORD)){					
			PreparedStatement pstmt = con.prepareStatement(selectAll);						
			ResultSet rs = pstmt.executeQuery();
			adoptMemberList = selectAllAdoptMember(adoptMemberList,rs);
		}  catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberList;
	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, adoptMemberVO adoptMember, String SQL, String[] cols) throws SQLException {
		   
	    PreparedStatement pstmt = con.prepareStatement(SQL,cols);
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
	    return pstmt;
	}
	
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, adoptMemberVO adoptMember, String SQL) throws SQLException {
		   
	    PreparedStatement pstmt = con.prepareStatement(SQL);	    
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
	    return pstmt;
	}
	

	private adoptMemberVO selectOneAdoptMemberByNo (ResultSet rs) {		
		adoptMemberVO adoptMember = new adoptMemberVO();
		try {
			while (rs.next()) {				
				adoptMember.setADOPT_MEB_NAME(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setADOPT_MEB_COMMENT(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setADOPT_MEB_PHOTO(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setADOPT_MEB_ADDRESS(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setADOPT_MEB_PHONE(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setADOPT_MEB_EMAIL(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setADOPT_MEB_ACCOUNT(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setADOPT_MEB_PASSWORD(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setADOPT_MEB_STATE(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setADOPT_MEB_AUTH(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setADOPT_MEB_HOLIDAY(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setADOPT_MEB_LIMIT(rs.getString("ADOPT_MEB_LIMIT"));

			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return adoptMember;
	}
	
	private List<adoptMemberVO> selectOneAdoptMemberByName(List<adoptMemberVO> adoptMemberList,ResultSet rs){
		
		try {
			while (rs.next()) {
				adoptMemberVO adoptMember = new adoptMemberVO();
				adoptMember.setADOPT_MEB_NAME(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setADOPT_MEB_COMMENT(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setADOPT_MEB_PHOTO(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setADOPT_MEB_ADDRESS(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setADOPT_MEB_PHONE(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setADOPT_MEB_EMAIL(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setADOPT_MEB_ACCOUNT(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setADOPT_MEB_PASSWORD(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setADOPT_MEB_STATE(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setADOPT_MEB_AUTH(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setADOPT_MEB_HOLIDAY(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setADOPT_MEB_LIMIT(rs.getString("ADOPT_MEB_LIMIT"));
				adoptMemberList.add(adoptMember);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return adoptMemberList;  
	}
	
	
	private List<adoptMemberVO> selectAllAdoptMember(List<adoptMemberVO> adoptMemberList,ResultSet rs){
		
		try {
			while (rs.next()) {
				adoptMemberVO adoptMember = new adoptMemberVO();
				adoptMember.setADOPT_MEB_NAME(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setADOPT_MEB_COMMENT(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setADOPT_MEB_PHOTO(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setADOPT_MEB_ADDRESS(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setADOPT_MEB_PHONE(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setADOPT_MEB_EMAIL(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setADOPT_MEB_ACCOUNT(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setADOPT_MEB_PASSWORD(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setADOPT_MEB_STATE(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setADOPT_MEB_AUTH(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setADOPT_MEB_HOLIDAY(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setADOPT_MEB_LIMIT(rs.getString("ADOPT_MEB_LIMIT"));
				adoptMemberList.add(adoptMember);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return adoptMemberList;
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
//		System.out.println(adoptMember.getADOPT_MEB_NO());

// 		update test
		
//		adoptMemberDAO_interface dao = new adoptMemberDAO();
//		adoptMemberVO adoptMemberVO2 = new adoptMemberVO();
//		
//		adoptMemberVO2.setADOPT_MEB_NAME("mos");
//		adoptMemberVO2.setADOPT_MEB_COMMENT("我是mos領養機構");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			adoptMemberVO2.setADOPT_MEB_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		adoptMemberVO2.setADOPT_MEB_ADDRESS("桃園市中壢區復興路8號4樓");
//		adoptMemberVO2.setADOPT_MEB_PHONE("0987546695");
//		adoptMemberVO2.setADOPT_MEB_EMAIL("frtyed@gmail.com");
//		adoptMemberVO2.setADOPT_MEB_ACCOUNT("kitty123");
//		adoptMemberVO2.setADOPT_MEB_PASSWORD("123456");
//		adoptMemberVO2.setADOPT_MEB_STATE("1");
//		adoptMemberVO2.setADOPT_MEB_AUTH("1");
//		adoptMemberVO2.setADOPT_MEB_HOLIDAY("0111110");
//		adoptMemberVO2.setADOPT_MEB_LIMIT("000000003333333333000000");
//		adoptMemberVO2.setADOPT_MEB_NO(3);
//		dao.update(adoptMemberVO2);		

//		find by PK test
		
//		adoptMemberDAO_interface dao = new adoptMemberDAO();
//		adoptMemberVO adoptMemberVO3 = dao.findByAdoptMebNoPK(2);
//		System.out.print(adoptMemberVO3.getADOPT_MEB_NAME() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_COMMENT() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_PHOTO() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_ADDRESS() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_PHONE() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_EMAIL() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_ACCOUNT() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_PASSWORD() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_STATE() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_AUTH() + ",");
//		System.out.print(adoptMemberVO3.getADOPT_MEB_HOLIDAY() + ",");
//		System.out.println(adoptMemberVO3.getADOPT_MEB_LIMIT() + ",");	
//		System.out.println("---------------------");
		
//		find by name test
//		adoptMemberDAO_interface dao = new adoptMemberDAO();
//		List<adoptMemberVO> adoptMemberList = dao.findByAdoptMebName("M");	
//		for (adoptMemberVO adoptMember5 : adoptMemberList) {			
//			System.out.print(adoptMember5.getADOPT_MEB_NAME() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_COMMENT() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_PHOTO() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_ADDRESS() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_PHONE() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_EMAIL() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_ACCOUNT() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_PASSWORD() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_STATE() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_AUTH() + ",");
//			System.out.print(adoptMember5.getADOPT_MEB_HOLIDAY() + ",");
//			System.out.println(adoptMember5.getADOPT_MEB_LIMIT() + ",");
//			System.out.println("---------------------");
//		}

//		select All test
		
		adoptMemberDAO_interface dao = new adoptMemberDAO();
		List<adoptMemberVO> adoptMemberList = dao.getAllAdoptMeb();
		for (adoptMemberVO adoptMember4 : adoptMemberList) {
			System.out.print(adoptMember4.getADOPT_MEB_NAME() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_COMMENT() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_PHOTO() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_ADDRESS() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_PHONE() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_EMAIL() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_ACCOUNT() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_PASSWORD() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_STATE() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_AUTH() + ",");
			System.out.print(adoptMember4.getADOPT_MEB_HOLIDAY() + ",");
			System.out.println(adoptMember4.getADOPT_MEB_LIMIT() + ",");
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

}
