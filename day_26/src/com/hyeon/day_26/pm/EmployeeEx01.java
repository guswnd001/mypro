package com.hyeon.day_26.pm;

public class EmployeeEx01 {

	public static void main(String[] args) {

		
		
	}

}

class Employee {
	String type;
	String name;
	String address;
	String dept;
	
	public Employee(String type, String name, String address, String dept) {
		this.type = type;       this.name = name;
		this.address = address; this.dept = dept;
	}
	
	public long givePay() {
		return 0;
	}
}

class FormalEmployee extends Employee {

	long empNo;
	String position;
	long salary;
	
	public FormalEmployee(String type, String name, String address, String dept,
						  long empNo, String position, long salary) {
		super(type, name, address, dept);
		this.empNo = empNo;
		this.position = position;
		this.salary = salary;
	}
	@Override
	public long givePay() {
		return salary/12;
	}
	
}

class InformalEmployee extends Employee {

	long expireDate;
	long primaryPay;
	
	public InformalEmployee(String type, String name, String address, String dept,
							long expireDate, long primaryPay) {
		super(type, name, address, dept);
		this.expireDate = expireDate;
		this.primaryPay = primaryPay;
	}
	@Override
	public long givepay() {
		return primaryPay;
	}
	
}

class TempEmployee extends InformalEmployee {

	long timePay;
	long empTime;
	
	public TempEmployee(String type, String name, String address, String dept,
						long expireDate, long primaryPay, long timePay, long empTime) {
		super(type, name, address, dept, expireDate, primaryPay);
		this.timePay = timePay;
		this.empTime = empTime;
	}
	@Override
	public long givepay() {
		return primaryPay + (timePay * empTime);
	}
}

class InternEmployee extends InformalEmployee {

	float payRate;
	
	public InternEmployee(String type, String name, String address, String dept, 
						  long expireDate, long primaryPay, float payRate) {
		super(type, name, address, dept, expireDate, primaryPay);
		this.payRate = payRate;
	}
	@Override
	public long givepay() {
		return (long)(primaryPay * payRate);
	}
}