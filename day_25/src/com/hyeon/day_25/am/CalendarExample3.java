package com.hyeon.day_25.am;

import java.util.Calendar;

public class CalendarExample3 {

	public static void main(String[] args) {
		
		String iyear = "2018";
		String imonth = "11";
		int year = Integer.parseInt(iyear);
		int month = Integer.parseInt(imonth);
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 끝일
		// 월의 경우 0부터 11까지의 값을 가지므로 1을 빼줘야한다.
		// 예를 들어, 2004년 11월 1일은 sDay.set(2004, 10, 1);과 같이 해줘야 한다.
		// 입력월의 1일로 설정한다.
		sDay.set(year, month-1, 1);
		// 입력월의 말일로 설정한다.
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));
		//1일이 속한 주의 일요일로 날짜를 설정한다.
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		//말일이 속한 주의 토요일로 날짜를 설정한다.
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
		System.out.println("      " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		//시작 일부터 마지막 일까지(sDay <= eDay) 1일 증가시키면서 일(Calendar.DATE)을 출력
		for (int n = 1; sDay.before(eDay) || sDay.equals(eDay) ; sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			int mon = sDay.get(Calendar.MONTH);
			if (mon != (month-1)) 
				System.out.print("   ");
			 else 
			System.out.print((day < 10)? "  " + day : " " + day);
			if (n++%7 == 0) { //일주일 단위로 줄바꿈을 한다.
				System.out.println();
			}
		}
		
		
		
	}

}
