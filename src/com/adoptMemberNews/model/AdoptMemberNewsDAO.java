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


public class AdoptMemberNewsDAO implements AdoptMemberNews_interface {
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
	public AdoptMemberNewsVo insert(AdoptMemberNewsVo adoptMemberNews) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			String[] cols = { "ADOPT_MEB_NEWS_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptMemberNews, insertSQL, cols);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				adoptMemberNews.setAdopt_meb_news_no(key);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNews;
	}

	@Override
	public void update(AdoptMemberNewsVo adoptMemberNews) {
		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptMemberNews, updateSQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	@Override
	public AdoptMemberNewsVo findByadoptMemberNewsNoPK(Integer adopt_meb_news_no) {
		AdoptMemberNewsVo adoptMemberNews = null;

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByPK);
			pstmt.setInt(1, adopt_meb_news_no);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNews = selectOneadoptMemberNewsByNo(rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNews;
	}

	@Override
	public List<AdoptMemberNewsVo> findByAdoptMebNewsTitle(String adopt_meb_news_title) {
		List<AdoptMemberNewsVo> adoptMemberNewsList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(findByName);
			pstmt.setString(1, "%" + adopt_meb_news_title + "%");
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNewsList = selectAdoptMebNewsByTitle(adoptMemberNewsList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNewsList;
	}

	@Override
	public List<AdoptMemberNewsVo> getAlladoptMemberNews() {
		List<AdoptMemberNewsVo> adoptMemberNewsList = new ArrayList<>();

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
		AdoptMemberNews_interface dao = new AdoptMemberNewsDAO();
		AdoptMemberNewsVo AdoptMemberNewsVo = new AdoptMemberNewsVo();

//		test insert
//		AdoptMemberNewsVo.setAdopt_meb_no(1);
//		AdoptMemberNewsVo.setAdopt_meb_news_title("我是Amos最新消息的標題");
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember1.png");
//			AdoptMemberNewsVo.setAdopt_meb_news_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}		
//		AdoptMemberNewsVo.setAdopt_meb_news_comment("我是Amos最新消息的內容");
//		AdoptMemberNewsVo.setAdopt_meb_news_state("1");
//		AdoptMemberNewsVo.setAdopt_meb_news_date(java.sql.Date.valueOf("2016-08-07"));
//		AdoptMemberNewsVo adoptMember =  dao.insert(AdoptMemberNewsVo);
//		System.out.println(adoptMember.getAdopt_meb_news_no());

//		test update
//		AdoptMemberNewsVo.setAdopt_meb_news_title("更新最新消息標題");					
//		AdoptMemberNewsVo.setAdopt_meb_news_comment("更新最新消息內容");		
//		try {
//			byte[] pic = getPictureByteArray("images/adoptMember2.jpg");
//			AdoptMemberNewsVo.setAdopt_meb_news_photo(pic);
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}	
//		AdoptMemberNewsVo.setAdopt_meb_news_state("0");
//		AdoptMemberNewsVo.setAdopt_meb_news_date(java.sql.Date.valueOf("2021-08-25"));		
//		AdoptMemberNewsVo.setAdopt_meb_news_no(2);
//		dao.update(AdoptMemberNewsVo);

//		test find by PK
//		AdoptMemberNewsVo adoptMemberNews = dao.findByadoptMemberNewsNoPK(1);				
//		System.out.print(adoptMemberNews.getAdopt_meb_news_no() + ",");
//		System.out.print(adoptMemberNews.getAdopt_meb_no() + ",");
//		System.out.print(adoptMemberNews.getAdopt_meb_news_title() + ",");
//		System.out.print(adoptMemberNews.getAdopt_meb_news_photo() + ",");
//		System.out.print(adoptMemberNews.getAdopt_meb_news_state() + ",");
//		System.out.println(adoptMemberNews.getAdopt_meb_news_date() + ",");		
//		System.out.println("---------------------");

//		test find by news title

//		List<AdoptMemberNewsVo> adoptMemberNewsList = dao.findByAdoptMebNewsTitle("更");	
//		for (AdoptMemberNewsVo adoptMemberNews : adoptMemberNewsList) {			
//			System.out.print(adoptMemberNews.getAdopt_meb_news_no() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_no() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_title() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_photo() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_state() + ",");
//			System.out.println(adoptMemberNews.getAdopt_meb_news_date() + ",");		
//			System.out.println("---------------------");
//		}

//		test select all news
//		List<AdoptMemberNewsVo> adoptMemberList = dao.getAlladoptMemberNews();
//		for (AdoptMemberNewsVo adoptMemberNews : adoptMemberList) {
//			System.out.print(adoptMemberNews.getAdopt_meb_news_no() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_no() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_title() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_photo() + ",");
//			System.out.print(adoptMemberNews.getAdopt_meb_news_state() + ",");
//			System.out.println(adoptMemberNews.getAdopt_meb_news_date() + ",");
//			System.out.println("---------------------");
//		}

	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	private PreparedStatement createInsertPreparedStatement(Connection con, AdoptMemberNewsVo adoptMemberNews,
			String SQL, String[] cols) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(SQL, cols);
		pstmt.setInt(1, adoptMemberNews.getAdopt_meb_no());
		pstmt.setString(2, adoptMemberNews.getAdopt_meb_news_title());
		pstmt.setString(3, adoptMemberNews.getAdopt_meb_news_comment());
		pstmt.setBytes(4, adoptMemberNews.getAdopt_meb_news_photo());
		pstmt.setString(5, adoptMemberNews.getAdopt_meb_news_state());
		pstmt.setDate(6, adoptMemberNews.getAdopt_meb_news_date());
		return pstmt;
	}

	private PreparedStatement createUpdatePreparedStatement(Connection con, AdoptMemberNewsVo adoptMemberNews,
			String SQL) throws SQLException {

		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, adoptMemberNews.getAdopt_meb_news_title());
		pstmt.setString(2, adoptMemberNews.getAdopt_meb_news_comment());
		pstmt.setBytes(3, adoptMemberNews.getAdopt_meb_news_photo());
		pstmt.setString(4, adoptMemberNews.getAdopt_meb_news_state());
		pstmt.setDate(5, adoptMemberNews.getAdopt_meb_news_date());
		pstmt.setInt(6, adoptMemberNews.getAdopt_meb_news_no());
		return pstmt;
	}

