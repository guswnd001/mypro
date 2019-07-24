package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.MybatisConfig;

public class BoardDBBeanMybatis  {

	private final String namespace = "mybatis.board";
	
	//싱글톤 생성 시작//
	private BoardDBBeanMybatis() { }
	
	private static BoardDBBeanMybatis instance = new BoardDBBeanMybatis();
	
	public static BoardDBBeanMybatis getInstance() { return instance; }
	//싱글톤 생성 끝//
	
	SqlSession sqlSession;
	
	private SqlSession sqlSession() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream).openSession();
	}
	
	public SqlSession getSession() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	public int getArticleCount(String boardid) throws Exception {
		SqlSession sqlSession = getSession();
		System.out.println("getArticleCount===old");
		
		try {
			return sqlSession.selectOne(namespace + ".getArticleCount", boardid);
		} finally {
			sqlSession.close();
		}
	}
	
	public List getArticles(int start, int end, String boardid) throws Exception {
		SqlSession sqlSession = getSession();
		System.out.println("getArticles===old");
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("boardid", boardid);
		
		try {
			return sqlSession.selectList(namespace + ".getArticles", map);
		} finally {
			sqlSession.close();
		}
	}
	
}
