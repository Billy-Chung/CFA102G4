package com.productPhotos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productPhotosDAO implements productPhotosDAO_interface {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	public static final String INSERT_SQL ="INSERT INTO PRODUCT_PHOTOS VALUES (?,?,?)";
	public static final String UPDATE_SQL ="UPDATE PRODUCT_PHOTOS SET PRODUCT_NO=?,PRODUCT_PHOTO=? WHERE PRODUCT_PHOTO_NO=?";
	public static final String DELETE_SQL ="DELETE FROM PRODUCT_PHOTOS WHERE PRODUCT_PHOTO_NO=?";
	public static final String FIND_BY_DEPTNO_SQL = "SELECT * FROM PRODUCT_PHOTOS WHERE PRODUCT_PHOTO_NO = ?";
	public static final String GET_ALL_SQL = "SELECT * FROM PRODUCT_PHOTOS";
	
	static {
		try {
			Class.forName(DRIVER);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(productPhotosVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(INSERT_SQL);
			pst.setInt(1,amrVO.getProduct_photo_no());
			pst.setInt(2,amrVO.getProduct_no());
			pst.setBytes(3,amrVO.getProduct_photo());
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
	public void update(productPhotosVO amrVO) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			pst = conn.prepareStatement(UPDATE_SQL);
			
			pst.setInt(1,amrVO.getProduct_no());
			pst.setBytes(2,amrVO.getProduct_photo());
			pst.setInt(3,amrVO.getProduct_photo_no());
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
	public productPhotosVO findByPrimaryKey(Integer amrno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		productPhotosVO amrVO = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO_SQL);
			pstmt.setInt(1,amrno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				amrVO = new productPhotosVO();
				amrVO.setProduct_photo_no(amrno);
				amrVO.setProduct_no(rs.getInt("PRODUCT_NO"));
				amrVO.setProduct_photo(rs.getBytes("PRODUCT_PHOTO"));
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
	public List<productPhotosVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List <productPhotosVO> amrList = new ArrayList<>();
		
		try {
			
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				productPhotosVO amrVO = new productPhotosVO();
				amrVO.setProduct_photo_no(rs.getInt("PRODUCT_PHOTO_NO"));
				amrVO.setProduct_no(rs.getInt("PRODUCT_NO"));
				amrVO.setProduct_photo(rs.getBytes("PRODUCT_PHOTO"));
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
