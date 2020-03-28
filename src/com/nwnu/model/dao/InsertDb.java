package com.nwnu.model.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertDb {
	
	Connection conn;
	Statement sta;
	int res;
	boolean yz;
	public boolean doInsert(String sql)
	{
		MysqlConnection mysqlConn = new MysqlConnection();
		conn = mysqlConn.myConnection();
		try {
            sta = conn.createStatement();
            res = sta.executeUpdate(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	if(res>0)
		yz = true;
	else
		yz = false;
							
	return yz;
	}
}

