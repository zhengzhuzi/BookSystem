package com.neusoft.book.service.impl;

import java.util.List;

import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.Member;
import com.neusoft.book.factory.DAOFactory;
import com.neusoft.book.service.IItemService;
import com.neusoft.book.service.IMemberService;

public class IItemServiceImpl implements IItemService {
	 DatabaseConnection dbc=new DatabaseConnection();

	@Override
	public boolean insert(Item vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return new DAOFactory().getItemDAOInstance(dbc.getconn()).doCreate(vo);
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
		
	}

	@Override
	public List<Item> list() throws Exception {
		// TODO Auto-generated method stub
		try {
			 return new DAOFactory().getItemDAOInstance(dbc.getconn()).findAll();
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		Item vo=new Item();
		// TODO Auto-generated method stub
		try {
			 return new DAOFactory().getItemDAOInstance(dbc.getconn()).doRemove(id);
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
	}

	@Override
	public Item FindById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return new DAOFactory().getItemDAOInstance(dbc.getconn()).findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			dbc.close();
		}
		
	}

	@Override
	public boolean update(Item vo) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		try {
			 return new DAOFactory().getItemDAOInstance(dbc.getconn()).doUpdate(vo);
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
	}
	 
	

}
