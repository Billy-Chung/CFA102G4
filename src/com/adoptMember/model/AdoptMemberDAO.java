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

public class AdoptMemberDAO implements AdoptMemberDAO_interface {

	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into ADOPT_MEMBER (ADOPT_MEB_NAME,ADOPT_MEB_COMMENT,ADOPT_MEB_PHOTO,ADOPT_MEB_ADDRESS,ADOPT_MEB_PHONE,ADOPT_MEB_EMAIL,ADOPT_MEB_ACCOUNT,ADOPT_MEB_PASSWORD,ADOPT_MEB_STATE,ADOPT_MEB_AUTH,ADOPT_MEB_HOLIDAY,ADOPT_MEB_LIMIT) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "update ADOPT_MEMBER set ADOPT_MEB_NAME = ?, ADOPT_MEB_COMMENT = ?, ADOPT_MEB_PHOTO = ?, ADOPT_MEB_ADDRESS = ?, ADOPT_MEB_PHONE = ?, ADOPT_MEB_EMAIL = ?, ADOPT_MEB_ACCOUNT = ?, ADOPT_MEB_PASSWORD = ?, ADOPT_MEB_STATE = ?, ADOPT_MEB_AUTH = ?, ADOPT_MEB_HOLIDAY = ?, ADOPT_MEB_LIMIT = ? where adopt_meb_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ADOPT_MEMBER WHERE adopt_meb_no = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM ADOPT_MEMBER WHERE ADOPT_MEB_NAME like ?";
	private static final String SELECT_ALL = "SELECT * FROM ADOPT_MEMBER";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public AdoptMemberVO insert(AdoptMemberVO adoptMember) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "adopt_meb_no" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptMember, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptMember.setAdopt_meb_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMember;
	}

	public void update(AdoptMemberVO adoptMember) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptMember, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public AdoptMemberVO findByAdoptMebNoPK(Integer adopt_meb_no) {
		AdoptMemberVO adoptMember = null;

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, adopt_meb_no);
			ResultSet rs = pstmt.executeQuery();
			adoptMember = selectOneAdoptMemberByNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMember;
	}

	@Override
	public List<AdoptMemberVO> findByAdoptMebName(String adopt_meb_name) {
		List<AdoptMemberVO> adoptMemberList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_NAME);
			pstmt.setString(1, "%" + adopt_meb_name + "%");
			ResultSet rs = pstmt.executeQuery();
			adoptMemberList = selectAdoptMemberByName(adoptMemberList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberList;
	}

	@Override
	public List<AdoptMemberVO> getAllAdoptMeb() {
		List<AdoptMemberVO> adoptMemberList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberList = selectAllAdoptMember(adoptMemberList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberList;
	}

	public static void main(String[] args) {
//		insert test

//		AdoptMemberDAO_interface dao = new AdoptMemberDAO();
//		AdoptMemberVO AdoptMemberVO1 = new AdoptMemberVO();
//		
//		AdoptMemberVO1.setAdopt_meb_name("kitty");
//		AdoptMemberVO1.setAdopt_meb_comment("我是kitty領養機構");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			AdoptMemberVO1.setAdopt_meb_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		AdoptMemberVO1.setAdopt_meb_address("桃園市中壢區復興路8號4樓");
//		AdoptMemberVO1.setAdopt_meb_phone("0987546695");
//		AdoptMemberVO1.setAdopt_meb_email("frtyed@gmail.com");
//		AdoptMemberVO1.setAdopt_meb_account("kitty123");
//		AdoptMemberVO1.setAdopt_meb_password("123456");
//		AdoptMemberVO1.setAdopt_meb_state("1");
//		AdoptMemberVO1.setAdopt_meb_auth("1");
//		AdoptMemberVO1.setAdopt_meb_holiday("0111110");
//		AdoptMemberVO1.setAdopt_meb_limit("000000003333333333000000");
//		AdoptMemberVO adoptMember =  dao.insert(AdoptMemberVO1);
//		System.out.println(adoptMember.getAdopt_meb_no());

// 		update test

//		AdoptMemberDAO_interface dao = new AdoptMemberDAO();
//		AdoptMemberVO AdoptMemberVO2 = new AdoptMemberVO();
//		
//		AdoptMemberVO2.setAdopt_meb_name("mos");
//		AdoptMemberVO2.setAdopt_meb_comment("我是mos領養機構");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			AdoptMemberVO2.setAdopt_meb_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		AdoptMemberVO2.setAdopt_meb_address("桃園市中壢區復興路8號4樓");
//		AdoptMemberVO2.setAdopt_meb_phone("0987546695");
//		AdoptMemberVO2.setAdopt_meb_email("frtyed@gmail.com");
//		AdoptMemberVO2.setAdopt_meb_account("kitty123");
//		AdoptMemberVO2.setAdopt_meb_password("123456");
//		AdoptMemberVO2.setAdopt_meb_state("1");
//		AdoptMemberVO2.setAdopt_meb_auth("1");
//		AdoptMemberVO2.setAdopt_meb_holiday("0111110");
//		AdoptMemberVO2.setAdopt_meb_limit("000000003333333333000000");
//		AdoptMemberVO2.setAdopt_meb_no(3);
//		dao.update(AdoptMemberVO2);		

//		find by PK test

//		AdoptMemberDAO_interface dao = new AdoptMemberDAO();
//		AdoptMemberVO AdoptMemberVO3 = dao.findByAdoptMebNoPK(2);
//		System.out.print(AdoptMemberVO3.getAdopt_meb_name() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_name() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_comment() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_photo() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_address() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_phone() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_email() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_account() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_password() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_state() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_auth() + ",");
//		System.out.print(AdoptMemberVO3.getAdopt_meb_holiday() + ",");
//		System.out.println(AdoptMemberVO3.getAdopt_meb_limit() + ",");
//		System.out.println("---------------------");

//		find by name test
//		AdoptMemberDAO_interface dao = new AdoptMemberDAO();
//		List<AdoptMemberVO> adoptMemberList = dao.findByAdoptMebName("M");	
//		for (AdoptMemberVO adoptMember5 : adoptMemberList) {			
//			System.out.print(adoptMember5.getAdopt_meb_no() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_name() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_comment() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_photo() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_address() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_phone() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_email() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_account() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_password() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_state() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_auth() + ",");
//			System.out.print(adoptMember5.getAdopt_meb_holiday() + ",");
//			System.out.println(adoptMember5.getAdopt_meb_limit() + ",");
//			System.out.println("---------------------");
//		}

//		select All test

//		AdoptMemberDAO_interface dao = new AdoptMemberDAO();
//		List<AdoptMemberVO> adoptMemberList = dao.getAllAdoptMeb();
//		for (AdoptMemberVO adoptMember4 : adoptMemberList) {
//			System.out.print(adoptMember4.getAdopt_meb_name() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_comment() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_photo() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_address() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_phone() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_email() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_account() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_password() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_state() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_auth() + ",");
//			System.out.print(adoptMember4.getAdopt_meb_holiday() + ",");
//			System.out.println(adoptMember4.getAdopt_meb_limit() + ",");
//			System.out.println("---------------------");
//		}

	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, AdoptMemberVO adoptMember, String SQL,
			String[] cols) throws SQLException {

		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setString(1, adoptMember.getAdopt_meb_name());
		pstmt.setString(2, adoptMember.getAdopt_meb_comment());
		pstmt.setBytes(3, adoptMember.getAdopt_meb_photo());
		pstmt.setString(4, adoptMember.getAdopt_meb_address());
		pstmt.setString(5, adoptMember.getAdopt_meb_phone());
		pstmt.setString(6, adoptMember.getAdopt_meb_email());
		pstmt.setString(7, adoptMember.getAdopt_meb_account());
		pstmt.setString(8, adoptMember.getAdopt_meb_password());
		pstmt.setString(9, adoptMember.getAdopt_meb_state());
		pstmt.setString(10, adoptMember.getAdopt_meb_auth());
		pstmt.setString(11, adoptMember.getAdopt_meb_holiday());
		pstmt.setString(12, adoptMember.getAdopt_meb_limit());
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, AdoptMemberVO adoptMember, String SQL)
			throws SQLException {

		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, adoptMember.getAdopt_meb_name());
		pstmt.setString(2, adoptMember.getAdopt_meb_comment());
		pstmt.setBytes(3, adoptMember.getAdopt_meb_photo());
		pstmt.setString(4, adoptMember.getAdopt_meb_address());
		pstmt.setString(5, adoptMember.getAdopt_meb_phone());
		pstmt.setString(6, adoptMember.getAdopt_meb_email());
		pstmt.setString(7, adoptMember.getAdopt_meb_account());
		pstmt.setString(8, adoptMember.getAdopt_meb_password());
		pstmt.setString(9, adoptMember.getAdopt_meb_state());
		pstmt.setString(10, adoptMember.getAdopt_meb_auth());
		pstmt.setString(11, adoptMember.getAdopt_meb_holiday());
		pstmt.setString(12, adoptMember.getAdopt_meb_limit());
		pstmt.setInt(13, adoptMember.getAdopt_meb_no());
		return pstmt;
	}

	private AdoptMemberVO selectOneAdoptMemberByNo(ResultSet rs) {
		AdoptMemberVO adoptMember = new AdoptMemberVO();
		try {
			while (rs.next()) {
				adoptMember.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptMember.setAdopt_meb_name(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setAdopt_meb_comment(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setAdopt_meb_photo(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setAdopt_meb_address(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setAdopt_meb_phone(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setAdopt_meb_email(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setAdopt_meb_account(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setAdopt_meb_password(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setAdopt_meb_state(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setAdopt_meb_auth(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setAdopt_meb_holiday(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setAdopt_meb_limit(rs.getString("ADOPT_MEB_LIMIT"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adoptMember;
	}

	private List<AdoptMemberVO> selectAdoptMemberByName(List<AdoptMemberVO> adoptMemberList, ResultSet rs) {

		try {
			while (rs.next()) {
				AdoptMemberVO adoptMember = new AdoptMemberVO();
				adoptMember.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptMember.setAdopt_meb_name(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setAdopt_meb_comment(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setAdopt_meb_photo(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setAdopt_meb_address(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setAdopt_meb_phone(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setAdopt_meb_email(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setAdopt_meb_account(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setAdopt_meb_password(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setAdopt_meb_state(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setAdopt_meb_auth(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setAdopt_meb_holiday(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setAdopt_meb_limit(rs.getString("ADOPT_MEB_LIMIT"));
				adoptMemberList.add(adoptMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adoptMemberList;
	}

	private List<AdoptMemberVO> selectAllAdoptMember(List<AdoptMemberVO> adoptMemberList, ResultSet rs) {

		try {
			while (rs.next()) {
				AdoptMemberVO adoptMember = new AdoptMemberVO();
				adoptMember.setAdopt_meb_name(rs.getString("ADOPT_MEB_NAME"));
				adoptMember.setAdopt_meb_comment(rs.getString("ADOPT_MEB_COMMENT"));
				adoptMember.setAdopt_meb_photo(rs.getBytes("ADOPT_MEB_PHOTO"));
				adoptMember.setAdopt_meb_address(rs.getString("ADOPT_MEB_ADDRESS"));
				adoptMember.setAdopt_meb_phone(rs.getString("ADOPT_MEB_PHONE"));
				adoptMember.setAdopt_meb_email(rs.getString("ADOPT_MEB_EMAIL"));
				adoptMember.setAdopt_meb_account(rs.getString("ADOPT_MEB_ACCOUNT"));
				adoptMember.setAdopt_meb_password(rs.getString("ADOPT_MEB_PASSWORD"));
				adoptMember.setAdopt_meb_state(rs.getString("ADOPT_MEB_STATE"));
				adoptMember.setAdopt_meb_auth(rs.getString("ADOPT_MEB_AUTH"));
				adoptMember.setAdopt_meb_holiday(rs.getString("ADOPT_MEB_HOLIDAY"));
				adoptMember.setAdopt_meb_limit(rs.getString("ADOPT_MEB_LIMIT"));
				adoptMemberList.add(adoptMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberList;
	}

}
