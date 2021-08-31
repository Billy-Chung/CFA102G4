package com.petClassList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PetClassListDAO implements PetClassList_interface {

	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into PET_CLASS_LIST (ADOPT_PET_NO,PET_CLASS_NO,GEN_MEB_PET_NO,PET_CLASS_LIST_STATE) values(?,?,?,?)";
	private static final String UPDATE_SQL = "update PET_CLASS_LIST set GEN_MEB_PET_NO = ?, PET_CLASS_LIST_STATE = ? where PET_CLASS_LIST_NO = ?";
	private static final String FIND_BY_PET_NO = "SELECT * FROM PET_CLASS_LIST WHERE ADOPT_PET_NO = ?";
	private static final String FIND_BY_CLASS_NO = "SELECT * FROM PET_CLASS_LIST WHERE PET_CLASS_NO = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public PetClassListVO insert(PetClassListVO petClassList) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "PET_CLASS_LIST_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, petClassList, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				petClassList.setPet_class_list_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassList;
	}

	@Override
	public void update(PetClassListVO petClassList) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, petClassList, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	@Override
	public List<PetClassListVO> findByAdoptPetNo(Integer adopt_pat_no) {
		List<PetClassListVO> petClassLists = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PET_NO);
			pstmt.setInt(1, adopt_pat_no);
			ResultSet rs = pstmt.executeQuery();
			petClassLists = selectPetClassListByFK(petClassLists, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassLists;
	}

	@Override
	public List<PetClassListVO> findByPetClassNo(Integer pet_class_no) {
		List<PetClassListVO> petClassLists = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_CLASS_NO);
			pstmt.setInt(1, pet_class_no);
			ResultSet rs = pstmt.executeQuery();
			petClassLists = selectPetClassListByFK(petClassLists, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return petClassLists;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, PetClassListVO petClassList, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, petClassList.getAdopt_pat_no());
		pstmt.setInt(2, petClassList.getPet_class_no());
		if (petClassList.getGen_meb_pet_no() == null) {
			pstmt.setNull(3, Types.NULL);
		} else {
			pstmt.setInt(3, petClassList.getGen_meb_pet_no());
		}
		pstmt.setString(4, petClassList.getPet_class_list_state());
		return pstmt;
	}

	private List<PetClassListVO> selectPetClassListByFK(List<PetClassListVO> petClassLists, ResultSet rs) {
		try {
			while (rs.next()) {
				PetClassListVO petClassList = new PetClassListVO();
				petClassList.setPet_class_list_no(rs.getInt("PET_CLASS_LIST_NO"));
				petClassList.setAdopt_pat_no(rs.getInt("ADOPT_PET_NO"));
				petClassList.setPet_class_no(rs.getInt("PET_CLASS_NO"));
				petClassList.setGen_meb_pet_no(rs.getInt("GEN_MEB_PET_NO"));
				petClassList.setPet_class_list_state(rs.getString("PET_CLASS_LIST_STATE"));
				petClassLists.add(petClassList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClassLists;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, PetClassListVO petClassList, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, petClassList.getGen_meb_pet_no());
		pstmt.setString(2, petClassList.getPet_class_list_state());	
		pstmt.setInt(3, petClassList.getPet_class_list_no());
		return pstmt;
	}

}
