package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MemberDataBean;

public class MemberDBBeanMysql {
	
	private static MemberDBBeanMysql instance = new MemberDBBeanMysql();
	
	public static MemberDBBeanMysql getInstance() {
		return instance;
	}
	
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
			pstmt = conn.prepareStatement(
					"insert into MEMBER_LIBIDO values (?,?,?,?,?,?,?,?,?,?,?,now())");
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getId());
			pstmt.setString(4, member.getPassword());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getTel1());
			pstmt.setString(7, member.getTel2());
			pstmt.setString(8, member.getTel3());
			pstmt.setString(9, member.getAddress1());
			pstmt.setString(10, member.getAddress2());
			pstmt.setInt(11, member.getZipcode());
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
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select password from MEMBER_LIBIDO where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("password");
				
				if (dbpassword.equals(password)) { x = 1; }
				else { x = 0; }
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
			pstmt = conn.prepareStatement("select * from MEMBER_LIBIDO where id=?");
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberDataBean();
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setId(id);
				member.setEmail(rs.getString("email"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setZipcode(rs.getInt("zipcode"));
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
					"update MEMBER_LIBIDO "
					+ "set password = ?, email = ?, tel1 = ?, tel2 = ?, tel3 = ?, address1 = ?, address2 = ?, zipcode = ? "
					+ "where id = ?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getTel1());
			pstmt.setString(4, member.getTel2());
			pstmt.setString(5, member.getTel3());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setInt(8, member.getZipcode());
			pstmt.setString(9, member.getId());
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
			pstmt = conn.prepareStatement("select password from MEMBER_LIBIDO where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbpassword = rs.getString("password");
				
				if (dbpassword.equals(password)) {
					pstmt = conn.prepareStatement("delete from MEMBER_LIBIDO where id = ?");
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
			pstmt = conn.prepareStatement("select * from MEMBER_LIBIDO");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				li = new ArrayList<MemberDataBean>();
				do {
					member = new MemberDataBean();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setBirth(rs.getString("birth"));
					member.setEmail(rs.getString("email"));
					member.setTel1(rs.getString("tel1"));
					member.setTel2(rs.getString("tel2"));
					member.setTel3(rs.getString("tel3"));
					member.setAddress1(rs.getString("address1"));
					member.setAddress2(rs.getString("address2"));
					member.setZipcode(rs.getInt("zipcode"));
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
	
	public List<String> getId() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = null;
		MemberDataBean member = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from MEMBER_LIBIDO");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				list = new ArrayList<String>();
				do {
					member = new MemberDataBean();
					
					member.setId(rs.getString("id"));
					
					list.add(member.getId());
				} while (rs.next());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException ex) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) { } 
			if (conn != null) try { conn.close(); } catch (SQLException ex) { }
		}
		System.out.println(list);
		return list;
	}
	
}
