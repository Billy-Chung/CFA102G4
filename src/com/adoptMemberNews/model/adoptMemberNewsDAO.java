package com.adoptMemberNews.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adoptMember.model.adoptMemberVO;

public class adoptMemberNewsDAO implements adoptMemberNews_interface {
	private static final String SQLURL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQLUSER = "David";
	private static final String SQLPASSWORD = "123456";
	private static final String insertSQL = "insert into ADOPT_MEMBER_NEWS (ADOPT_MEB_NO,ADOPT_MEB_NEWS_TITLE,ADOPT_MEB_NEWS_COMMENT,ADOPT_MEB_NEWS_PHOTO,ADOPT_MEB_NEWS_STATE,ADOPT_MEB_NEWS_DATE) values(?,?,?,?,?,?)";
	private static final String updateSQL = "update ADOPT_MEMBER_NEWS set ADOPT_MEB_NEWS_TITLE = ?, ADOPT_MEB_NEWS_COMMENT = ?, ADOPT_MEB_NEWS_PHOTO = ?, ADOPT_MEB_NEWS_STATE = ?, ADOPT_MEB_NEWS_DATE = ? where ADOPT_MEB_NEWS_NO = ?";
	private static final String findByPK = "SELECT * FROM ADOPT_MEMBER_NEWS WHERE ADOPT_MEB_NEWS_NO = ?";
	private static final String findByName = "SELECT * FROM ADOPT_MEMBER_NEWS WHERE ADOPT_MEB_NEWS_TITLE like ?";
	private static final String selectAll = "SELECT * FROM ADOPT_MEMBER_NEWS";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public adoptMemberNewsVo insert(adoptMemberNewsVo adoptMemberNews) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "ADOPT_MEB_NEWS_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptMemberNews, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptMemberNews.setADOPT_MEB_NO(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNews;
	}

	@Override
	public void update(adoptMemberNewsVo adoptMemberNews) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptMemberNews, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	@Override
	public adoptMemberNewsVo findByadoptMemberNewsNoPK(Integer ADOPT_MEB_NEWS_NO) {
		adoptMemberNewsVo adoptMemberNews = null;

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByPK);
			pstmt.setInt(1, ADOPT_MEB_NEWS_NO);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNews = selectOneadoptMemberNewsByNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNews;
	}

	@Override
	public List<adoptMemberNewsVo> findByAdoptMebNewsTitle(String ADOPT_MEB_NEWS_TITLE) {
		List<adoptMemberNewsVo> adoptMemberNewsList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByName);
			pstmt.setString(1, "%" + ADOPT_MEB_NEWS_TITLE + "%");
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNewsList = selectAdoptMebNewsByTitle(adoptMemberNewsList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNewsList;
	}

	@Override
	public List<adoptMemberNewsVo> getAlladoptMemberNews() {
		List<adoptMemberNewsVo> adoptMemberNewsList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNewsList = selectAllAdoptMemberNews(adoptMemberNewsList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNewsList;
	}

	public static void main(String[] args) {
		adoptMemberNews_interface dao = new adoptMemberNewsDAO();
		adoptMemberNewsVo adoptMemberNewsVo = new adoptMemberNewsVo();

//		test insert
//		adoptMemberNewsVo.setADOPT_MEB_NO(1);
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_TITLE("我是Amos最新消息的標題");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			adoptMemberNewsVo.setADOPT_MEB_NEWS_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_COMMENT("我是Amos最新消息的內容");
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_STATE("1");
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_DATE(java.sql.Date.valueOf("2016-08-07"));
//		adoptMemberNewsVo adoptMember =  dao.insert(adoptMemberNewsVo);
//		System.out.println(adoptMember.getADOPT_MEB_NO());

//		test update
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_TITLE("更新最新消息標題");					
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_COMMENT("更新最新消息內容");		
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			adoptMemberNewsVo.setADOPT_MEB_NEWS_PHOTO(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}	
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_STATE("0");
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_DATE(java.sql.Date.valueOf("2021-08-25"));		
//		adoptMemberNewsVo.setADOPT_MEB_NEWS_NO(2);
//		dao.update(adoptMemberNewsVo);

//		test find by PK
//		adoptMemberNewsVo adoptMemberNews = dao.findByadoptMemberNewsNoPK(1);				
//		System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_NO() + ",");
//		System.out.print(adoptMemberNews.getADOPT_MEB_NO() + ",");
//		System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_TITLE() + ",");
//		System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_PHOTO() + ",");
//		System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_STATE() + ",");
//		System.out.println(adoptMemberNews.getADOPT_MEB_NEWS_DATE() + ",");		
//		System.out.println("---------------------");

//		test find by news title

//		List<adoptMemberNewsVo> adoptMemberNewsList = dao.findByAdoptMebNewsTitle("更");	
//		for (adoptMemberNewsVo adoptMemberNews : adoptMemberNewsList) {			
//			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_NO() + ",");
//			System.out.print(adoptMemberNews.getADOPT_MEB_NO() + ",");
//			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_TITLE() + ",");
//			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_PHOTO() + ",");
//			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_STATE() + ",");
//			System.out.println(adoptMemberNews.getADOPT_MEB_NEWS_DATE() + ",");		
//			System.out.println("---------------------");
//		}

//		test select all news
		List<adoptMemberNewsVo> adoptMemberList = dao.getAlladoptMemberNews();
		for (adoptMemberNewsVo adoptMemberNews : adoptMemberList) {
			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_NO() + ",");
			System.out.print(adoptMemberNews.getADOPT_MEB_NO() + ",");
			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_TITLE() + ",");
			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_PHOTO() + ",");
			System.out.print(adoptMemberNews.getADOPT_MEB_NEWS_STATE() + ",");
			System.out.println(adoptMemberNews.getADOPT_MEB_NEWS_DATE() + ",");
			System.out.println("---------------------");
		}

	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, adoptMemberNewsVo adoptMemberNews,
			String SQL, String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptMemberNews.getADOPT_MEB_NO());
		pstmt.setString(2, adoptMemberNews.getADOPT_MEB_NEWS_TITLE());
		pstmt.setString(3, adoptMemberNews.getADOPT_MEB_NEWS_COMMENT());
		pstmt.setBytes(4, adoptMemberNews.getADOPT_MEB_NEWS_PHOTO());
		pstmt.setString(5, adoptMemberNews.getADOPT_MEB_NEWS_STATE());
		pstmt.setDate(6, adoptMemberNews.getADOPT_MEB_NEWS_DATE());
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, adoptMemberNewsVo adoptMemberNews,
			String SQL) throws SQLException {

		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, adoptMemberNews.getADOPT_MEB_NEWS_TITLE());
		pstmt.setString(2, adoptMemberNews.getADOPT_MEB_NEWS_COMMENT());
		pstmt.setBytes(3, adoptMemberNews.getADOPT_MEB_NEWS_PHOTO());
		pstmt.setString(4, adoptMemberNews.getADOPT_MEB_NEWS_STATE());
		pstmt.setDate(5, adoptMemberNews.getADOPT_MEB_NEWS_DATE());
		pstmt.setInt(6, adoptMemberNews.getADOPT_MEB_NEWS_NO());
		return pstmt;
	}

	private adoptMemberNewsVo selectOneadoptMemberNewsByNo(ResultSet rs) {
		adoptMemberNewsVo adoptMemberNews = new adoptMemberNewsVo();
		try {
			while (rs.next()) {
				adoptMemberNews.setADOPT_MEB_NEWS_NO(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setADOPT_MEB_NO(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setADOPT_MEB_NEWS_TITLE(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setADOPT_MEB_NEWS_COMMENT(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setADOPT_MEB_NEWS_PHOTO(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setADOPT_MEB_NEWS_STATE(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setADOPT_MEB_NEWS_DATE(rs.getDate("ADOPT_MEB_NEWS_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberNews;
	}

	private List<adoptMemberNewsVo> selectAllAdoptMemberNews(List<adoptMemberNewsVo> adoptMemberNewsList,
			ResultSet rs) {
		try {
			while (rs.next()) {
				adoptMemberNewsVo adoptMemberNews = new adoptMemberNewsVo();
				adoptMemberNews.setADOPT_MEB_NEWS_NO(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setADOPT_MEB_NO(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setADOPT_MEB_NEWS_TITLE(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setADOPT_MEB_NEWS_COMMENT(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setADOPT_MEB_NEWS_PHOTO(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setADOPT_MEB_NEWS_STATE(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setADOPT_MEB_NEWS_DATE(rs.getDate("ADOPT_MEB_NEWS_DATE"));
				adoptMemberNewsList.add(adoptMemberNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberNewsList;
	}

	private List<adoptMemberNewsVo> selectAdoptMebNewsByTitle(List<adoptMemberNewsVo> adoptMemberNewsList,
			ResultSet rs) {

		try {
			while (rs.next()) {
				adoptMemberNewsVo adoptMemberNews = new adoptMemberNewsVo();
				adoptMemberNews.setADOPT_MEB_NEWS_NO(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setADOPT_MEB_NO(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setADOPT_MEB_NEWS_TITLE(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setADOPT_MEB_NEWS_COMMENT(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setADOPT_MEB_NEWS_PHOTO(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setADOPT_MEB_NEWS_STATE(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setADOPT_MEB_NEWS_DATE(rs.getDate("ADOPT_MEB_NEWS_DATE"));
				adoptMemberNewsList.add(adoptMemberNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adoptMemberNewsList;
	}
}
