package com.neusoft.util;

import java.sql.Connection;
import java.sql.PreparedStatement;



/**
 * 方便之後不用寫後面的connection preparestatement這些對象，提供了
 * 構造方法，方便获取对象
 * @author x_q_k
 *
 */
public abstract class AbstractDAOImpl {
	protected Connection conn;
	protected PreparedStatement pstmt;
	
	public AbstractDAOImpl(Connection conn)
	{
		this.conn=conn;
	}

}
