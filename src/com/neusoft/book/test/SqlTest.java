package com.neusoft.book.test;

import org.junit.Test;

import com.neusoft.book.dao.IBooksDAO;
import com.neusoft.book.dao.impl.IBooksDaoImpl;
import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.Books;

public class SqlTest {
     DatabaseConnection dbc=new DatabaseConnection();
     private IBooksDAO Ibook=new IBooksDaoImpl(dbc.getconn());
     
   public static void main(String args[])
   {    String a="delete";
   String b="delete?id=3";
	   System.out.println(b.indexOf(a));
   }
    	
}
