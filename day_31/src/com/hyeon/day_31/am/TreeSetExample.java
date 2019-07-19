package com.hyeon.day_31.am;

import java.util.*;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));//**
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));
		
		//내림차순
		NavigableSet<Integer> descendingSet = scores.descendingSet(); //점수를 내림차순 메소드로 Set을 만듬
		for (Integer score : descendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
		
		//오름차순
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet(); //내림차순Set을 다시 내림차순 메소드로 오름차순을 만듬
		for (Integer score : ascendingSet) {
			System.out.print(score + " ");
		}
		
	}

}
