package com.adopt.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class test extends HttpServlet {

//	網頁測試
	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	                               throws ServletException, IOException {

	    res.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = res.getWriter();

	    out.println("<HTML>");
	    out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<BIG>測試XML</BIG>");
	    out.println("</BODY></HTML>");
	  }
	
//	連線池測試
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//
//		res.setContentType("text/plain; charset=UTF-8");
//		PrintWriter out = res.getWriter();
//
//		try {
//			Context ctx = new javax.naming.InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
//			if (ds != null) {
//				Connection conn = ds.getConnection();
//
//				if (conn != null) {
//					Statement stmt = conn.createStatement();
//					ResultSet rs = stmt.executeQuery("SELECT * from ADOPT_PET");
//					while (rs.next()) {
//						out.println("ADOPT_PET = " + rs.getString("ADOPT_PET_BREEDS"));
//					}
//					conn.close();
//				}
//			}
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
}
