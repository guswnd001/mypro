package com.hyeon.day_14.pm;

import java.util.Scanner;

public class ArrayEx01 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("계좌번호 :");
		String ano = sc.next();
		System.out.print("계좌주 :");
		String owner = sc.next();
		System.out.println(ano + ", " +owner);
		
	}

}
