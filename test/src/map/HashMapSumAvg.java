package map;

import java.util.*;
import java.util.Map.Entry;

public class HashMapSumAvg {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("김현중", new Integer(90));
		map.put("김현중", new Integer(100));
		map.put("이승주", new Integer(100));
		map.put("김주호", new Integer(80));
		map.put("조혜빈", new Integer(90));
		
		int sum = 0;
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			sum += ((Integer)entry.getValue()).intValue();
			System.out.println("이름: " + entry.getKey() + ", 점수: " + entry.getValue());
		}
		System.out.println("총점: " + sum);
		System.out.println("평균: " + (float)sum/map.size());
		System.out.println("=================================");
		
		Set<String> keySet = map.keySet();
		System.out.println("참가자 명단: " + keySet);
		
		int total = 0;
		Collection<Integer> values = map.values();
		Iterator<Integer> it2 = values.iterator();
		while (it2.hasNext()) {
			Integer i = it2.next();
			total += i;
		}
		System.out.println("총점: " + total);
		System.out.println("평균: " + (float)total/keySet.size());
		System.out.println("최고점수: " + Collections.max(values));
		System.out.println("최저점수: "+ Collections.min(values  ));
		
	}

}
