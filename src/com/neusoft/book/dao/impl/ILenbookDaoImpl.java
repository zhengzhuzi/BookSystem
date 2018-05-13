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

import com.neusoft.book.dao.ILenbookDAO;
import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;
import com.neusoft.book.entity.LenBook;
import com.neusoft.book.entity.Member;
import com.neusoft.util.AbstractDAOImpl;

public class ILenbookDaoImpl extends AbstractDAOImpl implements ILenbookDAO {

	public ILenbookDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(LenBook vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into lenbook(bid,mid,credate,retday,retstatus,creditno) values(?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getBooks().getBid());
		pstmt.setString(2,vo.getMember().getMid());
		String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());  
        Timestamp time = Timestamp.valueOf(current); 
        pstmt.setTimestamp(3, time);
        pstmt.setInt(4, vo.getRetday());
        pstmt.setString(5,vo.getRetstatus());
        pstmt.setInt(6, vo.getCreditno());
		return pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(LenBook vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LenBook findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LenBook> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public List<LenBook> findBySplit(String column, String KeyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		List<LenBook> all = new ArrayList<LenBook>();
        String sql = " SELECT l.leid,b.name,m.name,l.credate,l.retdate,l.retday,l.retstatus,l.creditno,l.mid,m.creditno,m.num" +
                " FROM lenbook l,books b ,member m " +
                " WHERE l.bid= b.bid AND l.mid = m.mid AND l."+ column +" LIKE  ?  LIMIT ?,? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+KeyWord+"%");
        super.pstmt.setInt(2,(currentPage -1) *lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            LenBook vo = new LenBook();
            vo.setLeid(rs.getInt(1));
            Books book=new Books();
            book.setName(rs.getString(2));
            vo.setBooks(book);
            Member member=new Member();
            member.setName(rs.getString(3));
            vo.setMember(member);
            vo.setCredate(rs.getDate(4));
            vo.setRetdate(rs.getDate(5));
            vo.setRetday(rs.getInt(6));
            vo.setRetstatus(rs.getString(7));
            vo.setCreditno(rs.getInt(8));
            member.setMid(rs.getString(9));
            vo.setMember(member);
            member.setCreditno(rs.getInt(10));
            vo.setMember(member);
            member.setNum(rs.getInt(11));
            vo.setMember(member);
            all.add(vo);
        }
        return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM lenbook WHERE "+column +" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
	}

	@Override
	public boolean doUpdateRetdate(Integer leid,String retstatus,String credate,String retday,int creditno)
			throws SQLException {
		// TODO Auto-generated method stub
		 LenBook vo = new LenBook();
		String sql="update lenbook set retdate=?,retstatus =? where leid=?";
		pstmt=conn.prepareStatement(sql);
		String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date());  
        Timestamp time = Timestamp.valueOf(current); 
        pstmt.setTimestamp(1, time);
        pstmt.setString(2,retstatus);
        pstmt.setInt(3, leid);
        
       // pstmt.setString(4, credate);
		return pstmt.executeUpdate()>0;
	}

	@Override
	public int retstatusCount(String mid,String retstatus) throws SQLException {
		// TODO Auto-generated method stub
		 LenBook vo = new LenBook();
		String sql="SELECT COUNT(*) FROM lenbook WHERE MID=? AND retstatus=?";
		int count=0;
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,mid);	
		System.out.println("retstatus="+retstatus);
		pstmt.setString(2,retstatus);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public boolean updatecreditno(int creditno,int num,String mid) throws SQLException {
		// TODO Auto-generated method stub
		
		//LenBook l=new LenBook();
		String sql="update member m,lenbook l set m.creditno=?,m.num=? where m.mid=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, creditno);
		pstmt.setInt(2, num);
		pstmt.setString(3,mid);
		return pstmt.executeUpdate()>0;
	}
	public boolean updateNum(int num,String mid) throws SQLException {
		// TODO Auto-generated method stub
		
		//LenBook l=new LenBook();
		String sql="update member m,lenbook l set m.num=? where m.mid=?";
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		pstmt.setString(2,mid);
		return pstmt.executeUpdate()>0;
	}
}
