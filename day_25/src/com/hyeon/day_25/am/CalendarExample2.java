package com.hyeon.day_25.am;

import java.util.Calendar;

public class CalendarExample2 {

	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
		date.set(2019,	2,	26);
		System.out.println(toString(date));
		
	}

	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " 
				+ (date.get(Calendar.MONTH) + 1) + "월 " 
				+ date.get(Calendar.DATE) + "일";
	}

}
