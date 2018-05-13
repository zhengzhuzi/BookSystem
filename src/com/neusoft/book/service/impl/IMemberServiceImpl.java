package com.neusoft.book.service.impl;

import java.util.List;

import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.Member;
import com.neusoft.book.factory.DAOFactory;
import com.neusoft.book.service.IMemberService;

public class IMemberServiceImpl implements IMemberService {
	 DatabaseConnection dbc=new DatabaseConnection();
	 
	@Override
	public boolean insert(Member vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			if(new DAOFactory().getMemberDAOInstance(dbc.getconn()).findById(vo.getMid())==null)
			{    	
				return new DAOFactory().getMemberDAOInstance(dbc.getconn()).doCreate(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			dbc.close();
	    }
		return false;
	
	}

	@Override
	public List<Member> list() throws Exception {
		// TODO Auto-generated method stub
		try {
			return new DAOFactory().getMemberDAOInstance(dbc.getconn()).findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}

	@Override
	public List<Member> findById(String mid) throws Exception {
		// TODO Auto-generated method stub
		try {
			return new DAOFactory().getMemberDAOInstance(dbc.getconn()).FindById(mid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
