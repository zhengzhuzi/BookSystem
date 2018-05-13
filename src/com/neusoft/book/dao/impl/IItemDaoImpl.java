package com.neusoft.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.neusoft.book.dao.IItemDAO;
import com.neusoft.book.entity.Item;
import com.neusoft.util.AbstractDAOImpl;

public class IItemDaoImpl extends AbstractDAOImpl implements IItemDAO {

	public IItemDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(Item vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into item(name,note) values (?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getNote());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Item vo) throws SQLException {
		// TODO Auto-generated method stub
		 String sql= "UPDATE item SET name=?,note=? WHERE iid=?";
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, vo.getName());
		 pstmt.setString(2, vo.getNote());
		 pstmt.setInt(3, vo.getIid());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Item> findAll() throws SQLException {
		List<Item> all = new ArrayList<Item>();
        String sql = "SELECT iid ,name,note FROM item";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Item vo = new Item();
            vo.setIid(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setNote(rs.getString(3));
            all.add(vo);
        }
        return all;
	}

	@Override
	public List<Item> findBySplit(String column, String KeyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Item item=new Item();
		String sql = "delete FROM item  where iid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate()>0;
	}

	@Override
	public Item findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Item vo=new Item();
		String sql = "select  iid ,name,note FROM item  where iid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		 ResultSet rs=pstmt.executeQuery();
		 if(rs.next())
		 {
	            vo.setIid(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setNote(rs.getString(3));
		 }
		return vo;
	}

	

}
