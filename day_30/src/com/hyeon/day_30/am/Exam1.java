package com.hyeon.day_30.am;

import java.util.*;

public class Exam1 {

	public static void main(String[] args) {
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 5명의 점수를 입력하세요.");
		
		for (int i = 0; i < 5; i++) {
			list.add(scan.nextInt());
		}
		System.out.println("최대값의 인덱스: " + list.indexOf(Collections.max(list)));
		Collections.sort(list);
		
		for (Integer i : list) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println("\n중간값: " + list.get(2) + " 평균값: " + (double)sum/list.size());
		
	}

}
