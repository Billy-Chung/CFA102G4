package com.adoptAppointForm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdoptAppointFormDAO implements AdoptAppointForm_interface {
	
	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into ADOPT_APPOINT_FORM (ADOPT_MEB_NO,APPOINT_DATE,FINIFH_APPOINT_NUM,APPOINT_LIMIT) values(?,?,?,?)";
	private static final String UPDATE_SQL = "update ADOPT_APPOINT_FORM set FINIFH_APPOINT_NUM = ?, APPOINT_LIMIT = ? where APPOINT_FORM_NO = ?";
	private static final String FIND_BY_PK = "select * from ADOPT_APPOINT_FORM where APPOINT_FORM_NO = ?";
	private static final String FIND_BY_ADOPTMEBNO = "select * from ADOPT_APPOINT_FORM where APPOINT_FORM_NO = ?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public AdoptAppointFormVO insert(AdoptAppointFormVO adoptAppointForm) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "adopt_meb_no" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptAppointForm, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptAppointForm.setAppoint_form_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptAppointForm;
	}

	@Override
	public void update(AdoptAppointFormVO adoptAppointForm) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptAppointForm, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}

	@Override
	public AdoptAppointFormVO findByPK(Integer appoint_form_no) {		
		AdoptAppointFormVO adoptAppointForm = new AdoptAppointFormVO();
		
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, appoint_form_no);
			ResultSet rs = pstmt.executeQuery();
			adoptAppointForm = selectOneAdoptAppointFormByNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptAppointForm;
	}

	@Override
	public List<AdoptAppointFormVO> findAdoptMebNo(Integer adopt_meb_no) {
		List<AdoptAppointFormVO> adoptAppointFormList = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_ADOPTMEBNO);
			pstmt.setInt(1, adopt_meb_no);
			ResultSet rs = pstmt.executeQuery();
			adoptAppointFormList = selectAdoptAppointFormByAdoptMeb(adoptAppointFormList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptAppointFormList;
	}
		
	private PreparedStatement createInsertPreparedStatement(Connection con, AdoptAppointFormVO adoptAppointForm,
			String SQL, String[] cols) throws SQLException {
	
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptAppointForm.getAdopt_meb_no());
		pstmt.setDate(2, adoptAppointForm.getAppoint_date());
		pstmt.setString(3, adoptAppointForm.getFinifh_appoint_num());
		pstmt.setString(4, adoptAppointForm.getAppoint_limit());		
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, AdoptAppointFormVO adoptAppointForm,
			String SQL) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);		
		pstmt.setString(1, adoptAppointForm.getFinifh_appoint_num());
		pstmt.setString(2, adoptAppointForm.getAppoint_limit());
		pstmt.setInt(3, adoptAppointForm.getAdopt_meb_no());
		return pstmt;
	}

	private AdoptAppointFormVO selectOneAdoptAppointFormByNo(ResultSet rs) {
		AdoptAppointFormVO adoptAppointForm = new AdoptAppointFormVO();
		
		try {
			while (rs.next()) {
				adoptAppointForm.setAppoint_form_no(rs.getInt("APPOINT_FORM_NO"));
				adoptAppointForm.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptAppointForm.setAppoint_date(rs.getDate("APPOINT_DATE"));
				adoptAppointForm.setFinifh_appoint_num(rs.getString("FINIFH_APPOINT_NUM"));
				adoptAppointForm.setAppoint_limit(rs.getString("APPOINT_LIMIT"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptAppointForm;
	}

	private List<AdoptAppointFormVO> selectAdoptAppointFormByAdoptMeb(List<AdoptAppointFormVO> adoptAppointFormList,
			ResultSet rs) {
		try {
			while (rs.next()) {
				AdoptAppointFormVO adoptAppointForm = new AdoptAppointFormVO();
				adoptAppointForm.setAppoint_form_no(rs.getInt("APPOINT_FORM_NO"));
				adoptAppointForm.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptAppointForm.setAppoint_date(rs.getDate("APPOINT_DATE"));
				adoptAppointForm.setFinifh_appoint_num(rs.getString("FINIFH_APPOINT_NUM"));
				adoptAppointForm.setAppoint_limit(rs.getString("APPOINT_LIMIT"));	
				adoptAppointFormList.add(adoptAppointForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return adoptAppointFormList;
	}

}
