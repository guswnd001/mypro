package com.hyeon.day_07.classes;

public class MemberVO { //Value Object
	
	private String irum; //private 때문에 같은 클래스에서만 접근할 수 있다.
	private String id;
	private String pwd;
	private String email;
	private String phoneNum;
	
	public MemberVO() { //기본생성자 만들기. 생성자는 반환되는 타입이 없다.
		super();
		System.out.println("heap영역에 객체가 생성되었우");
	}
	
	public MemberVO(String irum) {
		this.irum = irum;
		}

	public String getIrum() { //값을 꺼내옴
		return irum;
	}

	public void setIrum(String irum) { //값을 집어 넣음
		//값을 변경할 수 있는 권한이 있는지 판단하는 프로그램이 여기에 들어가야 한다.
		this.irum = irum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "MemberVO [irum=" + irum + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", phoneNum=" + phoneNum
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((irum == null) ? 0 : irum.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (irum == null) {
			if (other.irum != null)
				return false;
		} else if (!irum.equals(other.irum))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	
	
	
}
