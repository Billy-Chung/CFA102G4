package com.adopt.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet {

	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	                               throws ServletException, IOException {

	    res.setContentType("text/html; charset=Big5");
	    PrintWriter out = res.getWriter();

	    out.println("<HTML>");
	    out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<BIG>´ú¸ÕXML</BIG>");
	    out.println("</BODY></HTML>");
	  }
	}
