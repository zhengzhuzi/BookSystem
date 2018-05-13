package com.neusoft.book.service;

import java.util.List;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.Member;

public interface IMemberService {
	public boolean insert(Member vo) throws Exception;
	public List<Member> list() throws Exception;
	public List<Member> findById(String mid) throws Exception;
}
