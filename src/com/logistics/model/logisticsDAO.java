package com.logistics.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class logisticsDAO implements logisticsDAO_interface{
	public class product_promotions_detailDAO implements product_promotions_detailDAO_interface{
//		public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//		public static final String URL = "jdbc:mysql://localhost:3306/CFA_102_04?serverTimezone=Asia/Taipei";
//		public static final String USER = "David";
//		public static final String PASSWORD = "123456";
				
		private static final String INSERT_STMT = "insert into logistics(logistics_name) values (?)";
		private static final String UPDATE_STMT = "update logistics set logistics_name=? WHERE logistics_no";
		private static final String DELETE_STMT = "delete from logistics where logistics_no=?";
		private static final String FIND_BY_PK = "select * from logistics where logistics_no=?";
		private static final String GET_ALL = "select * from logistics";

	
	
	
	
	
	
	
	
	}
}
