package com.nwnu.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartDb {
	Statement sta;
	ResultSet res;
	MysqlConnection mysqlConn = new MysqlConnection();
	Connection conn = mysqlConn.myConnection();
	public int getCount(String xy,int key){
		
		String sql = "select * from basic where 所在学院 = '" + xy + "'";
		int count = 0;
		try 
		{
			sta = conn.createStatement();			
			res = sta.executeQuery(sql);
			while(res.next())
				count++;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }				 
        return count;
       
	}
	public int getyCount(String xy,int key) {
		String sql = "select * from basic,information where basic.name = information.name and basic.所在学院 = '" + xy + "'";
		int count = 0;
		try 
		{
			sta = conn.createStatement();			
			res = sta.executeQuery(sql);
			while(res.next())
				count++;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }				 
        return count;
		
		
		
	}
}
