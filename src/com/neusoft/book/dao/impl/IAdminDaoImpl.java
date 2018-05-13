package com.neusoft.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.neusoft.book.dao.IAdminDAO;
import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Item;
import com.neusoft.util.AbstractDAOImpl;

public class IAdminDaoImpl extends AbstractDAOImpl implements IAdminDAO  {

	public IAdminDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
   
   /**
    *   成功返回true，并且返回最后一次登录的日期
    */
	public boolean findLogin(Admin vo) throws SQLException {
		// TODO Auto-generated method stub
		    boolean flag = false;
	        String sql = "SELECT lastdate,flag FROM admin WHERE aid=? AND password=? AND status=1";
	        super.pstmt = super.conn.prepareStatement(sql);
	        super.pstmt.setString(1,vo.getAid());
	        super.pstmt.setString(2,vo.getPassword());
	        ResultSet rs = super.pstmt.executeQuery();
	        if (rs.next()){
	            flag = true;
	            vo.setLastdate(rs.getTimestamp(1));
	            vo.setFlag(rs.getInt(2));
	        }
	        return flag;
	}

	public boolean doCreate(Admin vo) throws SQLException {
		// TODO Auto-generated method stub
		    String sql = "INSERT INTO admin(aid,password,lastdate,status) VALUES(?,?,?,?)";
	        super.pstmt = super.conn.prepareStatement(sql);
	        super.pstmt.setString(1,vo.getAid());
	        super.pstmt.setString(2,vo.getPassword());
	        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());  
	        Timestamp time = Timestamp.valueOf(current); 
	        super.pstmt.setTimestamp(3, time);
	        super.pstmt.setInt(4,vo.getStatus());
	        return super.pstmt.executeUpdate() > 0;
	}
    
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doUpdate(Admin vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Admin> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Admin> all=new ArrayList<Admin>();
		String sql="select aid,password,lastdate,flag,status from admin";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
           Admin vo = new Admin();
           vo.setAid(rs.getString(1));
           vo.setPassword(rs.getString(2));
           vo.setLastdate(rs.getTimestamp(3));
           vo.setFlag(rs.getInt(4));
           vo.setStatus(rs.getInt(5));
           all.add(vo);
        }
        return all;
	}

	public Admin findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Admin vo = null;
        String sql = "SELECT aid,password,lastdate,status,flag FROM admin WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            vo = new Admin();
            vo.setAid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setLastdate(rs.getTimestamp(3));
            vo.setStatus(rs.getInt(4));
            vo.setFlag(rs.getInt(5));
        }
        return vo;
	}

	public List<Admin> findBySplit(String column, String KeyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatetime(String aid) throws SQLException {
		 String sql = "UPDATE admin SET lastdate=? WHERE aid=?";
	        super.pstmt = super.conn.prepareStatement(sql);
	        // 登录成功后直接使用当前日期为最后一次登录日期
	        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());  
	        Timestamp time = Timestamp.valueOf(current); 
//	        super.pstmt.setTimestamp(1,new Timestamp(new Date().getYear(), new Date().getMonth(),  
//	        		new Date().getDay(), new Date().getHours(),  
//	        		new Date().getMinutes(), new Date().getSeconds(), 0));
	        //pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	        pstmt.setTimestamp(1, time);
	        super.pstmt.setString(2, aid);
	        return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
