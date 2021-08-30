package com.storedValRecord.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMemberReport.model.AdoptMemberReportVO;

public class StoredValRecodeDAO implements StoredValRecodeDAO_Interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO STORED_VAL_RECORD VALUES (?, ?, ?,?)";
	public static final String UPDATE_SQL ="UPDATE STORED_VAL_RECORD SET GEN_MEB_NO=?,STORED_VAL_DATE=?,STORED_VAL_AMOUNT=? WHERE STORED_VAL_RECORD_NO=?";
	public static final String DELETE_SQL ="DELETE FROM STORED_VAL_RECORD WHERE STORED_VAL_RECORD_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM STORED_VAL_RECORD WHERE STORED_VAL_RECORD_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM STORED_VAL_RECORD";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(StoredValRecodeVO svrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,svrVO.getStored_val_recode_no());
			pst.setInt(2,svrVO.getGer_meb_no());
			pst.setDate(3,svrVO.getStored_val_date());
			pst.setInt(4,svrVO.getStored_val_amout());
			
			
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
	public void update(StoredValRecodeVO svrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			pst.setInt(1,svrVO.getGer_meb_no());
			pst.setDate(2,svrVO.getStored_val_date());
			pst.setInt(3,svrVO.getStored_val_amout());
			pst.setInt(4,svrVO.getStored_val_recode_no());
			
			
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
	public void delete(Integer svrno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1,svrno);
			
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
	public StoredValRecodeVO findByPrimaryKey(Integer svrno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StoredValRecodeVO svrVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,svrno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				svrVO = new StoredValRecodeVO();
				svrVO.setStored_val_recode_no(svrno);
				svrVO.setGer_meb_no(rs.getInt("GEN_MEB_NO"));
				svrVO.setStored_val_date(rs.getDate("STORED_VAL_DATE"));
				svrVO.setStored_val_amout(rs.getInt("STORED_VAL_AMOUNT"));
				
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
		
		return svrVO;
	}

	@Override
	public List<StoredValRecodeVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <StoredValRecodeVO> svrList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			//進來代表有查到資料,就用一個Dept的Bean來包裝著查詢出來的部門資料
				StoredValRecodeVO svrVO = new StoredValRecodeVO();
				svrVO.setStored_val_recode_no(rs.getInt("STORED_VAL_RECORD_NO"));
				svrVO.setGer_meb_no(rs.getInt("GEN_MEB_NO"));
				svrVO.setStored_val_date(rs.getDate("STORED_VAL_DATE"));
				svrVO.setStored_val_amout(rs.getInt("STORED_VAL_AMOUNT"));
				
			//用集合收集著包裝好的部門物件,查詢多筆的時候很適合
				svrList.add(svrVO);
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
		
		
		return svrList;
	}
	
}
