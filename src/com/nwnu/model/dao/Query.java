package com.nwnu.model.dao;

import java.sql.*; 

public class Query {
	
	
	Statement sta;
	ResultSet res;
	MysqlConnection mysqlConn = new MysqlConnection();
	Connection conn = mysqlConn.myConnection();
	
	
	Object a[][]=null;  
	String b[]=null;  
	String tableName="";  
	int p;//�ֶθ���  
	    
	public Object[][] getRecord(){//���������  
		a=null;  
	    b=null;  
	    try{   
	         int p=getZiDuan();  
	         int n=getAmount();  
	         a=new Object[n][p];  
	         sta=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
	         res=sta.executeQuery("select * from "+tableName);  
	         int m=0;  
	         while(res.next()){  
	             for(int k=1;k<=p;k++){  
	                 a[m][k-1]=res.getString(k);  
	             }  
	         System.out.println();  
	         m++;  
	         }  
	    }  
	        catch(SQLException e){  
	            System.out.println("��������ȷ�ı���"+e);  
	        }  
	        return a;  
	    }  
	    
	    public int getAmount(){//��������ж�����  
	     
	        try{  
	             
	            sta=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
	            res=sta.executeQuery("select * from "+tableName);  
	            res.last();  
	            int rows=res.getRow();  
	            return rows;  
	        }  
	        catch(SQLException exp){  
	            System.out.println(""+exp);  
	            return 0;  
	        }  
	    }  
	    
	    public String[] getField(){//���ֶ�����   
	        try{   
	            DatabaseMetaData metadata=conn.getMetaData();  
	            ResultSet rs1=metadata.getColumns(null, null, tableName, null);  
	            int p=getZiDuan();  
	            b=new String[p];  
	            int k=0;  
	            while(rs1.next()){  
	                b[k]=rs1.getString(4);  
	                k++;  
	            }           
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return b;  
	    }  
	    
	    public void setTableName(String s){//���Ա���  
	        tableName=s.trim();  
	    }  
	    
	    public int getZiDuan(){//���ֶθ���  
	        try{  
	            
	            DatabaseMetaData metadata=conn.getMetaData();  
	            ResultSet rs1=metadata.getColumns(null, null, tableName, null);  
	            p=0;  
	            while(rs1.next())  
	                p++;  
	        }  
	        catch(SQLException e){  
	            System.out.println(e);  
	        }  
	        return p;  
	    }  
}
