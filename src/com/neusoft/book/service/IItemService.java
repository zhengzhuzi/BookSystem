package com.neusoft.book.service;

import java.util.List;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.Member;

public interface IItemService {
	public boolean insert(Item vo) throws Exception;
	public List<Item> list() throws Exception;
	public boolean delete(Integer id) throws Exception;
	public Item FindById(Integer id) throws Exception;
	public boolean update(Item vo) throws Exception;
}
