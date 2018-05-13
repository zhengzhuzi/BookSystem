package com.neusoft.book.factory;


import com.neusoft.book.service.IAdminService;
import com.neusoft.book.service.IBookService;
import com.neusoft.book.service.IItemService;
import com.neusoft.book.service.ILenbookService;
import com.neusoft.book.service.IMemberService;
import com.neusoft.book.service.impl.IAdminServiceImpl;
import com.neusoft.book.service.impl.IBookServiceImpl;
import com.neusoft.book.service.impl.IItemServiceImpl;
import com.neusoft.book.service.impl.ILenbookServiceImpl;
import com.neusoft.book.service.impl.IMemberServiceImpl;

public class ServiceFactory {
    
	public static IAdminService getAdminServiceInstance()
	{
		return new IAdminServiceImpl();
		
	}
	public static IMemberService getMemberServiceInstance()
	{
		return new IMemberServiceImpl();	
	}
	public static IItemService getItemServiceInstance()
	{
		return new IItemServiceImpl();	
	}
	public static IBookService getBookServiceInstance()
	{
		return new IBookServiceImpl();	
	}
	public static ILenbookService getLenbookServiceInstance()
	{
		return new ILenbookServiceImpl();	
	}
}
