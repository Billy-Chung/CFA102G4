package com.reservePet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptPet.model.AdoptPetVO;
import com.petClassList.model.PetClassListDAO;
import com.petClassList.model.PetClassListVO;
import com.petClassList.model.PetClassList_interface;

public class ReservePetDAO implements ReservePet_interface {

	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into RESERVE_PET (ADOPT_MEB_NO,GEN_MEB_NO,ADOPT_PET_NO,RESERVE_PEOPLE_NAME,RESERVE_PEOPLE_PHONE,RESERVE_DATE,RESERVE_TIME,RESERVE_STATE) values(?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "update RESERVE_PET set RESERVE_PEOPLE_NAME = ?, RESERVE_PEOPLE_PHONE = ?, RESERVE_DATE = ?, RESERVE_TIME = ?, RESERVE_STATE = ? where RESERVE_PET_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM RESERVE_PET WHERE RESERVE_PET_NO = ?";
	private static final String FIND_BY_ADOPT_MEB_NO = "SELECT * FROM RESERVE_PET WHERE ADOPT_MEB_NO = ?";
	private static final String FIND_BY_GEN_MEB_NO = "SELECT * FROM RESERVE_PET WHERE GEN_MEB_NO = ?";
	private static final String FIND_BY_ADOPT_PET_NO = "SELECT * FROM RESERVE_PET WHERE ADOPT_PET_NO = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public ReservePetVO insert(ReservePetVO reservePet) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "RESERVE_PET_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, reservePet, INSERT_SQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				reservePet.setReserve_pet_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return reservePet;
	}

	@Override
	public void update(ReservePetVO reservePet) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, reservePet, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public ReservePetVO findByReservePetPK(Integer reserve_pet_no) {
		ReservePetVO reservePet = null;
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, reserve_pet_no);
			ResultSet rs = pstmt.executeQuery();
			reservePet = selectOneReservePetByPK(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return reservePet;
	}

	@Override
	public List<ReservePetVO> findByAdoptMebNo(Integer adopt_meb_no) {
		List<ReservePetVO> reservePetList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_ADOPT_MEB_NO);
			pstmt.setInt(1, adopt_meb_no);
			ResultSet rs = pstmt.executeQuery();
			reservePetList = selectReservePetByFk(reservePetList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return reservePetList;
	}

	@Override
	public List<ReservePetVO> findByGenMebNo(Integer gen_meb_no) {
		List<ReservePetVO> reservePetList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_GEN_MEB_NO);
			pstmt.setInt(1, gen_meb_no);
			ResultSet rs = pstmt.executeQuery();
			reservePetList = selectReservePetByFk(reservePetList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return reservePetList;
	}

	@Override
	public List<ReservePetVO> findByAdoptPetNo(Integer adopt_pet_no) {
		List<ReservePetVO> reservePetList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_ADOPT_PET_NO);
			pstmt.setInt(1, adopt_pet_no);
			ResultSet rs = pstmt.executeQuery();
			reservePetList = selectReservePetByFk(reservePetList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return reservePetList;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, ReservePetVO reservePet, String SQL,
			String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);

		pstmt.setInt(1, reservePet.getAdopt_meb_no());
		pstmt.setInt(2, reservePet.getGen_meb_no());
		pstmt.setInt(3, reservePet.getAdopt_pet_no());
		pstmt.setString(4, reservePet.getReserve_people_name());
		pstmt.setString(5, reservePet.getReserve_people_phone());
		pstmt.setDate(6, reservePet.getReserve_date());
		pstmt.setString(7, reservePet.getReserve_time());
		pstmt.setString(8, reservePet.getReserve_state());
		return pstmt;

	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, ReservePetVO reservePet, String SQL)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, reservePet.getReserve_people_name());
		pstmt.setString(2, reservePet.getReserve_people_phone());
		pstmt.setDate(3, reservePet.getReserve_date());
		pstmt.setString(4, reservePet.getReserve_time());
		pstmt.setString(5, reservePet.getReserve_state());
		pstmt.setInt(6, reservePet.getReserve_pet_no());
		return pstmt;
	}

	private ReservePetVO selectOneReservePetByPK(ResultSet rs) {
		ReservePetVO reservePet = new ReservePetVO();
		try {
			while (rs.next()) {
				reservePet.setReserve_pet_no(rs.getInt("RESERVE_PET_NO"));
				reservePet.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				reservePet.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				reservePet.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				reservePet.setReserve_people_name(rs.getString("RESERVE_PEOPLE_NAME"));
				reservePet.setReserve_people_phone(rs.getString("RESERVE_PEOPLE_PHONE"));
				reservePet.setReserve_date(rs.getDate("RESERVE_DATE"));
				reservePet.setReserve_time(rs.getString("RESERVE_TIME"));
				reservePet.setReserve_state(rs.getString("RESERVE_STATE"));
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return reservePet;
	}

	private List<ReservePetVO> selectReservePetByFk(List<ReservePetVO> reservePetList, ResultSet rs) {
		try {
			while (rs.next()) {
				ReservePetVO reservePet = new ReservePetVO();
				reservePet.setReserve_pet_no(rs.getInt("RESERVE_PET_NO"));
				reservePet.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				reservePet.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				reservePet.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				reservePet.setReserve_people_name(rs.getString("RESERVE_PEOPLE_NAME"));
				reservePet.setReserve_people_phone(rs.getString("RESERVE_PEOPLE_PHONE"));
				reservePet.setReserve_date(rs.getDate("RESERVE_DATE"));
				reservePet.setReserve_time(rs.getString("RESERVE_TIME"));
				reservePet.setReserve_state(rs.getString("RESERVE_STATE"));								
				reservePetList.add(reservePet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservePetList;
	}

}
