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
	private static final String SQL_URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
	private static final String SQL_USER = "David";
	private static final String SQL_PASSWORD = "123456";
	private static final String INSERT_SQL = "insert into ADOPT_MEMBER_NEWS (ADOPT_MEB_NO,ADOPT_MEB_NEWS_TITLE,ADOPT_MEB_NEWS_COMMENT,ADOPT_MEB_NEWS_PHOTO,ADOPT_MEB_NEWS_STATE,ADOPT_MEB_NEWS_DATE) values(?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "update ADOPT_MEMBER_NEWS set ADOPT_MEB_NEWS_TITLE = ?, ADOPT_MEB_NEWS_COMMENT = ?, ADOPT_MEB_NEWS_PHOTO = ?, ADOPT_MEB_NEWS_STATE = ?, ADOPT_MEB_NEWS_DATE = ? where ADOPT_MEB_NEWS_NO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ADOPT_MEMBER_NEWS WHERE ADOPT_MEB_NEWS_NO = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM ADOPT_MEMBER_NEWS WHERE ADOPT_MEB_NEWS_TITLE like ?";
	private static final String SELECT_ALL = "SELECT * FROM ADOPT_MEMBER_NEWS";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public AdoptMemberNewsVo insert(AdoptMemberNewsVo adoptMemberNews) {
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			String[] cols = { "ADOPT_MEB_NEWS_NO" };
			PreparedStatement pstmt = createInsertPreparedStatement(con, adoptMemberNews, INSERT_SQL, cols);
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
		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = createUpdatePreparedStatement(con, adoptMemberNews, UPDATE_SQL);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	@Override
	public AdoptMemberNewsVo findByadoptMemberNewsNoPK(Integer adopt_meb_news_no) {
		AdoptMemberNewsVo adoptMemberNews = null;

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_PK);
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

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(FIND_BY_NAME);
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

		try (Connection con = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			adoptMemberNewsList = selectallAdoptMemberNews(adoptMemberNewsList, rs);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return adoptMemberNewsList;
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

	private List<AdoptMemberNewsVo> selectallAdoptMemberNews(List<AdoptMemberNewsVo> adoptMemberNewsList,
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
