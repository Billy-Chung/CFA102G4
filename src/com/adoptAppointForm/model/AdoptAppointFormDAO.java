package com.adoptAppointForm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdoptAppointFormVO findByPK(Integer appoint_form_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdoptAppointFormVO> findAdoptMebNo(Integer adopt_meb_no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		AdoptAppointForm_interface dao = new AdoptAppointFormDAO();
		AdoptAppointFormVO adoptAppointForm = new AdoptAppointFormVO();
		
//		test insert
		adoptAppointForm.setAdopt_meb_no(1);
		adoptAppointForm.setAppoint_date(java.sql.Date.valueOf("2016-08-29"));
		adoptAppointForm.setFinifh_appoint_num("000000000000000000000000");
		adoptAppointForm.setAppoint_limit("000000003333333333000000");
		AdoptAppointFormVO adoptAppointFormData = dao.insert(adoptAppointForm);
		System.out.println(adoptAppointFormData.getAppoint_form_no());
		
		
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

}
