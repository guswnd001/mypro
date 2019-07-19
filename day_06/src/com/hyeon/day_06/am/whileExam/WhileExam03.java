package com.hyeon.day_06.am.whileExam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WhileExam03 {

	public static void main(String[] args) {
	
		Set<String> setData = new HashSet<String>();
		
		setData.add("heonjoong1");
		setData.add("heonjoong2");
		setData.add("heonjoong3");
		setData.add("heonjoong4");
		setData.add("heonjoong3");
		setData.add("joong"); //set은 중복되는 것은 제거, 순서대로 꺼내오지 않는다.
		
		Iterator<String> iter = setData.iterator(); //set에 있는 데이터를 꺼내는 작업
		int cnt = 0;
		
//		while (iter.hasNext()) { //조건에 메소드가 들어간다. 반복할지 안할지를 결정한다.
//			cnt++;
//			System.out.println(cnt);
//			System.out.println(iter.next());
//		}
		System.out.println("=================================");
				
		for (int i = 0; iter.hasNext() ; i++) { //위의 while문과 동일하다.
			cnt++;
			System.out.println(cnt);
			System.out.println(iter.next());
		}
		
	}
}
