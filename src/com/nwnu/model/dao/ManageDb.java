package com.nwnu.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManageDb {
	
	Connection conn;
	Statement sta;
	ResultSet res;
	boolean yz;
	public ResultSet doSelect(String sql)
	{
		MysqlConnection mysqlConn = new MysqlConnection();
		conn = mysqlConn.myConnection();
		try {
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
			
		return res;
	}
}

