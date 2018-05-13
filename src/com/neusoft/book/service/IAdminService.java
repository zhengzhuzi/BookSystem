package com.neusoft.book.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Item;

public interface IAdminService {
    
	public boolean Login(Admin vo) throws Exception;
	public List<Item> list() throws Exception;
	public boolean insert(Admin vo)throws Exception;

}
