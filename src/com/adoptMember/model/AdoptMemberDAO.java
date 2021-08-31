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
	private static final String UPDATE_SQL = "update ADOPT_MEMBER set ADOPT_MEB_NAME = ?, ADOPT_MEB_COMMENT = ?, ADOPT_MEB_PHOTO = ?, ADOPT_MEB_ADDRESS = ?, ADOPT_MEB_PHONE = ?, ADOPT_MEB_EMAIL = ?, ADOPT_MEB_ACCOUNT = ?, ADOPT_MEB_PASSWORD = ?, ADOPT_MEB_STATE = ?, ADOPT_MEB_AUTH = ?, ADOPT_MEB_HOLIDAY = ?, ADOPT_MEB_LIMIT = ? where ADOPT_MEB_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ADOPT_MEMBER WHERE ADOPT_MEB_NO = ?";
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
