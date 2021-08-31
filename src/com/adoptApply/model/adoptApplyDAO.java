package com.adoptApply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adoptApplyDAO implements adoptApplyDAO_interface {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO ADOPT_APPLY VALUES (?,?,?,?,?,?,?,?)";
	public static final String UPDATE_SQL ="UPDATE ADOPT_APPLY SET ADOPT_MEB_NO=?,GEN_MEB_NO=?,ADOPT_PET_NO=?,ADOPT_AUDIT_STATE=?,ADOPT_APPLY_PEOPLE_ID=?,ADOPT_APPLY_DATE=?,ADOPT_APPLY_STATE=? WHERE ADOPT_APPLY_NO=?";
	public static final String DELETE_SQL ="DELETE FROM ADOPT_APPLY WHERE ADOPT_APPLY_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM ADOPT_APPLY WHERE ADOPT_APPLY_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM ADOPT_APPLY";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(adoptApplyVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,amrVO.getAdopt_apply_no());
			pst.setInt(2,amrVO.getAdopt_meb_no());
			pst.setInt(3,amrVO.getGen_meb_no());
			pst.setInt(4,amrVO.getAdopt_pet_no());
			pst.setString(5,amrVO.getAdopt_audit_state());
			pst.setString(6,amrVO.getAdopt_apply_people_id());
			pst.setDate(7,amrVO.getAdopt_apply_date());
			pst.setString(8,amrVO.getAdopt_apply_state());
			pst.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		} finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch(SQLException se) {
					se.printStackTrace();
				}	
			}
			
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(adoptApplyVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			pst.setInt(1,amrVO.getAdopt_meb_no());
			pst.setInt(2,amrVO.getGen_meb_no());
			pst.setInt(3,amrVO.getAdopt_pet_no());
			pst.setString(4,amrVO.getAdopt_audit_state());
			pst.setString(5,amrVO.getAdopt_apply_people_id());
			pst.setDate(6,amrVO.getAdopt_apply_date());
			pst.setString(7,amrVO.getAdopt_apply_state());
			pst.setInt(8,amrVO.getAdopt_apply_no());
			pst.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		} finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch(SQLException se) {
					se.printStackTrace();
				}	
			}
			
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(Integer amrno) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1,amrno);
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}	
		}
	}

	@Override
	public adoptApplyVO findByPrimaryKey(Integer amrno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		adoptApplyVO amrVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,amrno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				amrVO = new adoptApplyVO();
				amrVO.setAdopt_apply_no(amrno);
				amrVO.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				amrVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				amrVO.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				amrVO.setAdopt_audit_state(rs.getString("ADOPT_AUDIT_STATE"));
				amrVO.setAdopt_apply_people_id(rs.getString("ADOPT_APPLY_PEOPLE_ID"));
				amrVO.setAdopt_apply_date(rs.getDate("ADOPT_APPLY_DATE"));
				amrVO.setAdopt_apply_state(rs.getString("ADOPT_APPLY_STATE"));
			}
			
		} catch(SQLException se) {
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
		
		return amrVO;
	}

	@Override
	public List<adoptApplyVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <adoptApplyVO> amrList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				adoptApplyVO amrVO = new adoptApplyVO();
				amrVO.setAdopt_apply_no(rs.getInt("ADOPT_APPLY_NO"));
				amrVO.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				amrVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				amrVO.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				amrVO.setAdopt_audit_state(rs.getString("ADOPT_AUDIT_STATE"));
				amrVO.setAdopt_apply_people_id(rs.getString("ADOPT_APPLY_PEOPLE_ID"));
				amrVO.setAdopt_apply_date(rs.getDate("ADOPT_APPLY_DATE"));
				amrVO.setAdopt_apply_state(rs.getString("ADOPT_APPLY_STATE"));
				amrList.add(amrVO);
			}
			
		} catch(SQLException se) {
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

		return amrList;
		
	}
}