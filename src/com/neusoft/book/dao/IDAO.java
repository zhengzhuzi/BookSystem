package com.neusoft.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IDAO<K,V> {
	 
	/*
	 * 增加数据，成功返回true
	 */
	public boolean doCreate(V vo) throws SQLException;
	/*
	 * 更新数据，成功返回true
	 */
	public boolean doUpdate(V vo) throws SQLException;
	/*
	 * 删除数据，成功返回true
	 */
	public boolean doRemove(Set<?> ids) throws SQLException;
	
	public boolean doRemove(K id)throws SQLException;
	/*
	 * 根据id
	 */
	public V findById(K id) throws SQLException;
	
	public List<V> findAll() throws SQLException;
	
	public List<V> findBySplit(String column,String KeyWord,Integer currentPage,Integer lineSize) throws SQLException;
	
	public Integer getAllCount(String column,String keyWord) throws SQLException;
	

}
