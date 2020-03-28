package com.nwnu.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	 private String url = "jdbc:mysql://localhost:3306/eis";
	 private String userName = "root";
	 private String password = "123456";
	 
	 Connection conn;
	 public Connection myConnection()
	 {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
		 }catch(ClassNotFoundException e) {
			 
		 }
		 
		 try {
			 conn = DriverManager.getConnection(url, userName, password);
		 } catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
		 return conn;
	 }

}
