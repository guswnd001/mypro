package com.hyeon.day_22.am;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		//Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		//HashMap은 jdk에서 제공하는 클래스
		Key k1 = new Key(1);
		Key k2 = new Key(1);
		Key k3 = new Key(1);
		
		//식별기 "new Key(1)"로 "홍길동"을 저장함
		hashMap.put(k1, "홍길동");
		hashMap.put(k2, "임꺽정");
		hashMap.put(k3, "aaa");
		
		//식별키 "new Key(1)"로 "홍길동"을 읽어옴
		String value1 = hashMap.get(k1);
		String value2 = hashMap.get(k2);
		String value3 = hashMap.get(k3);
		System.out.println(k1.hashCode());
		System.out.println(k2.hashCode());
		System.out.println(k3.hashCode());
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		System.out.println("value3 : " + value3);
		System.out.println(k1.toString());
		
		Object obj = new Object();
		System.out.println(obj);
		System.out.println(obj.hashCode());
		
	}

}
