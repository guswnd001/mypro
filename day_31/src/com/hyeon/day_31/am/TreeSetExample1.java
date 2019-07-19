package com.hyeon.day_31.am;

import java.util.*;

public class TreeSetExample1 {

	public static void main(String[] args) {
//		TreeSet<Integer> scores = new TreeSet<Integer>();
//		scores.add(new Integer(87));
//		scores.add(new Integer(98));
//		scores.add(new Integer(75));
//		scores.add(new Integer(95));
//		scores.add(new Integer(80));
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("가장 낮은 점수: " + score);
		
		score = scores.last();
		System.out.println("가장 높은 점수: " + score + "\n");
		
		score = scores.lower(new Integer(95));
		System.out.println("95점 아래 점수: " + score);
		
		score = scores.higher(new Integer(95));
		System.out.println("95점 위의 점수: " + score);
		
		score = scores.floor(new Integer(95));
		System.out.println("95점 이하 점수: " + score);
		
		score = scores.ceiling(new Integer(85));
		System.out.println("85점 이상 점수: " + score);
		
		while (!scores.isEmpty()) { //비어있지 않으면 계속 루핑
			score = scores.pollFirst(); //제일 낮은 객체를 꺼내오고 콜렉션에서 제거함
			System.out.println(score + "(남은 객체 수: " + scores.size() + ")");
		}

	}

}
