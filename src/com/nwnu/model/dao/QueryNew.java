package com.nwnu.model.dao;

import java.sql.*; 

public class QueryNew {
	
	String Sqll;
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
	         int n=getAmount();
	         sta = conn.createStatement();
	         res = sta.executeQuery(Sqll);
	         ResultSetMetaData rem = res.getMetaData();
	         int p=rem.getColumnCount(); 
	         a=new Object[n][p];  
	        // sta=conn.createStatement();           
	         
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
	             
	            sta=conn.createStatement();  
	            res=sta.executeQuery(Sqll);  
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
	        	sta = conn.createStatement();
	        	res = sta.executeQuery(Sqll);
	        	ResultSetMetaData rem = res.getMetaData();
	           	int p=rem.getColumnCount();
	          // 	System.out.println(p);
	            b=new String[p];  
	            int k;  	             
	            for (k=0; k < p; k++) {// ��ȡ��1���ֶε�����
					
					b[k]= rem.getColumnName(k+1); 
					//System.out.println(b[k]);
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
	    public void setSqll(String s){//���Ա���  
	        Sqll = s;  
	    }
	    
	/*    public int getZiDuan(){//���ֶθ���  
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
	    }  */
}
