package com.neusoft.book.dao;

import java.sql.SQLException;

import com.neusoft.book.entity.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
    
	public boolean findLogin(Admin vo) throws SQLException;
	public boolean updatetime(String aid) throws SQLException;
}
