package com.neusoft.book.dbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection {
   private static final String DBDRIVER="com.mysql.jdbc.Driver";
   private static final String DBURL="jdbc:mysql:///bookSystem?zeroDateTimeBehavior=convertToNull";
   private static final String DBUSER="root";
   private static final String DBPASS="root";
   private Connection conn;
   public DatabaseConnection()
   {
	   try {
		    Class.forName(DBDRIVER);
		    this.conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		    
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   public Connection getconn()
   {
	 return this.conn;   
   }
    public void close()
    {
    	if(conn!=null)
    	{
    		try {
    			this.conn.close();
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    	}
    
    }
}
