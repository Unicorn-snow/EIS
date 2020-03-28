package com.nwnu.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportDb {
	
	Connection conn;
	Statement sta;
	ResultSet res;
	public void doUpdate(String sql)
	{
		MysqlConnection mysqlConn = new MysqlConnection();
		conn = mysqlConn.myConnection();
		try {
       //     sta = conn.createStatement();
           // sta.executeQuery(sql);
			sta = conn.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
