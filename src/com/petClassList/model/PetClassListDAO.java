package com.petClassList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberNews.model.AdoptMemberNewsDAO;
import com.adoptMemberNews.model.AdoptMemberNewsVo;
import com.adoptMemberNews.model.AdoptMemberNews_interface;

public class PetClassListDAO implements PetClassList_interface {

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
	public PetClassListVO insert(PetClassListVO petClassList) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "PET_CLASS_LIST_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, petClassList, insertSQL, cols);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer ADOPT_PET_NO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PetClassListVO> findByAdoptPetNo(Integer ADOPT_PET_NO) {
		List<PetClassListVO> petClassLists = new ArrayList<>();

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
	public List<PetClassListVO> findByPetClassNo(Integer PET_CLASS_NO) {
		List<PetClassListVO> petClassLists = new ArrayList<>();

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
		PetClassList_interface dao = new PetClassListDAO();
		PetClassListVO petClassList = new PetClassListVO();

//		test insert
//		petClassList.setAdopt_pat_no(1);
//		petClassList.setPet_class_no(2);
//		petClassList.setGen_meb_pet_no(null);		
//		PetClassListVO petClassLists =  dao.insert(petClassList);
//		System.out.println(petClassList.getPet_class_list_no());

//		test find by ADOPT_PET_NO 
//		List<PetClassListVO> petClassLists = dao.findByAdoptPetNo(1);
//		for (PetClassListVO petClassList : petClassLists) {
//			System.out.print(petClassList.getPet_class_list_no() + ",");
//			System.out.print(petClassList.getAdopt_pat_no() + ",");
//			System.out.print(petClassList.getPet_class_no() + ",");
//			System.out.println(petClassList.getGen_meb_pet_no() + ",");
//			System.out.println("---------------------");
//		}
//			pmystmt.setNull(17, java.sql.Types.TIMESTAMP);

//			test find by PET_CLASS_NO
//		List<PetClassListVO> petClassLists = dao.findByPetClassNo(1);
//		for (PetClassListVO petClassList : petClassLists) {
//			System.out.print(petClassList.getPet_class_list_no() + ",");
//			System.out.print(petClassList.getAdopt_pat_no() + ",");
//			System.out.print(petClassList.getPet_class_no() + ",");
//			System.out.println(petClassList.getGen_meb_pet_no() + ",");
//			System.out.println("---------------------");
//		}

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
				petClassLists.add(petClassList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petClassLists;
	}

}
