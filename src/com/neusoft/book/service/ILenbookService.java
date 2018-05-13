package com.neusoft.book.service;

import java.util.Map;

import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.LenBook;
import com.neusoft.book.entity.Member;

public interface ILenbookService {
	 /**
     * 判断是否插入成功，布尔类型
     * @param vo
     * @return
     * @throws Exception
     */
	public boolean insert(LenBook vo) throws Exception;
	/**
	 * 找到Member和Books的所有值，然后再以Map类型返回
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findByMemberAndBook() throws Exception;
	
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
			Integer currentPage, Integer lineSize) throws Exception;
	
	public boolean UpdateRetdate(int leid,String retstatus,String credate,String retday,int creditno) throws Exception;
	
	public int retstatusCount(String mid,String retstatus) throws Exception;
	
	public boolean update(int creditno,int num,String mid) throws Exception;
	public boolean updateNum(int num,String mid) throws Exception;
}
