package com.neusoft.book.service;

import java.util.List;
import java.util.Map;

import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;

public interface IBookService {
    /**
     * 判断是否插入成功，布尔类型
     * @param vo
     * @return
     * @throws Exception
     */
	public boolean insert(Books vo) throws Exception;
	/**
	 * 找到Admin和Item的所有值，然后再以Map类型返回
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findByAdminAndItem() throws Exception;
	/**
	 * 把所有的Books的都放进list
	 * @return
	 * @throws Exception
	 */
	public List<Books> list() throws Exception;
	
	/**
	 * 
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> listBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception;;
}
