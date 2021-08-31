package com.logistics.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.promotions.model.promotionsVO;

public class logisticsDAO implements logisticsDAO_interface{
//	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
//	public static final String USER = "David";
//	public static final String PASSWORD = "123456";
			
	
	
		private static final String INSERT_STMT = "insert into LOGISTICS(logistics_no,logistics_name) values (?,?)";
		private static final String UPDATE_STMT = "update LOGISTICS set logistics_name=? WHERE logistics_no=?";
		private static final String DELETE_STMT = "delete from LOGISTICS where logistics_no=?";
		private static final String FIND_BY_PK = "select * from LOGISTICS where logistics_no=?";
		private static final String GET_ALL = "select * from LOGISTICS";

		static {
			try {
//				Class.forName("DRIVER");
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			}
		}	
		
		
	@Override
	public void add(logisticsVO logistics) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
                                                                                                    
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(INSERT_STMT);//新增
			int i=1;
			
			pstmt.setInt(i++, logistics.getLogistics_no());
			pstmt.setString(i++, logistics.getLogistics_name());
			pstmt.executeUpdate();//執行		
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(logisticsVO logistics) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			pstmt.setString(i++, logistics.getLogistics_name());
			pstmt.setInt(i++, logistics.getLogistics_no());//WHERE 條件			                                             
			pstmt.executeUpdate();//執行		
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}	  
		

	@Override
	public void delete(Integer logistics_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(DELETE_STMT);//刪除
			pstmt.setInt(1, logistics_no);			
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public logisticsVO findByLogisticsPk(Integer logistics_no) {
		logisticsVO logistics = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			con = DriverManager.getConnection("URL,USER,PASSWORD");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
			pstmt.setInt(1, logistics_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				logistics = new logisticsVO();
				logistics.setLogistics_no(rs.getInt("logistics_no"));			
				logistics.setLogistics_name(rs.getString("logistics_name"));	
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return logistics;
	}	

	@Override
	public List<logisticsVO> getAllLogistics() {
			List<logisticsVO> logisticsList= new ArrayList<>();
			logisticsVO logistics = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;				

			try {

//				con = DriverManager.getConnection("URL,USER,PASSWORD");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					logistics = new logisticsVO();
					logistics.setLogistics_no(rs.getInt("logistics_no"));			
					logistics.setLogistics_name(rs.getString("logistics_name"));						
					logisticsList.add(logistics);
				}


			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return logisticsList;
				}
}
