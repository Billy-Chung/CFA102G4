package com.generalMemberPet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class GeneralMemberPetDAO implements GeneralMemberPetDAO_Interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO GENERAL_MEMBER_PET VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_SQL ="UPDATE GENERAL_MEMBER_PET SET ADOPT_PET_NO=?,PET_CLASS_NO=?,GEN_MEB_NO=?,GEN_MEB_PET_BREEDS=?,GEN_MEB_PET_GENDER=?,GEN_MEB_PET_CHIP=?,GEN_MEB_PET_STERILIZATION=?,GEN_MEB_PET_COLOR=?,GEN_PET_COMMENT=?,GEN_PET_STATE=? WHERE GEN_MEB_PET_NO=?";
	public static final String DELETE_SQL ="DELETE FROM GENERAL_MEMBER_PET WHERE GEN_MEB_PET_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM GENERAL_MEMBER_PET WHERE GEN_MEB_PET_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM GENERAL_MEMBER_PET";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(GeneralMemberPetVO gmpVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,gmpVO.getGen_meb_pet_no());
			pst.setInt(2,gmpVO.getAdopt_pet_no());
			pst.setInt(3,gmpVO.getPet_class_no());
			pst.setInt(4,gmpVO.getGen_meb_no());
			pst.setString(5,gmpVO.getGen_meb_pet_breeds());
			pst.setString(6, gmpVO.getGen_meb_pet_gender());
			pst.setString(7,gmpVO.getGen_meb_pet_chip());
			pst.setString(8, gmpVO.getGen_meb_pet_sterilization());
			pst.setString(9, gmpVO.getGen_pet_color());
			pst.setString(10, gmpVO.getGen_pet_comment());
			pst.setString(11, gmpVO.getGen_pet_state());
			
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
	public void update(GeneralMemberPetVO gmpVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			
			
			pst.setInt(1,gmpVO.getAdopt_pet_no());
			pst.setInt(2,gmpVO.getPet_class_no());
			pst.setInt(3,gmpVO.getGen_meb_no());
			pst.setString(4,gmpVO.getGen_meb_pet_breeds());
			pst.setString(5, gmpVO.getGen_meb_pet_gender());
			pst.setString(6,gmpVO.getGen_meb_pet_chip());
			pst.setString(7, gmpVO.getGen_meb_pet_sterilization());
			pst.setString(8, gmpVO.getGen_pet_color());
			pst.setString(9, gmpVO.getGen_pet_comment());
			pst.setString(10, gmpVO.getGen_pet_state());
			pst.setInt(11,gmpVO.getGen_meb_pet_no());
			
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
	public void delete(Integer gmpno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1,gmpno);
			
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
	public GeneralMemberPetVO findByPrimaryKey(Integer gmpno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GeneralMemberPetVO gmpVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,gmpno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				gmpVO = new GeneralMemberPetVO();
				gmpVO.setGen_meb_pet_no(gmpno);
				gmpVO.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				gmpVO.setPet_class_no(rs.getInt("PET_CLASS_NO"));
				gmpVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				gmpVO.setGen_meb_pet_breeds(rs.getString("GEN_MEB_PET_BREEDS"));
				gmpVO.setGen_meb_pet_gender(rs.getString("GEN_MEB_PET_GENDER"));
				gmpVO.setGen_meb_pet_chip(rs.getString("GEN_MEB_PET_CHIP"));
				gmpVO.setGen_meb_pet_sterilization(rs.getString("GEN_MEB_PET_STERILIZATION"));
				gmpVO.setGen_pet_color(rs.getString("GEN_MEB_PET_COLOR"));
				gmpVO.setGen_pet_comment(rs.getString("GEN_PET_COMMENT"));
				gmpVO.setGen_pet_state(rs.getString("GEN_PET_STATE"));
				
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
		
		return gmpVO;
	}

	@Override
	public List<GeneralMemberPetVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <GeneralMemberPetVO> gmpList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				GeneralMemberPetVO gmpVO = new GeneralMemberPetVO();
				gmpVO.setGen_meb_pet_no(rs.getInt("GEN_MEB_PET_NO"));
				gmpVO.setAdopt_pet_no(rs.getInt("ADOPT_PET_NO"));
				gmpVO.setPet_class_no(rs.getInt("PET_CLASS_NO"));
				gmpVO.setGen_meb_no(rs.getInt("GEN_MEB_NO"));
				gmpVO.setGen_meb_pet_breeds(rs.getString("GEN_MEB_PET_BREEDS"));
				gmpVO.setGen_meb_pet_gender(rs.getString("GEN_MEB_PET_GENDER"));
				gmpVO.setGen_meb_pet_chip(rs.getString("GEN_MEB_PET_CHIP"));
				gmpVO.setGen_meb_pet_sterilization(rs.getString("GEN_MEB_PET_STERILIZATION"));
				gmpVO.setGen_pet_color(rs.getString("GEN_MEB_PET_COLOR"));
				gmpVO.setGen_pet_comment(rs.getString("GEN_PET_COMMENT"));
				gmpVO.setGen_pet_state(rs.getString("GEN_PET_STATE"));
			//用集合收集著包裝好的部門物件,查詢多筆的時候很適合
				gmpList.add(gmpVO);
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
		
		
		return gmpList;
	
	}
	
}
