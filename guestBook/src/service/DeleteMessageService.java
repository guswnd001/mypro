package service;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionProvider;
import connection.JdbcUtil;
import dao.MessageDao;
import exception.InvalidPassowrdException;
import exception.MessageNotFoundException;
import exception.ServiceException;
import model.Message;

public class DeleteMessageService {

	private static DeleteMessageService instance = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() { return instance; }
	
	private DeleteMessageService() { }
	
	public void  deleteMessage(int messageId, String password) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false); //기본은 true, rollback을 사용하기 위해 의도적으로 막아놓았다.
			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			
			if (message == null) {
				throw new MessageNotFoundException("메세지 없음"); 
			}
			
			if (!message.matchPassword(password)) {
				throw new InvalidPassowrdException("bad password!");
			}
			
			messageDao.delete(conn, messageId);
			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn); //문제가 생길시 rollback을 해라.
			throw new ServiceException("삭제 실패: " + ex.getMessage(), ex);
		} catch (InvalidPassowrdException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
