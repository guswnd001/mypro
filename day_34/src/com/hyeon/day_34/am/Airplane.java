package com.hyeon.day_34.am;

public class Airplane implements Comparable<Airplane>{
	private int month;
	private String company;
	private String country;
	private String sex;
	private int age;
	private String purpose;
	private String reason;
	
	public Airplane(int month, String company, int age, String sex, String country, String purpose, String reason) {
		this.month = month;
		this.company = company;
		this.country = country;
		this.age = age;
		this.sex = sex;
		this.purpose = purpose;
		this.reason = reason;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return  month + "월, 나이= " + age + "대, 성별=" + sex + ", 목적지=" + country
				+ ", 여행 목적=" + purpose + ", 관광 이유=" + reason ;
	}

	@Override
	public int compareTo(Airplane a) {
		return company.compareTo(a.company);
	}
	
	

}
