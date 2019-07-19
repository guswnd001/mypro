package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.MemberDao;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import exception.DuplicateIdException;
import model.JoinRequest;
import model.Member;

public class JoinService {

	private MemberDao memberDao = new MemberDao(); 
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn,
					new Member(joinReq.getId(), 
							   joinReq.getName(), 
							   joinReq.getPassword(),
							   new Date()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
