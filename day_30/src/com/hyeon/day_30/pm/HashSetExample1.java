package com.hyeon.day_30.pm;

import java.util.*;

public class HashSetExample1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java"); //중복된 값은 한번만 저장됨
		set.add("iBATIS");
		
		int size = set.size(); //저장된 객체 수 얻기
		System.out.println("총 객체수: " + size);
		
		//반복자
		Iterator<String> iterator = set.iterator(); //반복자 얻기
		while (iterator.hasNext()) { //객체 수만큼 루핑
			String element = iterator.next(); //한 개의 객체를 가져온다
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC"); //한 개의 객체 삭제
		set.remove("iBATIS"); //한 개의 객체 삭제
		
		System.out.println("총 객체수: " + set.size()); //저장된 객체 수 얻기
		
		iterator = set.iterator(); //반복자 얻기
		for (String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear(); //모든 객체를 제거하고 비움
		if (set.isEmpty()) {
			System.out.println("비어 있음");
		}
	}

}
