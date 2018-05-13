package com.neusoft.book.service.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;
import com.neusoft.book.factory.DAOFactory;
import com.neusoft.book.service.IBookService;
import com.neusoft.util.AbstractDAOImpl;

public class IBookServiceImpl  implements IBookService{

	  DatabaseConnection dbc=new DatabaseConnection();

	@Override
	public boolean insert(Books vo) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					 return new DAOFactory().getBooksDAOInstance(dbc.getconn()).doCreate(vo);
				} catch (Exception e) {
					// TODO: handle exception
					 throw e;
				}
				finally{
					 dbc.close();
				}
	}

	@Override
	public Map<String, Object> findByAdminAndItem() throws Exception {
		// TODO Auto-generated method stub
		 Map<String, Object> map=new HashMap<String, Object>();
		try {
			map.put("allAdmins", new DAOFactory().getAdminDAOInstance(dbc.getconn()).findAll());
			map.put("allItems" ,  new DAOFactory().getItemDAOInstance(dbc.getconn()).findAll());
			return map; 
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
	}

	@Override
	public List<Books> list() throws Exception {
		// TODO Auto-generated method stub
		try {
			return new DAOFactory().getBooksDAOInstance(dbc.getconn()).findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			 throw e;
		}
		finally{
			 dbc.close();
		}
	}

	

	@Override
	public Map<String, Object> listBySplit(String column, String KeyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		 try{
	      Map<String,Object> map = new HashMap<String, Object>();
	      map.put("allBooks" ,DAOFactory.getBooksDAOInstance(this.dbc.getconn()).findBySplit(column,KeyWord,currentPage,lineSize));
	      map.put("allCounts",DAOFactory.getBooksDAOInstance(this.dbc.getconn()).getAllCount(column,KeyWord));
	            return map;
	        }catch (Exception e){
	            throw e;
	        }finally {
	            this.dbc.close();
	        }
	    }

	}

