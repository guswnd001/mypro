package com.hyeon.day_31.am;

import java.util.*;

public class TreeSetExample3 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		treeSet.add("f");
		treeSet.add("c");
		System.out.println(treeSet);
		System.out.println("[c ~ f 사이의 단어 검색]");
		//subSet: 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴.
		//시작과 끝 객체를 포함 여부는 두번째, 네번째 매개값에 따라 달라짐.
		NavigableSet<String> rangeSet = treeSet.subSet("c", false, "f", false); //**
		for (String word : rangeSet) {
			System.out.println(word);
		}
	}

}
