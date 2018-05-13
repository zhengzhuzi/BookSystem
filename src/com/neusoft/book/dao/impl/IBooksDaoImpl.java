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

import com.neusoft.book.dao.IBooksDAO;
import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;
import com.neusoft.util.AbstractDAOImpl;

public class IBooksDaoImpl extends AbstractDAOImpl implements IBooksDAO {

	public IBooksDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(Books vo) throws SQLException {
		// TODO Auto-generated method stub ,imagepath
		String sql="insert into books(iid,aid,name,credate,status,note,imagepath) values(?,?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getItem().getIid());
		pstmt.setString(2, vo.getAdmin().getAid());
		pstmt.setString(3, vo.getName());
		String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());  
        Timestamp time = Timestamp.valueOf(current); 
		pstmt.setTimestamp(4, time);
		pstmt.setInt(5, vo.getStatus());
		pstmt.setString(6, vo.getNote());
		pstmt.setString(7, vo.getImagepath());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Books vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Books findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Books> list=new ArrayList<Books>();
		String sql="select b.bid,i.name,b.aid,b.name,b.credate,b.status,b.note,b.imagepath from books b,item i where b.iid=i.iid";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			Books vo=new Books();
			vo.setBid(rs.getInt(1));
			Item item=new Item();
			//item.setIid(rs.getInt(2));
			//vo.setItem(item);
			item.setName(rs.getString(2));
			vo.setItem(item);
			Admin admin=new Admin();
			admin.setAid(rs.getString(3));
			vo.setAdmin(admin);
			vo.setName(rs.getString(4));
			vo.setCreadate(rs.getTimestamp(5));
			vo.setStatus(rs.getInt(6));
			vo.setNote(rs.getString(7));
			vo.setImagepath(rs.getString(8));
			list.add(vo);

		}
				
		return list;
	}
     
	@Override
	public List<Books> findBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		List<Books> all = new ArrayList<Books>();
        String sql = " SELECT b.bid,b.name,b.credate,b.status,a.aid,i.name,b.imagepath " +
                " FROM books b,admin a ,item i " +
                " WHERE b.iid= i.iid AND b.aid = a.aid AND b."+ column +" LIKE  ?  LIMIT ?,? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage -1) *lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Books vo = new Books();
            vo.setBid(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setCreadate(rs.getDate(3));
            vo.setStatus(rs.getInt(4));
            Admin admin = new Admin();
            admin.setAid(rs.getString(5));
            vo.setAdmin(admin);
            Item item = new Item();
            item.setName(rs.getString(6));
            vo.setItem(item);
            vo.setImagepath(rs.getString(7));
            all.add(vo);
        }
        return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM books WHERE "+column +" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
	

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Books> findLAll() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Books> all=new ArrayList<Books>();
		String sql="select bid,name from books";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			Books vo=new Books();
		    vo.setBid(rs.getInt(1));
		    vo.setName(rs.getString(2));
		    all.add(vo);
		}
		return all;
	}

}
