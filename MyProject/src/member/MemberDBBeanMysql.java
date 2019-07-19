package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDBBeanMysql {

	private static MemberDBBeanMysql instance = new MemberDBBeanMysql();
	
	public static MemberDBBeanMysql getInstance() { return instance; }
	
	private MemberDBBeanMysql() { } 
	/*싱글톤: 하나 밖에 없는 생성자를 private로 접근제한자를  둔 것.
			 외부에서 생성자에 접근할 수 없기 때문에 메모리를 효율적으로 쓸 수 있다.*/
	
	private Connection getConnection() throws Exception {
		Connection conn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/jspdb";
		String dbId = "scott";
		String dbPass = "1111";
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		return conn;
	}
	
	public void insertMember(MemberDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(member);
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MEMBER values (?,?,?,?,?,?,?,now())");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getJumin1());
			pstmt.setString(5, member.getJumin2());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getBlog());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
	
	}
	
	public int userCheck(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문을 쓸 때 쓰는 생성자
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select password from member where id=?");
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("password");
				
				if (dbpassword.equals(password)) {	x = 1;	} 
				else {	x = 0;	}
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
	
	public MemberDataBean getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDataBean member = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberDataBean();
				member.setId(id);
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("jumin2"));
				member.setEmail(rs.getString("email"));
				member.setBlog(rs.getString("blog"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		
		return member;
	}
	
	public void updateMember(MemberDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(member);
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update MEMBER set name = ?, email = ?, blog = ? where id = ?");
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getBlog());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate(); //DML을 할때 쓰는 메소드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { }
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
	}
	
	public int deleteMember(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select password from MEMBER where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("password");
				
				if (dbpassword.equals(password)) {
					pstmt = conn.prepareStatement("delete from MEMBER where id = ?");
					pstmt.setString(1, id);
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
	
	public List<MemberDataBean> getMemberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List li = null;
		MemberDataBean member = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				li = new ArrayList<MemberDataBean>();
				do {
					member = new MemberDataBean();
					member.setId(rs.getString("id"));
					member.setPassword(rs.getString("password"));
					member.setName(rs.getString("name"));
					member.setJumin1(rs.getString("jumin1"));
					member.setJumin2(rs.getString("jumin2"));
					member.setEmail(rs.getString("email"));
					member.setBlog(rs.getString("blog"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					
					li.add(member);
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
	
}
