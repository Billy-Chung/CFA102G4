package com.generalMember.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.generalMemberPet.model.GeneralMemberPetVO;

public class GeneralMemberDAO implements GeneralMemberDAO_Interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";

	public static final String INSERT_SQL = "INSERT INTO GENERAL_MEMBER VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_SQL = "UPDATE GENERAL_MEMBER SET MEB_NAME=?,MEB_PHONE=?,MEB_BIRTHDAY=?,MEB_PHOTO=?,MEB_COMMENT=?,MEB_ADDRESS=?,MEB_EMAIL=?,MEB_ACCOUNT=?,MEB_PASSWORD=?,MEB_GENDER=?,MEB_MONEY=?,POST_PERMISSION=? WHERE GEN_MEB_NO=?";
	public static final String DELETE_SQL = "DELETE FROM GENERAL_MEMBER WHERE GEN_MEB_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM GENERAL_MEMBER WHERE GEN_MEB_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM GENERAL_MEMBER";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(GeneralMemberVO gmVO) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1, gmVO.getGer_meb_no());
			pst.setString(2, gmVO.getMeb_name());
			pst.setString(3, gmVO.getPhone());
			pst.setDate(4, gmVO.getBirthday());
			pst.setBytes(5, gmVO.getPhoto());
			pst.setString(6, gmVO.getComment());
			pst.setString(7, gmVO.getAddress());
			pst.setString(8, gmVO.getEmail());
			pst.setString(9, gmVO.getAccount());
			pst.setString(10, gmVO.getPassword());
			pst.setString(11, gmVO.getGender());
			pst.setInt(12, gmVO.getMeb_money());
			pst.setString(13, gmVO.getPost_permission());

			pst.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(GeneralMemberVO gmVO) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			pst.setString(1, gmVO.getMeb_name());
			pst.setString(2, gmVO.getPhone());
			pst.setDate(3, gmVO.getBirthday());
			pst.setBytes(4, gmVO.getPhoto());
			pst.setString(5, gmVO.getComment());
			pst.setString(6, gmVO.getAddress());
			pst.setString(7, gmVO.getEmail());
			pst.setString(8, gmVO.getAccount());
			pst.setString(9, gmVO.getPassword());
			pst.setString(10, gmVO.getGender());
			pst.setInt(11, gmVO.getMeb_money());
			pst.setString(12, gmVO.getPost_permission());
			pst.setInt(13, gmVO.getGer_meb_no());

			pst.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(Integer gmno) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);

			pstmt.setInt(1, gmno);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public GeneralMemberVO findByPrimaryKey(Integer gmno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GeneralMemberVO gmVO = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1, gmno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				gmVO = new GeneralMemberVO();
				gmVO.setGer_meb_no(gmno);
				gmVO.setMeb_name(rs.getString("MEB_NAME"));
				gmVO.setPhone(rs.getString("MEB_PHONE"));
				gmVO.setBirthday(rs.getDate("MEB_BIRTHDAY"));
				gmVO.setPhoto(rs.getBytes("MEB_PHOTO"));
				gmVO.setComment(rs.getString("MEB_COMMENT"));
				gmVO.setAddress(rs.getString("MEB_ADDRESS"));
				gmVO.setEmail(rs.getString("MEB_EMAIL"));
				gmVO.setAccount(rs.getString("MEB_ACCOUNT"));
				gmVO.setPassword(rs.getString("MEB_PASSWORD"));
				gmVO.setGender(rs.getString("MEB_GENDER"));
				gmVO.setMeb_money(rs.getInt("MEB_MONEY"));
				gmVO.setPost_permission(rs.getString("POST_PERMISSION"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

		}

		return gmVO;
	}



	public List<GeneralMemberVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GeneralMemberVO> gmList = new ArrayList<>();

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				GeneralMemberVO gmVO = new GeneralMemberVO();
				gmVO.setGer_meb_no(rs.getInt("GEN_MEB_NO"));
				gmVO.setMeb_name(rs.getString("MEB_NAME"));
				gmVO.setPhone(rs.getString("MEB_PHONE"));
				gmVO.setBirthday(rs.getDate("MEB_BIRTHDAY"));
				gmVO.setPhoto(rs.getBytes("MEB_PHOTO"));
				gmVO.setComment(rs.getString("MEB_COMMENT"));
				gmVO.setAddress(rs.getString("MEB_ADDRESS"));
				gmVO.setEmail(rs.getString("MEB_EMAIL"));
				gmVO.setAccount(rs.getString("MEB_ACCOUNT"));
				gmVO.setPassword(rs.getString("MEB_PASSWORD"));
				gmVO.setGender(rs.getString("MEB_GENDER"));
				gmVO.setMeb_money(rs.getInt("MEB_MONEY"));
				gmVO.setPost_permission(rs.getString("POST_PERMISSION"));
				// 用集合收集著包裝好的部門物件,查詢多筆的時候很適合
				gmList.add(gmVO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

		}

		return gmList;

	}

}
