package com.logistics.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class logisticsDAO implements logisticsDAO_interface{
//		public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//		public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
//		public static final String USER = "David";
//		public static final String PASSWORD = "123456";
				
		private static final String INSERT_STMT = "insert into logistics(logistics_name) values (?)";
		private static final String UPDATE_STMT = "update logistics set logistics_name=? WHERE logistics_no";
		private static final String DELETE_STMT = "delete from logistics where logistics_no=?";
		private static final String FIND_BY_PK = "select * from logistics where logistics_no=?";
		private static final String GET_ALL = "select * from logistics";

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer LOGISTICS_NO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public logisticsVO findByLogisticsPk(Integer LOGISTICS_NO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<logisticsVO> getAllLogistics() {
		// TODO Auto-generated method stub
		return null;
	}
}
