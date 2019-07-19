package model;

import java.util.Date;

public class Member {
	
	private String id;
	private String name;
	private String password;
	private Date regdate;
	
	
	public Member(String id, String name, String password, Date regdate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	/////////////////////////////////////////////////////////////////////
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	///////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", regdate=" + regdate + "]";
	}
	
}
