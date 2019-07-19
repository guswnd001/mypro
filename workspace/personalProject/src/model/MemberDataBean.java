package model;

import java.sql.Timestamp;

public class MemberDataBean {

	private String name;
	private String birth;
	private String id;
	private String password;
	private String email;
	private String tel1;
	private String tel2;
	private String tel3;
	private String address1;
	private String address2;
	private int zipcode;
	private Timestamp reg_date;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	
	@Override
	public String toString() {
		return "MemberDataBean [name=" + name + ", birth=" + birth + ", id=" + id + ", password=" + password
				+ ", email=" + email + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", address1=" + address1
				+ ", address2=" + address2 + ", zipcode=" + zipcode + ", reg_date=" + reg_date + "]";
	}
	
}