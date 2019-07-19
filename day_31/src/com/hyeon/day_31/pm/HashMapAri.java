package com.hyeon.day_31.pm;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class HashMapAri {
	static HashMap<String, Map<String, String>> act
		= new HashMap<String, Map<String,String>>();
	
	public static void main(String[] args) {
		act.put("메일", new HashMap<String, String>());
		act.put("알람", new HashMap<String, String>());
		act.put("노래", new HashMap<String, String>());
		act.put("먹어", new HashMap<String, String>());
		act.put("몇시", new HashMap<String, String>());
		act.put("시간", new HashMap<String, String>());
		act.put("티비", new HashMap<String, String>());
		
		
		act.get("메일").put("현중", "에게 메일을 보냈습니다.");
		act.get("메일").put("승주", "에게 메일을 보냈습니다.");
		act.get("알람").put("한 시", "알람을 맞추었습니다.");
		act.get("알람").put("두 시", "알람을 맞추었습니다.");
		act.get("노래").put("애국가", " : 동해물과~");
		act.get("노래").put("송아지", " : 송아지~");
		act.get("먹어").put("사과", " : 앙~ 맛있어");
		act.get("먹어").put("순두부", " : 이건 먹기 싫어~");
		act.get("티비").put("켜", " : 티비를 켰습니다.");
		act.get("티비").put("꺼", " : 티비를 껐습니다.");
		act.get("몇시").put("몇시", " : 입니다.");
		act.get("시간").put("시간", " : 입니다.");
		
		String input;
		while (true) {
			input = JOptionPane.showInputDialog(null, "명령어를 입력하세요");
			System.out.println();
			boolean actchk = false;
			boolean resoursechk = false;
			
			if (input.startsWith("아리야")) {
				Set<String> set = act.keySet();
				for (String key : set) {
					actchk = true;
					Set<String> rset = act.get(key).keySet();
					for (String rkey : rset) {
						if (input.contains(rkey)) {
							resoursechk = true;
							System.out.println(rkey + act.get(key).get(rkey));
							break;
						}
					}
					if (key.equals("몇시") || key.equals("시간")) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd일 hh시/mm분/ss초");
						System.out.println(df.format(new Date()) + act.get(key).get("시간"));
					} else if (!resoursechk) {
						System.out.println(key + " 자료가 없습니다.");
						break;
					}
				} 
				if (!actchk) 
					System.out.println("무슨말인지 모르겠습니다.");
				} else {
					System.out.println(".....&_&");
				}
			}
		}
		
	}

