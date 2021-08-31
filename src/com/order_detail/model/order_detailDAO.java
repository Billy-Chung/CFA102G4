package com.order_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pay_method.model.pay_methodVO;

public class order_detailDAO implements order_detailDAO_interface{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_STMT = "insert into ORDER_DETAIL(order_no,product_no,order_product_number,order_product_comment,order_product_stars,order_product_comment_state) values (?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "update ORDER_DETAIL set order_no=?,product_no=?,order_product_number=?,order_product_comment=?,order_product_stars=?,order_product_comment_state=? WHERE order_detail_no=?";
	private static final String DELETE_STMT = "delete from ORDER_DETAIL where order_detail_no=?";
	private static final String FIND_BY_PK = "select * from ORDER_DETAIL where order_detail_no=?";
	private static final String GET_ALL = "select * from ORDER_DETAIL";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}	
	
	@Override
	public void add(order_detailVO order_detailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
            
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);//新增
			int i=1;
			pstmt.setInt(i++, order_detailVO.getOrder_no());
			pstmt.setInt(i++, order_detailVO.getProduct_no());
			pstmt.setInt(i++, order_detailVO.getOrder_product_number());
			pstmt.setString(i++, order_detailVO.getOrder_product_comment());
			pstmt.setInt(i++, order_detailVO.getOrder_product_stars());
			pstmt.setString(i++, order_detailVO.getOrder_product_comment_state());
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
	public void update(order_detailVO order_detailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);//修改

			int i=1;
			pstmt.setInt(i++, order_detailVO.getOrder_no());
			pstmt.setInt(i++, order_detailVO.getProduct_no());
			pstmt.setInt(i++, order_detailVO.getOrder_product_number());
			pstmt.setString(i++, order_detailVO.getOrder_product_comment());
			pstmt.setInt(i++, order_detailVO.getOrder_product_stars());
			pstmt.setString(i++, order_detailVO.getOrder_product_comment_state());
			pstmt.setInt(i++, order_detailVO.getOrder_detail_no());//WHERE 條件			                                             
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
	public void delete(Integer order_detail_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);//刪除
			pstmt.setInt(1, order_detail_no);			
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
	public order_detailVO findOrderDetailPk(Integer order_detail_no) {
		order_detailVO order_detail = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);//主鍵
			pstmt.setInt(1, order_detail_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order_detail = new order_detailVO();
				order_detail.setOrder_detail_no(rs.getInt("order_detail_no"));
				order_detail.setOrder_no(rs.getInt("order_no"));
				order_detail.setProduct_no(rs.getInt("product_no"));
				order_detail.setOrder_product_number(rs.getInt("order_product_number"));
				order_detail.setOrder_product_comment(rs.getString("order_product_comment"));
				order_detail.setOrder_product_stars(rs.getInt("order_product_stars"));
				order_detail.setOrder_product_comment_state(rs.getString("order_product_comment_state"));	
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

		return order_detail;		
	}

	@Override
	public List<order_detailVO> getAllorder_detail() {
		List<order_detailVO> order_detailList= new ArrayList<>();
		order_detailVO order_detail = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				

		try {

			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				order_detail = new order_detailVO();
				order_detail.setOrder_detail_no(rs.getInt("order_detail_no"));
				order_detail.setOrder_no(rs.getInt("order_no"));
				order_detail.setProduct_no(rs.getInt("product_no"));
				order_detail.setOrder_product_number(rs.getInt("order_product_number"));
				order_detail.setOrder_product_comment(rs.getString("order_product_comment"));
				order_detail.setOrder_product_stars(rs.getInt("order_product_stars"));
				order_detail.setOrder_product_comment_state(rs.getString("order_product_comment_state"));
				order_detailList.add(order_detail);
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
		return order_detailList;
			}
}
