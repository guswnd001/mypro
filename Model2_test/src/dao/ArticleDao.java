package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp2.PStmtKey;

import jdbc.JdbcUtil;
import model.Article;
import model.Writer;

public class ArticleDao {

	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"insert into article (writer_id, writer_name, title, regdate, moddate, read_cnt)"
					+ "values (?,?,?,?,?,0)");
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();
			
			System.out.println(insertedCount);
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from article");
				
				if (rs.next()) {
					int newNo = rs.getInt(1);
					return new Article(newNo, 
							article.getWriter(), 
							article.getTitle(), 
							article.getRegDate(), 
							article.getModifiedDate(), 0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from article");
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from article order by article_no desc limit ? ,?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			
			List<Article> result = new ArrayList<Article>();
			
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from article where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			Article article = null;
			
			if (rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		} finally {

		}
	}
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("update article set read_cnt = read_cnt + 1 "
									   + "where article_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update article set title = ?, moddate = now() " +
				"where article_no = ?")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			
			return pstmt.executeUpdate();
		}
	}
	
	public int delete(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"delete from article where article_no = ?")) {
			pstmt.setInt(1, no);
			
			return pstmt.executeUpdate();
		}
	}
	
	
	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"),
				new Writer(rs.getString("writer_id"), rs.getString("writer_name")),
				rs.getString("title"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
	}
	
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
}
