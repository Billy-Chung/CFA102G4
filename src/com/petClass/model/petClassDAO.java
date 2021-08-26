package com.petClass.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberNews.model.adoptMemberNewsVo;



public class petClassDAO implements petClasss_interface {

	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into PET_CLASS (PET_CLASS_NAME,PET_CLASS_STATE) values(?,?)";
	private static final String updateSQL = "update PET_CLASS set PET_CLASS_NAME = ?,PET_CLASS_STATE = ? where PET_CLASS_NO = ?";
	private static final String findByClassNo = "SELECT * FROM PET_CLASS WHERE PET_CLASS_NO = ?";
	private static final String selectAll = "SELECT * FROM PET_CLASS";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public petClassVO insert(petClassVO petClass) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PET_CLASS_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, petClass, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				petClass.setPET_CLASS_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClass;
	}

	public PreparedStatement createInsertPreparedStatement(Connection con, petClassVO petClass, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setString(1, petClass.getPET_CLASS_NAME());
		pstmt.setString(2, petClass.getPET_CLASS_STATE());
		return pstmt;
	}

	@Override
	public void update(petClassVO petClass) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, petClass, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public PreparedStatement createUpdatePreparedStatement(Connection con, petClassVO petClass, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, petClass.getPET_CLASS_NAME());
		pstmt.setString(2, petClass.getPET_CLASS_STATE());
		pstmt.setInt(3, petClass.getPET_CLASS_NO());
		return pstmt;

	}

	@Override
	public petClassVO findBypetClassNo(Integer PET_CLASS_NO) {
		petClassVO petClass = new petClassVO();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByClassNo);
			pstmt.setInt(1, PET_CLASS_NO);
			ResultSet rs = pstmt.executeQuery();
			petClass = selectOneByPetClassNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClass;
	}

	private petClassVO selectOneByPetClassNo(ResultSet rs) {
		petClassVO petClass = new petClassVO();
		try {
			while (rs.next()) {
				petClass.setPET_CLASS_NO(rs.getInt("PET_CLASS_NO"));
				petClass.setPET_CLASS_NAME(rs.getString("PET_CLASS_NAME"));
				petClass.setPET_CLASS_STATE(rs.getString("PET_CLASS_STATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClass;
	}

	@Override
	public List<petClassVO> getAllpetClass() {
		List<petClassVO> petClassList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			petClassList = selectAllpetClass(petClassList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassList;
	}

	public List<petClassVO> selectAllpetClass(List<petClassVO> petClassList, ResultSet rs) {

		try {
			while (rs.next()) {
				petClassVO petClass = new petClassVO();
				petClass.setPET_CLASS_NO(rs.getInt("PET_CLASS_NO"));
				petClass.setPET_CLASS_NAME(rs.getString("PET_CLASS_NAME"));
				petClass.setPET_CLASS_STATE(rs.getString("PET_CLASS_STATE"));
				petClassList.add(petClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClassList;

	}

	public static void main(String[] args) {
		petClasss_interface dao = new petClassDAO();
		petClassVO petClassVO = new petClassVO();

//		test insert pet class
//		petClassVO.setPET_CLASS_NAME("壁虎");
//		petClassVO.setPET_CLASS_STATE("1");		
//		petClassVO petClass =  dao.insert(petClassVO);
//		System.out.println(petClassVO.getPET_CLASS_NO());

//		test update pet class
//		petClassVO.setPET_CLASS_NAME("老鼠");
//		petClassVO.setPET_CLASS_STATE("1");
//		petClassVO.setPET_CLASS_NO(9);
//		dao.update(petClassVO);

//		test select one pet class
//		petClassVO petClass = dao.findBypetClassNo(2);
//		System.out.print(petClass.getPET_CLASS_NO() + ",");
//		System.out.print(petClass.getPET_CLASS_NAME() + ",");
//		System.out.println(petClass.getPET_CLASS_STATE() + ",");
//		System.out.println("---------------------");
		
//		test select all pet class
		List<petClassVO> petClassList = dao.getAllpetClass();
		for (petClassVO petClass : petClassList) {
			System.out.print(petClass.getPET_CLASS_NO() + ",");
			System.out.print(petClass.getPET_CLASS_NAME() + ",");
			System.out.println(petClass.getPET_CLASS_STATE() + ",");				
			System.out.println("---------------------");
		}

	}

}
