package com.order_form.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.promotions.model.promotionsVO;

public class order_formDAO  implements order_formDAO_interface{

	private static final String INSERT_STMT = "insert into ORDER_FORM(gen_meb_no, pay_no, logistics_no, promot_no, befort_amount, order_amount, delivery_address, order_time, order_status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	gen_meb_no,
	private static final String UPDATE_STMT = "update ORDER_FORM set gen_meb_no=?, pay_no=?, logistics_no=?, promot_no=?, befort_amount=?, order_amount=?, delivery_address=?, order_time=?, order_status=? WHERE order_no =?";
//  gen_meb_no=?, 
	private static final String DELETE_STMT = "delete from ORDER_FORM where order_no=?";
	private static final String FIND_BY_PK = "select * from ORDER_FORM where order_no=?";
	private static final String GET_ALL = "select * from ORDER_FORM";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Util.DRIVER
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}	
	
	
	@Override
	public void add(order_formVO order_form) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {	                                                         
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
				pstmt = con.prepareStatement(INSERT_STMT);//新增
				int i=1;
				pstmt.setInt(i++, order_form.getGen_meb_no());
				pstmt.setInt(i++, order_form.getPay_no());
				pstmt.setInt(i++, order_form.getLogistics_no());
				pstmt.setInt(i++, order_form.getPromot_no());
				pstmt.setInt(i++, order_form.getBefort_amount());
				pstmt.setInt(i++, order_form.getOrder_amount());
				pstmt.setString(i++, order_form.getDelivery_address());
				pstmt.setDate(i++, order_form.getOrder_time());		
				pstmt.setString(i++, order_form.getOrder_status());
				pstmt.executeUpdate();//執行		
			
				// Handle any driver errors
			} catch (SQLException se) {
				se.printStackTrace();
				// Clean up JDBC resources
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
	public void update(order_formVO order_form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			pstmt.setInt(i++, order_form.getGen_meb_no());
			pstmt.setInt(i++, order_form.getPay_no());
			pstmt.setInt(i++, order_form.getLogistics_no());
			pstmt.setInt(i++, order_form.getPromot_no());
			pstmt.setInt(i++, order_form.getBefort_amount());
			pstmt.setInt(i++, order_form.getOrder_amount());
			pstmt.setString(i++, order_form.getDelivery_address());
			pstmt.setDate(i++, order_form.getOrder_time());
			pstmt.setString(i++, order_form.getOrder_status());
			pstmt.setInt(i++, order_form.getOrder_no());//WHERE 條件	
			pstmt.executeUpdate();//執行		
			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
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
	public void delete(Integer order_no) {
			Connection con = null;
			PreparedStatement pstmt = null;
		
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
				pstmt = con.prepareStatement(DELETE_STMT);//刪除
				pstmt.setInt(1, order_no);			
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
	public order_formVO findOrderFormPk(Integer order_no) {
		    order_formVO order_form = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
				pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
				pstmt.setInt(1, order_no);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					order_form = new order_formVO();
					order_form.setOrder_no(rs.getInt("order_no"));
					order_form.setGen_meb_no(rs.getInt("gen_meb_no"));
					order_form.setPay_no(rs.getInt("pay_no"));
					order_form.setLogistics_no(rs.getInt("logistics_no"));
					order_form.setPromot_no(rs.getInt("promot_no"));
					order_form.setBefort_amount(rs.getInt("befort_amount"));
					order_form.setOrder_amount(rs.getInt("order_amount"));
					order_form.setDelivery_address(rs.getString("delivery_address"));
					order_form.setOrder_time(rs.getDate("order_time"));
					order_form.setOrder_status(rs.getString("order_status"));	
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
			return order_form;
		}
		
		

	@Override
	public List<order_formVO> getAllorderForm() {
		List<order_formVO>order_formList = new ArrayList<>();
		order_formVO order_form = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei", "David", "123456");
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order_form = new order_formVO();
				order_form.setOrder_no(rs.getInt("order_no"));
				order_form.setGen_meb_no(rs.getInt("gen_meb_no"));
				order_form.setPay_no(rs.getInt("pay_no"));
				order_form.setLogistics_no(rs.getInt("logistics_no"));
				order_form.setPromot_no(rs.getInt("promot_no"));
				order_form.setBefort_amount(rs.getInt("befort_amount"));
				order_form.setOrder_amount(rs.getInt("order_amount"));
				order_form.setDelivery_address(rs.getString("delivery_address"));
				order_form.setOrder_time(rs.getDate("order_time"));
				order_form.setOrder_status(rs.getString("order_status"));	
				order_formList.add(order_form);
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
		return order_formList;
			}
}
