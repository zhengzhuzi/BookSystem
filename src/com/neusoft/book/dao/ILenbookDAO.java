package com.neusoft.book.dao;

import java.sql.SQLException;
import java.util.Date;

import com.neusoft.book.entity.LenBook;

public interface ILenbookDAO extends IDAO<Integer,LenBook> {
	
	public boolean doUpdateRetdate(Integer leid,String retstatu,String credate,String retday,int creditno) throws SQLException;
    public int retstatusCount (String mid,String retstatus)  throws SQLException;
    public boolean updatecreditno(int creditno,int num,String mid) throws SQLException;
    public boolean updateNum(int num,String mid) throws SQLException;
}
