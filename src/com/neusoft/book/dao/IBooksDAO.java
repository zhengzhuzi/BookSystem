package com.neusoft.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.book.entity.Books;



public interface IBooksDAO extends  IDAO<Integer, Books>{
	public List<Books> findLAll() throws SQLException;
}
