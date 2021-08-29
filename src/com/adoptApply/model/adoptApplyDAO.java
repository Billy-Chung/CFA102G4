package com.adoptApply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adoptApplyDAO implements adoptApplyDAO_interface {
	
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_APPLY (ADOPT_MEB_NO, GEN_MEB_NO, ADOPT_PET_NO, ADOPT_AUDIT_STATE, ADOPT_APPLY_PEOPLE_ID, ADOPT_APPLY_DATE, ADOPT_APPLY_STATE) values(?,?,?,?,?,?,?)";
	private static final String updateSQL = "update ADOPT_APPLY set ADOPT_MEB_NO = ?, GEN_MEB_NO = ?, ADOPT_PET_NO = ?, ADOPT_AUDIT_STATE = ?, ADOPT_APPLY_PEOPLE_ID = ?, ADOPT_APPLY_DATE = ?, ADOPT_APPLY_STATE = ? where ADOPT_APPLY_NO = ?";
	private static final String findByClassNo = "SELECT * FROM ADOPT_APPLYS WHERE ADOPT_APPLY_NO = ?";
	private static final String selectAll = "SELECT * FROM ADOPT_APPLY";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public adoptApplyVO insert(adoptApplyVO adoptApply) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "ADOPT_APPLY_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptApply, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptApply.setADOPT_APPLY_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptApply;
	}

	

	@Override
	public void update(adoptApplyVO adoptApply) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptApply, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public adoptApplyVO findByadoptApplyNo(Integer ADOPT_APPLY_NO) {
		adoptApplyVO adoptApply = new adoptApplyVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, ADOPT_APPLY_NO);
			ResultSet rs = pstmt.executeQuery();
			adoptApply = selectOneByadoptApplyNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptApply;
	}

	

	@Override
	public List<adoptApplyVO> getAlladoptApply() {
		List<adoptApplyVO> adoptApplyList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			adoptApplyList = selectAlladoptApply(adoptApplyList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptApplyList;
	}

	

	public static void main(String[] args) {
		adoptApplyDAO_interface dao = new adoptApplyDAO();
		

//		//test insert pet class
//		adoptApplyVO adoptApplyVO1 = new adoptApplyVO();
//		adoptApplyVO1.setADOPT_MEB_NO(1);
//		adoptApplyVO1.setGEN_MEB_NO(2);
//		adoptApplyVO1.setADOPT_PET_NO(10);
//		adoptApplyVO1.setADOPT_AUDIT_STATE("9");
//		adoptApplyVO1.setADOPT_APPLY_PEOPLE_ID("J122673015");
//		adoptApplyVO1.setADOPT_APPLY_DATE(java.sql.Date.valueOf("2021-08-26"));
//		adoptApplyVO1.setADOPT_APPLY_STATE("1");		
//		adoptApplyVO adoptApply =  dao.insert(adoptApplyVO1);
//		System.out.println(adoptApplyVO1.getADOPT_APPLY_NO());

//		//test update pet class
//		adoptApplyVO adoptApplyVO2 = new adoptApplyVO();
//		adoptApplyVO2.setADOPT_MEB_NO(1);
//		adoptApplyVO2.setGEN_MEB_NO(2);
//		adoptApplyVO2.setADOPT_PET_NO(10);
//		adoptApplyVO2.setADOPT_AUDIT_STATE("9");
//		adoptApplyVO2.setADOPT_APPLY_PEOPLE_ID("B266598109");
//		adoptApplyVO2.setADOPT_APPLY_DATE(java.sql.Date.valueOf("2021-08-25"));
//		adoptApplyVO2.setADOPT_APPLY_STATE("1");
//		adoptApplyVO2.setADOPT_APPLY_NO(2);
//		dao.update(adoptApplyVO2);

//		//test select one pet class
//		adoptApplyVO adoptApplyVO = new adoptApplyVO();
//		adoptApplyVO adoptApply3 = dao.findByadoptApplyNo(2);
//		System.out.print(adoptApply3.getADOPT_APPLY_NO() + ",");
//		System.out.print(adoptApply3.getADOPT_MEB_NO() + ",");
//		System.out.print(adoptApply3.getGEN_MEB_NO() + ",");
//		System.out.print(adoptApply3.getADOPT_PET_NO() + ",");
//		System.out.print(adoptApply3.getADOPT_AUDIT_STATE() + ",");		
//		System.out.print(adoptApply3.getADOPT_APPLY_PEOPLE_ID() + ",");		
//		System.out.print(adoptApply3.getADOPT_APPLY_DATE() + ",");		
//		System.out.println(adoptApply3.getADOPT_APPLY_STATE() + ",");
//		System.out.println("---------------------");
		
		//test select all pet class
		adoptApplyVO adoptApplyVO = new adoptApplyVO();
		List<adoptApplyVO> adoptApplyList = dao.getAlladoptApply();
		for (adoptApplyVO adoptApply4 : adoptApplyList) {
			System.out.print(adoptApply4.getADOPT_APPLY_NO() + ",");
			System.out.print(adoptApply4.getADOPT_MEB_NO() + ",");
			System.out.print(adoptApply4.getGEN_MEB_NO() + ",");
			System.out.print(adoptApply4.getADOPT_PET_NO() + ",");
			System.out.print(adoptApply4.getADOPT_AUDIT_STATE() + ",");		
			System.out.print(adoptApply4.getADOPT_APPLY_PEOPLE_ID() + ",");		
			System.out.print(adoptApply4.getADOPT_APPLY_DATE() + ",");		
			System.out.println(adoptApply4.getADOPT_APPLY_STATE() + ",");		
			System.out.println("---------------------");
		}

	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, adoptApplyVO adoptApply, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptApply.getADOPT_MEB_NO());
		pstmt.setInt(2, adoptApply.getGEN_MEB_NO());
		pstmt.setInt(3, adoptApply.getADOPT_PET_NO());
		pstmt.setString(4, adoptApply.getADOPT_AUDIT_STATE());
		pstmt.setString(5, adoptApply.getADOPT_APPLY_PEOPLE_ID());
		pstmt.setDate(6, adoptApply.getADOPT_APPLY_DATE());
		pstmt.setString(7, adoptApply.getADOPT_APPLY_STATE());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, adoptApplyVO adoptApply, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, adoptApply.getADOPT_MEB_NO());
		pstmt.setInt(2, adoptApply.getGEN_MEB_NO());
		pstmt.setInt(3, adoptApply.getADOPT_PET_NO());
		pstmt.setString(4, adoptApply.getADOPT_AUDIT_STATE());
		pstmt.setString(5, adoptApply.getADOPT_APPLY_PEOPLE_ID());
		pstmt.setDate(6, adoptApply.getADOPT_APPLY_DATE());
		pstmt.setString(7, adoptApply.getADOPT_APPLY_STATE());
		pstmt.setInt(8, adoptApply.getADOPT_APPLY_NO());
		return pstmt;
	}
	
	private adoptApplyVO selectOneByadoptApplyNo(ResultSet rs) {
		adoptApplyVO adoptApply = new adoptApplyVO();
		try {
			while (rs.next()) {
				adoptApply.setADOPT_APPLY_NO(rs.getInt("ADOPT_APPLY_NO"));
				adoptApply.setADOPT_MEB_NO(rs.getInt("ADOPT_MEB_NO"));
				adoptApply.setGEN_MEB_NO(rs.getInt("GEN_MEB_NO"));
				adoptApply.setADOPT_PET_NO(rs.getInt("ADOPT_PET_NO"));
				adoptApply.setADOPT_AUDIT_STATE(rs.getString("ADOPT_AUDIT_STATE"));
				adoptApply.setADOPT_APPLY_PEOPLE_ID(rs.getString("ADOPT_APPLY_PEOPLE_ID"));
				adoptApply.setADOPT_APPLY_DATE(rs.getDate("ADOPT_APPLY_DATE"));
				adoptApply.setADOPT_APPLY_STATE(rs.getString("ADOPT_APPLY_STATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptApply;
	}
	
	private List<adoptApplyVO> selectAlladoptApply(List<adoptApplyVO> adoptApplyList, ResultSet rs) {
		try {
			while (rs.next()) {
				adoptApplyVO adoptApply = new adoptApplyVO();
				adoptApply.setADOPT_APPLY_NO(rs.getInt("ADOPT_APPLY_NO"));
				adoptApply.setADOPT_MEB_NO(rs.getInt("ADOPT_MEB_NO"));
				adoptApply.setGEN_MEB_NO(rs.getInt("GEN_MEB_NO"));
				adoptApply.setADOPT_PET_NO(rs.getInt("ADOPT_PET_NO"));
				adoptApply.setADOPT_AUDIT_STATE(rs.getString("ADOPT_AUDIT_STATE"));
				adoptApply.setADOPT_APPLY_PEOPLE_ID(rs.getString("ADOPT_APPLY_PEOPLE_ID"));
				adoptApply.setADOPT_APPLY_DATE(rs.getDate("ADOPT_APPLY_DATE"));
				adoptApply.setADOPT_APPLY_STATE(rs.getString("ADOPT_APPLY_STATE"));
				adoptApplyList.add(adoptApply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptApplyList;

	}
	
}