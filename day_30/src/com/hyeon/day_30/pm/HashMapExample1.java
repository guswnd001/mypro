package com.hyeon.day_30.pm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {

	public static void main(String[] args) {
		// Map 콜렉션 생성
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 객체 저장
		map.put("김현중", 90);
		map.put("이승주", 85);
		map.put("김주호", 80);
		map.put("이승주", 95); //"이승주" 키가 같기에 제일 마지막에 저장된 값이 최종값
		System.out.println("총 Entry 수: " + map.size()); //저장된 총 Entry 수 얻기

		// 객체 찾기
		System.out.println("\t이승주" + map.get("이승주")); //이름(키)로 점수(값)을 검색
		System.out.println();

		// 객체를 하나씩 처리
		Set<String> keySet = map.keySet(); //KeySet 얻기
		//반복자를 만들어 키를 얻고 값을 Map에서 얻어냄
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();

		// 객체 삭제
		map.remove("이승주"); //키로 Map.Entry를 제거
		System.out.println("총 Entry 수: " + map.size());

		// 객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); //Map.EntrySet 얻기
		//반복자를 만들어 Map.Entry를 얻고 키와 값을 얻어냄
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		//객체 전체 삭제
		map.clear(); //모든 Entry 삭제
		System.out.println("총 Entry 수: " + map.size());
	}

}
