package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {

	//static은 한번만 실행. static은 하나의 저장공간만을 쓴다.
		
	private static SqlSessionFactory sqlSessionFactory;
	protected static SqlSession sqlSession;
	
	static { 
		try {
			setSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	private static void setSqlSessionFactory() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
}
