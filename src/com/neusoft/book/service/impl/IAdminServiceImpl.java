package com.neusoft.book.service.impl;

import java.util.List;

import com.neusoft.book.dbc.DatabaseConnection;
import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Item;
import com.neusoft.book.factory.DAOFactory;
import com.neusoft.book.service.IAdminService;

public class IAdminServiceImpl implements IAdminService {
  DatabaseConnection dbc=new DatabaseConnection();
/*
 * (non-Javadoc)
 * @see com.neusoft.book.service.IAdminService#Login(com.neusoft.book.entity.Admin)
 * 成功返回true ,并且返回最后一次显示的时间
 */
public boolean Login(Admin vo) throws Exception {
	// TODO Auto-generated method stub
	try {
		if(new DAOFactory().getAdminDAOInstance(dbc.getconn()).findLogin(vo))
		{    
			return new DAOFactory().getAdminDAOInstance(dbc.getconn()).updatetime(vo.getAid());
		}
		return false;
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
	
	return null;
}
@Override
public boolean insert(Admin vo) throws Exception {
	// TODO Auto-generated method stub
	try{
        if(DAOFactory.getAdminDAOInstance(this.dbc.getconn()).findById(vo.getAid()) == null){
            return DAOFactory.getAdminDAOInstance(this.dbc.getconn()).doCreate(vo);
        }
        return false;
    }catch (Exception e){
        throw e;
    }finally {
        this.dbc.close();
    }
}
}

	
     

