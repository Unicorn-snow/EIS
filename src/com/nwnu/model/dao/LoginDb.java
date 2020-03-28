package com.nwnu.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginDb {
	
	Connection conn;
	Statement sta;
	ResultSet res;
	boolean yz;
	public boolean doSelect(String sql)
	{
		MysqlConnection mysqlConn = new MysqlConnection();
		conn = mysqlConn.myConnection();
		try {
            sta = conn.createStatement();
            res = sta.executeQuery(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			if(res.next())
				yz = true;	
			else
				yz= false;	
		} catch (SQLException e) {
            e.printStackTrace();
					
		}
		return yz;
	}
	/*public String switchLogin(String sql) {
		
		String sw = "fail";
		MysqlConnection mysqlConn = new MysqlConnection();
		conn = mysqlConn.myConnection();
		try {
			 	sta = conn.createStatement();
	            res = sta.executeQuery(sql);
	            while(res.next()) {
	            	System.out.println(res.next());
	            	
	            }
		}catch (SQLException e) {
            e.printStackTrace();
					
		}
		return sw;
		
		
	}
	*/
}

