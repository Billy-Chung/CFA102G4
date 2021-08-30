package com.generalMemberPetPhotos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class GeneralMemberPetPhotosDAO implements GeneralMemberPetPhotosDAO_Interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO GENERAL_MEMBER_PET_PHOTOS VALUES (?, ?, ?)";
	public static final String UPDATE_SQL ="UPDATE GENERAL_MEMBER_PET_PHOTOS SET GEN_MEB_NO=?,GEN_MEB_PET_PHOTO=? WHERE GEN_MEB_PET_PHOTO_NO=?";
	public static final String DELETE_SQL ="DELETE FROM GENERAL_MEMBER_PET_PHOTOS WHERE GEN_MEB_PET_PHOTO_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM GENERAL_MEMBER_PET_PHOTOS WHERE GEN_MEB_PET_PHOTO_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM GENERAL_MEMBER_PET_PHOTOS";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(GeneralMemberPetPhotosVO gmppVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,gmppVO.getGen_meb_photo_no());
			pst.setInt(2,gmppVO.getGen_meb_no());
			pst.setBytes(3,gmppVO.getGen_meb_pet_photo());
			
			
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
	public void update(GeneralMemberPetPhotosVO gmppVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			
			pst.setInt(1,gmppVO.getGen_meb_no());
			pst.setBytes(2,gmppVO.getGen_meb_pet_photo());
			pst.setInt(3,gmppVO.getGen_meb_photo_no());
			
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
	public void delete(Integer gmppno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1,gmppno);
			
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
	public GeneralMemberPetPhotosVO findByPrimaryKey(Integer gmpno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GeneralMemberPetPhotosVO gmppVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,gmpno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				gmppVO = new GeneralMemberPetPhotosVO();
				gmppVO.setGen_meb_photo_no(gmpno);
				gmppVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				gmppVO.setGen_meb_pet_photo(rs.getBytes("GEN_MEB_PET_PHOTO"));
				
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
		
		return gmppVO;
	}

	@Override
	public List<GeneralMemberPetPhotosVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <GeneralMemberPetPhotosVO> gmppList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				GeneralMemberPetPhotosVO gmppVO = new GeneralMemberPetPhotosVO();
				gmppVO.setGen_meb_photo_no(rs.getInt("GEN_MEB_PET_PHOTO_NO"));
				gmppVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				gmppVO.setGen_meb_pet_photo(rs.getBytes("GEN_MEB_PET_PHOTO"));
				
				gmppList.add(gmppVO);
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
		
		
		return gmppList;
	}
	
}
