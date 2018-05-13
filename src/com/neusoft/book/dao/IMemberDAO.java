package com.neusoft.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.book.entity.Member;



public interface IMemberDAO extends  IDAO<String, Member>{
        public List<Member> FindById(String id) throws SQLException;
}
