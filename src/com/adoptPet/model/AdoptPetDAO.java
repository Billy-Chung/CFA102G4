package com.adoptPet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.adoptMember.model.AdoptMemberVO;
import com.petClassList.model.PetClassListVO;

public class AdoptPetDAO implements AdoptPet_interface {
	
	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into ADOPT_PET (ADOPT_MEB_NO,GEN_MEB_NO,ADOPT_PET_BREEDS,ADOPT_PET_GENDER,ADOPT_PET_COME_FORM,ADOPT_PET_JOIN_DATE,ADOPT_PET_CHIP,ADOPT_PET_JOIN_REASON,CAPTURE_ADDRESS,ADOPT_PET_STERILIZATION,CONTAIN_NUMBER,ADOPT_PET_COLOR,ADOPT_PET_STATE) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "update ADOPT_PET set GEN_MEB_NO = ?, ADOPT_PET_BREEDS = ?, ADOPT_PET_GENDER = ?, ADOPT_PET_COME_FORM = ?, ADOPT_PET_JOIN_DATE = ?, ADOPT_PET_CHIP = ?, ADOPT_PET_JOIN_REASON = ?, CAPTURE_ADDRESS = ?, ADOPT_PET_STERILIZATION = ?, CONTAIN_NUMBER = ?, ADOPT_PET_COLOR = ?, ADOPT_PET_STATE = ? where ADOPT_PET_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ADOPT_PET WHERE ADOPT_PET_NO = ?";
	private static final String FIND_BY_FK = "SELECT * FROM ADOPT_PET WHERE ADOPT_MEB_NO = ?";
	private static final String SELECT_ALL = "SELECT * FROM ADOPT_PET";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public AdoptPetVO insert(AdoptPetVO adoptPet) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "adopt_meb_no" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptPet, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptPet.setAdopt_meb_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPet;
	}
	
	@Override
	public void update(AdoptPetVO adoptPet) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptPet, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	@Override
	public AdoptPetVO findByAdoptPetNoPK(Integer adopt_pet_no) {
		AdoptPetVO adoptPet = null;
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, adopt_pet_no);
			ResultSet rs = pstmt.executeQuery();
			adoptPet = selectOneAdoptPetByNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPet;
	}
	
	@Override
	public List<AdoptPetVO> findByAdoptMebNo(Integer adopt_meb_no) {
		List<AdoptPetVO> adoptPetList = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_FK);
			pstmt.setInt(1, adopt_meb_no);
			ResultSet rs = pstmt.executeQuery();
			adoptPetList = selectAdoptPetByMebNo(adoptPetList,rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPetList;
	}
	
	@Override
	public List<AdoptPetVO> getAllAdoptPet() {
		List<AdoptPetVO> adoptPetList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			adoptPetList = selectAllAdoptPet(adoptPetList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptPetList;
	}
	
	private List<AdoptPetVO> selectAllAdoptPet (List<AdoptPetVO> adoptPetList, ResultSet rs) {
		
		try {
			while (rs.next()) {
				AdoptPetVO adoptPet = new AdoptPetVO();
				adoptPet.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				adoptPet.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptPet.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				adoptPet.setAdopt_pet_breeds(rs.getString("ADOPT_PET_BREEDS"));
				adoptPet.setAdopt_pet_gender(rs.getString("ADOPT_PET_GENDER"));
				adoptPet.setAdopt_pet_come_form(rs.getString("ADOPT_PET_COME_FORM"));
				adoptPet.setAdopt_pet_join_date(rs.getDate("ADOPT_PET_JOIN_DATE"));
				adoptPet.setAdopt_pet_chip(rs.getString("ADOPT_PET_CHIP"));
				adoptPet.setAdopt_pet_join_reason(rs.getString("ADOPT_PET_JOIN_REASON"));
				adoptPet.setCapture_address(rs.getString("CAPTURE_ADDRESS"));
				adoptPet.setAdopt_pet_sterilization(rs.getString("ADOPT_PET_STERILIZATION"));
				adoptPet.setContain_number(rs.getString("CONTAIN_NUMBER"));
				adoptPet.setAdopt_pet_color(rs.getString("ADOPT_PET_COLOR"));
				adoptPet.setAdopt_pet_state(rs.getString("ADOPT_PET_STATE"));
				adoptPetList.add(adoptPet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptPetList;
		
		
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, AdoptPetVO adoptPet, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptPet.getAdopt_meb_no());
		
		if (adoptPet.getGen_meb_no() == 0) {
			pstmt.setNull(2, Types.NULL);
		} else {
			pstmt.setInt(2, adoptPet.getGen_meb_no());
		}
		pstmt.setString(3, adoptPet.getAdopt_pet_breeds());
		pstmt.setString(4, adoptPet.getAdopt_pet_gender());
		pstmt.setString(5, adoptPet.getAdopt_pet_come_form());
		pstmt.setDate(6, adoptPet.getAdopt_pet_join_date());
		pstmt.setString(7, adoptPet.getAdopt_pet_chip());
		pstmt.setString(8, adoptPet.getAdopt_pet_join_reason());
		pstmt.setString(9, adoptPet.getCapture_address());
		pstmt.setString(10, adoptPet.getAdopt_pet_sterilization());
		pstmt.setString(11, adoptPet.getContain_number());
		pstmt.setString(12, adoptPet.getAdopt_pet_color());
		pstmt.setString(13, adoptPet.getAdopt_pet_state());
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, AdoptPetVO adoptPet, String SQL
			) throws SQLException {
		
		PreparedStatement pstmt = con.prepareStatement(SQL);		
		
		if (adoptPet.getGen_meb_no() == 0) {
			pstmt.setNull(1, Types.NULL);
		} else {
			pstmt.setInt(1, adoptPet.getGen_meb_no());
		}
		pstmt.setString(2, adoptPet.getAdopt_pet_breeds());
		pstmt.setString(3, adoptPet.getAdopt_pet_gender());
		pstmt.setString(4, adoptPet.getAdopt_pet_come_form());
		pstmt.setDate(5, adoptPet.getAdopt_pet_join_date());
		pstmt.setString(6, adoptPet.getAdopt_pet_chip());
		pstmt.setString(7, adoptPet.getAdopt_pet_join_reason());
		pstmt.setString(8, adoptPet.getCapture_address());
		pstmt.setString(9, adoptPet.getAdopt_pet_sterilization());
		pstmt.setString(10, adoptPet.getContain_number());
		pstmt.setString(11, adoptPet.getAdopt_pet_color());
		pstmt.setString(12, adoptPet.getAdopt_pet_state());
		pstmt.setInt(13, adoptPet.getAdopt_pet_no());
		return pstmt;
	}

	private AdoptPetVO selectOneAdoptPetByNo(ResultSet rs) {
		AdoptPetVO adoptPet = new AdoptPetVO();
		try {
			while (rs.next()) {
				adoptPet.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				adoptPet.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptPet.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				adoptPet.setAdopt_pet_breeds(rs.getString("ADOPT_PET_BREEDS"));
				adoptPet.setAdopt_pet_gender(rs.getString("ADOPT_PET_GENDER"));
				adoptPet.setAdopt_pet_come_form(rs.getString("ADOPT_PET_COME_FORM"));
				adoptPet.setAdopt_pet_join_date(rs.getDate("ADOPT_PET_JOIN_DATE"));
				adoptPet.setAdopt_pet_chip(rs.getString("ADOPT_PET_CHIP"));
				adoptPet.setAdopt_pet_join_reason(rs.getString("ADOPT_PET_JOIN_REASON"));
				adoptPet.setCapture_address(rs.getString("CAPTURE_ADDRESS"));
				adoptPet.setAdopt_pet_sterilization(rs.getString("ADOPT_PET_STERILIZATION"));
				adoptPet.setContain_number(rs.getString("CONTAIN_NUMBER"));
				adoptPet.setAdopt_pet_color(rs.getString("ADOPT_PET_COLOR"));
				adoptPet.setAdopt_pet_state(rs.getString("ADOPT_PET_STATE"));
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adoptPet;
	}

	private List<AdoptPetVO> selectAdoptPetByMebNo(List<AdoptPetVO> adoptPetList, ResultSet rs) {
		
		try {
			while (rs.next()) {
				AdoptPetVO adoptPet = new AdoptPetVO();
				adoptPet.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				adoptPet.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptPet.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				adoptPet.setAdopt_pet_breeds(rs.getString("ADOPT_PET_BREEDS"));
				adoptPet.setAdopt_pet_gender(rs.getString("ADOPT_PET_GENDER"));
				adoptPet.setAdopt_pet_come_form(rs.getString("ADOPT_PET_COME_FORM"));
				adoptPet.setAdopt_pet_join_date(rs.getDate("ADOPT_PET_JOIN_DATE"));
				adoptPet.setAdopt_pet_chip(rs.getString("ADOPT_PET_CHIP"));
				adoptPet.setAdopt_pet_join_reason(rs.getString("ADOPT_PET_JOIN_REASON"));
				adoptPet.setCapture_address(rs.getString("CAPTURE_ADDRESS"));
				adoptPet.setAdopt_pet_sterilization(rs.getString("ADOPT_PET_STERILIZATION"));
				adoptPet.setContain_number(rs.getString("CONTAIN_NUMBER"));
				adoptPet.setAdopt_pet_color(rs.getString("ADOPT_PET_COLOR"));
				adoptPet.setAdopt_pet_state(rs.getString("ADOPT_PET_STATE"));
				adoptPetList.add(adoptPet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptPetList;
	}
	
	
	
	
	
	
	
	
	
}
