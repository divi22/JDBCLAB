package com.cap.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String user = "root";
	private static String password = "root";
	private static String url="jdbc:mysql://localhost:3306/demodb";


	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url,user,password);
	}
	

}
