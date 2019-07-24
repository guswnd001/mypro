package session;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Comment;

public class CommentSessionRepository {
	
	private final String namespace = "mapper.CommentMapper";
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectCommentByCondition", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
	public Comment selectCommentByPrimaryKey(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectOne(namespace + ".selectCommentByPrimaryKey", commentNo); 
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".insertComment";
			int result = sqlSession.insert(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".updateComment";
			int result = sqlSession.update(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteComment(long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".deleteComment";
			int result = sqlSession.delete(statement, commentNo);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateCommentIf(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".updateCommentIf";
			int result = sqlSession.update(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionIf(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectCommentByConditionIf", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateCommentTrim(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".updateCommentTrim";
			int result = sqlSession.update(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionChoose(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectCommentByConditionChoose", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionTrim(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectCommentByConditionTrim", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionForeach(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectCommentByConditionForeach", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectOgnlStaticMethod() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectOgnlStaticMethod"); 
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectOgnlStaticField() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectOgnlStaticField"); 
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectOgnlStaticMethod2(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			return sqlSession.selectList(namespace + ".selectOgnlStaticMethod2", condition); 
		} finally {
			sqlSession.close();
		}
	}
	
}
