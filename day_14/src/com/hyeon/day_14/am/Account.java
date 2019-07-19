package com.hyeon.day_14.am;
//19번
public class Account {
	
	private static int balance; 
	final static int MIN_BALANCE = 0;
	final static int MAX_BALANCE = 1000000;
	
	public static int getBalance() {
		return balance;
	}
	public static void setBalance(int balance) {
		if (balance > MIN_BALANCE && balance <= MAX_BALANCE ) {
			Account.balance = balance;
		}
	}
	
	
	
	
	
}
