package com.pay_method.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.logistics.model.logisticsDAO_interface;
import com.logistics.model.logisticsVO;

public class pay_methodDAO implements pay_methodDAO_interface{
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_STMT = "insert into PAY_METHOD(pay_no,pay_name) values (?,?)";
								
	
	
	private static final String UPDATE_STMT = "update PAY_METHOD set pay_name=? WHERE pay_no=?";
	private static final String DELETE_STMT = "delete from PAY_METHOD where pay_no=?";
	private static final String FIND_BY_PK = "select * from PAY_METHOD where pay_no=?";
	private static final String GET_ALL = "select * from pay_method";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}	
	
	
	@Override
	public void add(pay_methodVO pay_methodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
            
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);//新增
			int i=1;
			
			
			pstmt.setInt(i++, pay_methodVO.getPay_no());
			pstmt.setString(i++, pay_methodVO.getPay_name());
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
	public void update(pay_methodVO pay_methodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			pstmt.setString(i++, pay_methodVO.getPay_name());
			pstmt.setInt(i++, pay_methodVO.getPay_no());//WHERE 條件			                                             
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
	public void delete(Integer pay_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);//刪除
			pstmt.setInt(1, pay_no);			
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
	public pay_methodVO findPayMethodPk(Integer pay_no) {
		pay_methodVO pay_method = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
			pstmt.setInt(1, pay_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pay_method = new pay_methodVO();
				pay_method.setPay_no(rs.getInt("pay_no"));			
				pay_method.setPay_name(rs.getString("pay_name"));	
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

		return pay_method;		
	}

	@Override
	public List<pay_methodVO> getAllpay_method() {
		List<pay_methodVO> pay_methodList= new ArrayList<>();
		pay_methodVO pay_method = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				

		try {

			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pay_method = new pay_methodVO();
				pay_method.setPay_no(rs.getInt("pay_no"));
				pay_method.setPay_name(rs.getString("pay_name"));
				pay_methodList.add(pay_method);
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
		return pay_methodList;
			}
}
