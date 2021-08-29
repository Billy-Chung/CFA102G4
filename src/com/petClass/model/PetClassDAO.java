package com.petClass.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 


public class PetClassDAO implements PetClasss_interface {

	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into PET_CLASS (PET_CLASS_NAME,PET_CLASS_STATE) values(?,?)";
	private static final String UPDATE_SQL = "update PET_CLASS set PET_CLASS_NAME = ?,PET_CLASS_STATE = ? where PET_CLASS_NO = ?";
	private static final String FIND_BY_CLASS_NO = "SELECT * FROM PET_CLASS WHERE PET_CLASS_NO = ?";
	private static final String SELECT_ALL = "SELECT * FROM PET_CLASS";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public PetClassVO insert(PetClassVO petClass) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "PET_CLASS_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, petClass, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				petClass.setPet_class_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClass;
	}

	

	@Override
	public void update(PetClassVO petClass) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, petClass, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	

	@Override
	public PetClassVO findBypetClassNo(Integer pet_class_no) {
		PetClassVO petClass = new PetClassVO();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_CLASS_NO);
			pstmt.setInt(1, pet_class_no);
			ResultSet rs = pstmt.executeQuery();
			petClass = selectOneByPetClassNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClass;
	}

	

	@Override
	public List<PetClassVO> getAllpetClass() {
		List<PetClassVO> petClassList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			petClassList = selectAllpetClass(petClassList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassList;
	}
	
	private PreparedStatement createInsertPreparedStatement(Connection con, PetClassVO petClass, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setString(1, petClass.getPet_class_name());
		pstmt.setString(2, petClass.getPet_class_state());
		return pstmt;
	}
	
	private PreparedStatement createUpdatePreparedStatement(Connection con, PetClassVO petClass, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, petClass.getPet_class_name());
		pstmt.setString(2, petClass.getPet_class_state());
		pstmt.setInt(3, petClass.getPet_class_no());
		return pstmt;
	}
	
	private PetClassVO selectOneByPetClassNo(ResultSet rs) {
		PetClassVO petClass = new PetClassVO();
		try {
			while (rs.next()) {
				petClass.setPet_class_no(rs.getInt("PET_CLASS_NO"));
				petClass.setPet_class_name(rs.getString("PET_CLASS_NAME"));
				petClass.setPet_class_state(rs.getString("PET_CLASS_STATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClass;
	}
	
	private List<PetClassVO> selectAllpetClass(List<PetClassVO> petClassList, ResultSet rs) {
		try {
			while (rs.next()) {
				PetClassVO petClass = new PetClassVO();
				petClass.setPet_class_no(rs.getInt("PET_CLASS_NO"));
				petClass.setPet_class_name(rs.getString("PET_CLASS_NAME"));
				petClass.setPet_class_state(rs.getString("PET_CLASS_STATE"));
				petClassList.add(petClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClassList;

	}

}
