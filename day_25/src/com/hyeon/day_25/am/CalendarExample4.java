package com.hyeon.day_25.am;

import java.util.Calendar;

public class CalendarExample4 {

	public static void main(String[] args) {

		String iyear = "2018";

		for (int i = 1; i < 2; i += 1) {
			prtCalendar(iyear, i);
		}

	}

	public static void prtCalendar(String iyear, int month) {
		int year = Integer.parseInt(iyear);
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 끝일

		System.out.print("       " + year + "년 " + month + "월                     ");
		System.out.print("       " + year + "년 " + (month + 1) + "월                    ");
		System.out.println("       " + year + "년 " + (month + 2) + "월");
		System.out.print(" SU MO TU WE TH FR SA  ");
		System.out.print(" SU MO TU WE TH FR SA  ");
		System.out.println(" SU MO TU WE TH FR SA  ");

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 3; i++) {
				sDay.set(year, (month + i) - 1, 1);
				eDay.set(year, (month + i) - 1, sDay.getActualMaximum(Calendar.DATE));
				sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
				eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
				for (int n = 1 ; n < 8; sDay.add(Calendar.DATE, 1)) {
					int day = sDay.get(Calendar.DATE);
					int mon = sDay.get(Calendar.MONTH);
					if (mon != ((month + i) - 1)) {
						System.out.print("  /");
					} else {
						System.out.print((day < 10) ? "  " + day : " " + day);
					}
					if (n++ % 8 == 0) {
						System.out.println();
					}
				}
				System.out.print("  ");
			}
		}

	}
}
