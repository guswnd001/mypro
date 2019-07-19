package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.BoardDataBean;

public class BoardDBBeanMysql {

	private static BoardDBBeanMysql instance = new BoardDBBeanMysql();
	
	public static BoardDBBeanMysql getInstance() { return instance; }
	
	private BoardDBBeanMysql() { }
	
	private Connection getConnection() throws Exception {
		Connection conn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/jspdb";
		String dbId = "scott";
		String dbPass = "1111";
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		return conn;
	}
	
	public void insertArticle(BoardDataBean article, String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(article);
		
		int number = 0; //글번호 가지고 ref 값을 할당하려고
		int num = article.getNum(); //글 번호
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
				
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select ifnull(max(num),0) from board");
			rs = pstmt.executeQuery();
			if (rs.next()) { number = rs.getInt(1) + 1; }
			else { number = 1; }
			
			if (num != 0) {
				
				String sql = "update BOARD set re_step = re_step + 1 "
							+ "where ref = ? and re_step > ? and boardid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.setString(3, boardid);
				pstmt.executeUpdate();
				
				re_step = re_step + 1;
				re_level = re_level  + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			pstmt = conn.prepareStatement(
					"insert into BOARD values (?,?,?,?,?,?,now(),0,?,?,?,?,?,?,?)");
			pstmt.setInt(1, number);
			pstmt.setString(2, boardid);
			pstmt.setString(3, article.getWriter());
			pstmt.setString(4, article.getSubject());
			pstmt.setString(5, article.getEmail());
			pstmt.setString(6, article.getPasswd());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			pstmt.setString(10, article.getContent());
			pstmt.setString(11, article.getIp());
			pstmt.setString(12, article.getFilename());
			pstmt.setInt(13, article.getFilesize());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
	}
	
	public int getArticleCount(String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select ifnull(count(*), 0) from BOARD where boardid=?");
			pstmt.setString(1,  boardid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		
		return x;
	}
	
	public List<BoardDataBean> getArticles(int start, int pageSize, String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDataBean> li = null;
		BoardDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select * from BOARD where boardid = ? order by ref desc, re_step "
					+ "limit ?, ?");
			pstmt.setString(1, boardid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				li = new ArrayList<BoardDataBean>(); // array : 중복 허용/ set : 중복 불가
				do {
					article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setBoardid(boardid);
					article.setWriter(rs.getString("writer"));
					article.setSubject(rs.getString("subject"));
					article.setEmail(rs.getString("email"));
					article.setPasswd(rs.getString("passwd"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_level(rs.getInt("re_level"));
					article.setRe_step(rs.getInt("re_step"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					article.setFilename(rs.getString("filename"));
					article.setFilesize(rs.getInt("filesize"));
					
					li.add(article);
				} while (rs.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		
		return li;
	}
	
	public BoardDataBean getArticle(int num, String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(
					"update BOARD set readCount = readCount + 1 where boardid = ? and num = ?");
			pstmt.setString(1, boardid);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(
					"select * from BOARD where boardid = ? and num = ?");
			pstmt.setString(1, boardid);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setBoardid(boardid);
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setEmail(rs.getString("email"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_level(rs.getInt("re_level"));
				article.setRe_step(rs.getInt("re_step"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				article.setFilename(rs.getString("filename"));
				article.setFilesize(rs.getInt("filesize"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		
		return article;
	}
	
	public BoardDataBean getUpdate(int num, String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from BOARD where num = ? and boardid = ?");
			pstmt.setInt(1, num);
			pstmt.setString(2, boardid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				article = new BoardDataBean();
				article.setNum(num);
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setEmail(rs.getString("email"));
				article.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		
		return article;
	}
	
	public int updateArticle(BoardDataBean article, String boardid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from BOARD where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("passwd");
				
				if (dbpassword.equals(article.getPasswd())) {
					pstmt = conn.prepareStatement(
							"update BOARD set writer=?, subject=?, email=?, content=?"
							+ " where num = ?");
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getSubject());
					pstmt.setString(3, article.getEmail());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeUpdate(); //DML(select 제외)을 할때 쓰는 메소드
					x = 1;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		return x;
	}
	
	public int deleteArticle(int num, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from BOARD where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("passwd");
				
				if (dbpassword.equals(passwd)) {
					pstmt = conn.prepareStatement("delete from BOARD where num = ?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate(); //DML(select 제외)을 할때 쓰는 메소드
					x = 1;
				} else { x = 0; }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		System.out.println(x);
		return x;
	}
}
