package com.neusoft.book.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.LenBook;
import com.neusoft.book.entity.Member;
import com.neusoft.book.factory.DAOFactory;
import com.neusoft.book.service.ILenbookService;

public class ILenbookServiceImpl implements ILenbookService{
    DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean insert(LenBook vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return new DAOFactory().getLenbookDaoInstance(dbc.getconn()).doCreate(vo);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			dbc.close();
		}
		
		
	}
	@Override
	public Map<String, Object> findByMemberAndBook() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			map.put("allBooks", new DAOFactory().getBooksDAOInstance(dbc.getconn()).findLAll());
			map.put("allMember", new DAOFactory().getMemberDAOInstance(dbc.getconn()).findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			dbc.close();
		}
		return map;
	}
	@Override
	public Map<String, Object> listBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			map.put("allLenBooks", new DAOFactory().getLenbookDaoInstance(dbc.getconn()).findBySplit(column, keyWord, currentPage, lineSize));
			map.put("allLenBookCounts", new DAOFactory().getLenbookDaoInstance(dbc.getconn()).getAllCount(column, keyWord));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			dbc.close();
		}
		return map;
	}
	@Override
	public boolean UpdateRetdate(int leid,String retstatus,String credate,String retday,int creditno) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return DAOFactory.getLenbookDaoInstance(dbc.getconn()).doUpdateRetdate(leid,retstatus,credate,retday,creditno);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			dbc.close();
		}
	}

	@Override
	public int retstatusCount(String mid, String retstatus) throws Exception {
		try {
			return DAOFactory.getLenbookDaoInstance(dbc.getconn())
					.retstatusCount(mid, retstatus);
		}
		// TODO: handle exception
		catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}
	@Override
	public boolean update(int creditno,int num,String mid) throws Exception {
		// TODO Auto-generated method stub
		try{
			return DAOFactory.getLenbookDaoInstance(dbc.getconn()).updatecreditno(creditno,num,mid);
		}catch(Exception e){
			throw e;
		}finally{
			dbc.close();
		}
	}
	@Override
	public boolean updateNum(int num, String mid) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getLenbookDaoInstance(dbc.getconn()).updateNum(num, mid);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			dbc.close();
		}
		
	}

}
