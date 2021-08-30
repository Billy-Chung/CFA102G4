package com.followPet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class FollowPetDAO implements FollowPetDAO_Interface {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO FOLLOW_PET VALUES (?, ?)";
	public static final String UPDATE_SQL ="UPDATE FOLLOW_PET SET ADOPT_PET_NO=? WHERE GEN_MEB_NO=?";
	public static final String DELETE_SQL ="DELETE FROM FOLLOW_PET WHERE GEN_MEB_NO=? and ADOPT_PET_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM FOLLOW_PET WHERE GEN_MEB_NO = ? and ADOPT_PET_NO=? ";
	public static final String GET_ALL_SQL = "SELECT * FROM FOLLOW_PET";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void insert(FollowPetVO fpVO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,fpVO.getGen_meb_no());
			pst.setInt(2,fpVO.getAdopt_pet_no());
			
			
			
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
	public void update(FollowPetVO fpVO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			
			pst.setInt(1,fpVO.getAdopt_pet_no());
			pst.setInt(2,fpVO.getGen_meb_no());
			
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
	public void delete(Integer gmno,Integer apno) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1,gmno);
			pstmt.setInt(2,apno);
			
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
	public FollowPetVO findByPrimaryKey(Integer gmno, Integer apno) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FollowPetVO fpVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,gmno);
			pstmt.setInt(2,apno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				fpVO = new FollowPetVO();
				fpVO.setGen_meb_no(gmno);
				fpVO.setAdopt_pet_no(rs.getInt("ADOPT_MEB_NO"));
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
		
		return fpVO;
	}

	@Override
	public List<FollowPetVO> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <FollowPetVO> fpList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				FollowPetVO fpVO = new FollowPetVO();
				fpVO.setGen_meb_no(rs.getInt("Gen_Meb_No"));
				fpVO.setAdopt_pet_no(rs.getInt("Adopt_Pet_No"));
				
			//用集合收集著包裝好的部門物件,查詢多筆的時候很適合
				fpList.add(fpVO);
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
		
		
		return fpList;
	
	}
	
}
