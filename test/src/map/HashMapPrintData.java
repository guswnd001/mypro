package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapPrintData {

	public static void main(String[] args) {
		
		String[] data = { "A", "K", "A", "K", "D" };
		
		HashMap map = new HashMap();
		
		for (int i = 0; i < data.length; i++) {
			if (map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], value.intValue() + 1);
			} else {
				map.put(data[i], new Integer(1));
			}
		}
//		System.out.println(map);
		
		//<Map메소드> .entrySet(): 키와 값의 쌍으로 구성된 모든 Map.Entry객체를 Set에 담아 리턴
		//<Set메소드> .iterator(): Set에 저장된 객체를 한번씩 가져오는 반복자 리턴
		Iterator it = map.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
	}
	
	public static String printBar(char c, int i) {
		char[] bar = new char[i];
		
		for (int j = 0; j < bar.length; j++) {
			bar[j] = c;
		}
		return new String(bar); //String(char[] chArr)
	}

}
