package com.petClassList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberNews.model.adoptMemberNewsDAO;
import com.adoptMemberNews.model.adoptMemberNewsVo;
import com.adoptMemberNews.model.adoptMemberNews_interface;

public class petClassListDAO implements petClassList_interface {

	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into PET_CLASS_LIST (ADOPT_PET_NO,PET_CLASS_NO,GEN_MEB_PET_NO) values(?,?,?)";
	private static final String updateSQL = "update PET_CLASS_LIST set PET_CLASS_NO = ?, GEN_MEB_PET_NO = ? where ADOPT_PET_NO = ?";
	private static final String delete = "delect FROM PET_CLASS_LIST WHERE ADOPT_PET_NO = ?";
	private static final String findByPetNo = "SELECT * FROM PET_CLASS_LIST WHERE ADOPT_PET_NO = ?";
	private static final String findByClassNo = "SELECT * FROM PET_CLASS_LIST WHERE PET_CLASS_NO = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public petClassListVO insert(petClassListVO petClassList) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PET_CLASS_LIST_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, petClassList, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				petClassList.setPET_CLASS_LIST_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassList;
	}

	@Override
	public void update(petClassListVO petClassList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer ADOPT_PET_NO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<petClassListVO> findByAdoptPetNo(Integer ADOPT_PET_NO) {
		List<petClassListVO> petClassLists = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByPetNo);
			pstmt.setInt(1, ADOPT_PET_NO);
			ResultSet rs = pstmt.executeQuery();
			petClassLists = selectPetClassListByFK(petClassLists, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassLists;
	}

	@Override
	public List<petClassListVO> findByPetClassNo(Integer PET_CLASS_NO) {
		List<petClassListVO> petClassLists = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, PET_CLASS_NO);
			ResultSet rs = pstmt.executeQuery();
			petClassLists = selectPetClassListByFK(petClassLists, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassLists;
	}

	public static void main(String[] args) {
		petClassList_interface dao = new petClassListDAO();
//		petClassListVO petClassList = new petClassListVO();

//		test insert
//		petClassList.setADOPT_PET_NO(1);
//		petClassList.setPET_CLASS_NO(2);
//		petClassList.setGEN_MEB_PET_NO(null);		
//		petClassListVO petClassLists =  dao.insert(petClassList);
//		System.out.println(petClassList.getPET_CLASS_LIST_NO());

//		test find by ADOPT_PET_NO 
//		List<petClassListVO> petClassLists = dao.findByAdoptPetNo(1);
//		for (petClassListVO petClassList : petClassLists) {
//			System.out.print(petClassList.getPET_CLASS_LIST_NO() + ",");
//			System.out.print(petClassList.getADOPT_PET_NO() + ",");
//			System.out.print(petClassList.getPET_CLASS_NO() + ",");
//			System.out.println(petClassList.getGEN_MEB_PET_NO() + ",");
//			System.out.println("---------------------");
//			pmystmt.setNull(17, java.sql.Types.TIMESTAMP);

//			test find by PET_CLASS_NO
		List<petClassListVO> petClassLists = dao.findByPetClassNo(1);
		for (petClassListVO petClassList : petClassLists) {
			System.out.print(petClassList.getPET_CLASS_LIST_NO() + ",");
			System.out.print(petClassList.getADOPT_PET_NO() + ",");
			System.out.print(petClassList.getPET_CLASS_NO() + ",");
			System.out.println(petClassList.getGEN_MEB_PET_NO() + ",");
			System.out.println("---------------------");
		}

	}

	private PreparedStatement createInsertPreparedStatement(Connection con, petClassListVO petClassList, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, petClassList.getADOPT_PET_NO());
		pstmt.setInt(2, petClassList.getPET_CLASS_NO());
		if (petClassList.getGEN_MEB_PET_NO() == null) {
			pstmt.setNull(3, Types.NULL);
		} else {
			pstmt.setInt(3, petClassList.getGEN_MEB_PET_NO());
		}
		return pstmt;
	}

	private List<petClassListVO> selectPetClassListByFK(List<petClassListVO> petClassLists, ResultSet rs) {
		try {
			while (rs.next()) {
				petClassListVO petClassList = new petClassListVO();
				petClassList.setPET_CLASS_LIST_NO(rs.getInt("PET_CLASS_LIST_NO"));
				petClassList.setADOPT_PET_NO(rs.getInt("ADOPT_PET_NO"));
				petClassList.setPET_CLASS_NO(rs.getInt("PET_CLASS_NO"));
				petClassList.setGEN_MEB_PET_NO(rs.getInt("GEN_MEB_PET_NO"));
				petClassLists.add(petClassList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClassLists;
	}

}
