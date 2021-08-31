package com.adoptPet.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adoptPet.model.AdoptPetService;

public class AdoptPetServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		if("addPet".equals(action)) {
//			Map<String,String> errorMsgs = new LinkedHashMap<>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try{
//				
//				AdoptPetService adoptPetSvc = new AdoptPetService ();
//				adoptPetSvc.insertAdoptPet();
//				
//				
//				
//				
//				
//			}catch (Exception e) {
//				
//			}
//			
//			
//		}
		System.out.println("123");
	}
}
