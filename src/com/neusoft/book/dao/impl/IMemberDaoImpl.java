package com.neusoft.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;







import com.neusoft.book.dao.IMemberDAO;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.Member;
import com.neusoft.util.AbstractDAOImpl;

public class IMemberDaoImpl extends AbstractDAOImpl implements IMemberDAO{

	public IMemberDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into member(mid,name,age,sex,phone,creditno,num) values(?,?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMid());
		pstmt.setString(2, vo.getName());
		pstmt.setInt(3, vo.getAge());;
		pstmt.setInt(4, vo.getSex());
		pstmt.setString(5, vo.getPhone());
		pstmt.setInt(6, vo.getCreditno());
		pstmt.setInt(7, vo.getNum());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member>  FindById(String id) throws SQLException {
		// TODO Auto-generated method stub
		List<Member> all = new ArrayList<Member>();
		Member vo=null;
		String sql="select mid,name,age,sex,phone,creditno,num from member where mid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		 {
			vo=new Member();
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setSex(rs.getInt(4));
			vo.setPhone(rs.getString(5));
			vo.setCreditno(rs.getInt(6));
			vo.setNum(rs.getInt(7));
			all.add(vo);
		 }
		return all;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		List<Member> all = new ArrayList<Member>();
        String sql = "SELECT mid,name,age,sex,phone,creditno,num FROM member";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Member vo=new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setAge(rs.getInt(3));
            vo.setSex(rs.getInt(4));
            vo.setPhone(rs.getString(5));
            vo.setCreditno(rs.getInt(6));
            vo.setNum(rs.getInt(7));
            all.add(vo);
        }
        return all;
	}

	@Override
	public List<Member> findBySplit(String column, String KeyWord,
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
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