	private AdoptMemberNewsVo selectOneadoptMemberNewsByNo(ResultSet rs) {
		AdoptMemberNewsVo adoptMemberNews = new AdoptMemberNewsVo();
		try {
			while (rs.next()) {
				adoptMemberNews.setAdopt_meb_news_no(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setAdopt_meb_news_title(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setAdopt_meb_news_comment(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setAdopt_meb_news_photo(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setAdopt_meb_news_state(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setAdopt_meb_news_date(rs.getDate("ADOPT_MEB_NEWS_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberNews;
	}

	private List<AdoptMemberNewsVo> selectAllAdoptMemberNews(List<AdoptMemberNewsVo> adoptMemberNewsList,
			ResultSet rs) {
		try {
			while (rs.next()) {
				AdoptMemberNewsVo adoptMemberNews = new AdoptMemberNewsVo();
				adoptMemberNews.setAdopt_meb_news_no(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setAdopt_meb_news_title(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setAdopt_meb_news_comment(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setAdopt_meb_news_photo(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setAdopt_meb_news_state(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setAdopt_meb_news_date(rs.getDate("ADOPT_MEB_NEWS_DATE"));
				adoptMemberNewsList.add(adoptMemberNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adoptMemberNewsList;
	}

	private List<AdoptMemberNewsVo> selectAdoptMebNewsByTitle(List<AdoptMemberNewsVo> adoptMemberNewsList,
			ResultSet rs) {

		try {
			while (rs.next()) {
				AdoptMemberNewsVo adoptMemberNews = new AdoptMemberNewsVo();
				adoptMemberNews.setAdopt_meb_news_no(rs.getInt("ADOPT_MEB_NEWS_NO"));
				adoptMemberNews.setAdopt_meb_no(rs.getInt("ADOPT_MEB_NO"));
				adoptMemberNews.setAdopt_meb_news_title(rs.getString("ADOPT_MEB_NEWS_TITLE"));
				adoptMemberNews.setAdopt_meb_news_comment(rs.getString("ADOPT_MEB_NEWS_COMMENT"));
				adoptMemberNews.setAdopt_meb_news_photo(rs.getBytes("ADOPT_MEB_NEWS_PHOTO"));
				adoptMemberNews.setAdopt_meb_news_state(rs.getString("ADOPT_MEB_NEWS_STATE"));
				adoptMemberNews.setAdopt_meb_news_date(rs.getDate("ADOPT_MEB_NEWS_DATE"));
				adoptMemberNewsList.add(adoptMemberNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adoptMemberNewsList;
	}
}
