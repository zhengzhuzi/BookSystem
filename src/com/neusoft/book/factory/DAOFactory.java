package com.neusoft.book.factory;

import java.sql.Connection;

import com.neusoft.book.dao.IAdminDAO;
import com.neusoft.book.dao.IBooksDAO;
import com.neusoft.book.dao.IItemDAO;
import com.neusoft.book.dao.ILenbookDAO;
import com.neusoft.book.dao.IMemberDAO;
import com.neusoft.book.dao.impl.IAdminDaoImpl;
import com.neusoft.book.dao.impl.IBooksDaoImpl;
import com.neusoft.book.dao.impl.IItemDaoImpl;
import com.neusoft.book.dao.impl.ILenbookDaoImpl;
import com.neusoft.book.dao.impl.IMemberDaoImpl;

public class DAOFactory {
	
	public static IAdminDAO getAdminDAOInstance(Connection conn)
	{
		return new IAdminDaoImpl(conn);
		
	}
	public static IMemberDAO getMemberDAOInstance(Connection conn)
	{
		return new IMemberDaoImpl(conn);
		
	}
	public static IItemDAO getItemDAOInstance(Connection conn)
	{
		return new IItemDaoImpl(conn);
	}
	public static IBooksDAO getBooksDAOInstance(Connection conn)
	{
		return new IBooksDaoImpl(conn);
	}
	public static ILenbookDAO getLenbookDaoInstance(Connection conn)
	{
		return new ILenbookDaoImpl(conn);	
	}
}
