package com.hyeon.day_24.pm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) {
		
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(now);
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		System.out.println("from String to Date");
		String tem = "2018년 05월 05일 04시 20분 20초";
		try {
			Date d1 = sdf.parse(tem);
			System.out.println(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}
