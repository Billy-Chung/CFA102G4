package com.adoptMemberReport.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdoptMemberReportDAO implements AdoptMemberReportDAO_Interface  {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO ADOPT_MEMBER_REPORT VALUES (?, ?, ?,?,?,?)";
	public static final String UPDATE_SQL ="UPDATE ADOPT_MEMBER_REPORT SET ADOPT_MEB_NO=?,GEN_MEB_NO=?,EPORT_COMMENT=?,ADOPT_MEB_REPORT_STATE=?,ADOPT_MEB_REPORT_DATE=? WHERE ADOPT_MEB_REPORT_NO=?";
	public static final String DELETE_SQL ="DELETE FROM ADOPT_MEMBER_REPORT WHERE ADOPT_MEB_REPORT_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM ADOPT_MEMBER_REPORT WHERE ADOPT_MEB_REPORT_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM ADOPT_MEMBER_REPORT";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(AdoptMemberReportVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,amrVO.getAdopt_meb_report_no());
			pst.setInt(2,amrVO.getAdopt_meb_no());
			pst.setInt(3,amrVO.getGen_meb_no());
			pst.setString(4,amrVO.getEport_comment());
			pst.setString(5,amrVO.getAdopt_meb_report_state());
			pst.setDate(6,amrVO.getAdopt_meb_report_date());
			
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
	public void update(AdoptMemberReportVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			
			pst.setInt(1,amrVO.getAdopt_meb_no());
			pst.setInt(2,amrVO.getGen_meb_no());
			pst.setString(3,amrVO.getEport_comment());
			pst.setString(4,amrVO.getAdopt_meb_report_state());
			pst.setDate(5,amrVO.getAdopt_meb_report_date());
			pst.setInt(6,amrVO.getAdopt_meb_report_no());
			
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
	public AdoptMemberReportVO findByPrimaryKey(Integer amrno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdoptMemberReportVO amrVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,amrno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				amrVO = new AdoptMemberReportVO();
				amrVO.setAdopt_meb_report_no(amrno);
				amrVO.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				amrVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				amrVO.setEport_comment(rs.getString("EPORT_COMMENT"));
				amrVO.setAdopt_meb_report_state(rs.getString("ADOPT_MEB_REPORT_STATE"));
				amrVO.setAdopt_meb_report_date(rs.getDate("ADOPT_MEB_REPORT_DATE"));
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
	public List<AdoptMemberReportVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <AdoptMemberReportVO> amrList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				AdoptMemberReportVO amrVO = new AdoptMemberReportVO();
				amrVO.setAdopt_meb_report_no(rs.getInt("ADOPT_MEB_REPORT_NO"));
				amrVO.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				amrVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				amrVO.setEport_comment(rs.getString("EPORT_COMMENT"));
				amrVO.setAdopt_meb_report_state(rs.getString("ADOPT_MEB_REPORT_STATE"));
				amrVO.setAdopt_meb_report_date(rs.getDate("ADOPT_MEB_REPORT_DATE"));
			//用集合收集著包裝好的部門物件,查詢多筆的時候很適合
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
