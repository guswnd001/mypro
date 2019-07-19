package com.hyeon.day_07.classes;

public class Student { //class는 record와 유사하다. 여러개의 field가 record가 된다.
	
	String iName; //각각이 field이다.
	String stCode; 
	int kor;
	int mat;
	int eng;
	
	public Student() {
		super(); //
	}

	public  Student(String iName, String stCode, int kor, int mat, int eng) {
		this(); //Student(); 
		this.iName = iName; //== Student.iName
		this.stCode = stCode;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	private int sum() {
		int sTotal;
		sTotal = kor + mat + eng;
		return sTotal;		
	}
	
	public double avg() {
		double aTotal = sum()/3.0;
		aTotal = (int)(aTotal * 1000 + 0.5)/1000.0;
		return aTotal;
		
	}
	
	public void studentInfo() {
		System.out.println("학번 : " + stCode + ", 이름 : "+ iName + ", 국어 : " +
							kor + ", 수학 : " + mat + ", 영어 : " + eng);
		System.out.println("총점 : " + sum() + ",\t\t평균 : " + avg());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eng;
		result = prime * result + ((iName == null) ? 0 : iName.hashCode());
		result = prime * result + kor;
		result = prime * result + mat;
		result = prime * result + ((stCode == null) ? 0 : stCode.hashCode());
		return result;
	}
	/*
	*/
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (eng != other.eng)
			return false;
		if (iName == null) {
			if (other.iName != null)
				return false;
		} else if (!iName.equals(other.iName))
			return false;
		if (kor != other.kor)
			return false;
		if (mat != other.mat)
			return false;
		if (stCode == null) {
			if (other.stCode != null)
				return false;
		} else if (!stCode.equals(other.stCode))
			return false;
		return true;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	
}
