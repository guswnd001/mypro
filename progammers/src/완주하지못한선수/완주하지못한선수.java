package 완주하지못한선수;

import java.util.Arrays;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		
//		String[] completion = { "eden", "kiki" };
//		String[] participant = { "leo", "kiki", "eden" };
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "stanko", "mislav", "ana" };
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		
		String answer = "";
		int parLen = participant.length; 
		int[] check = new int[parLen];
		
		Arrays.sort(completion);
		Arrays.sort(participant);
		
		for (int i = 0; i < participant.length; i++) {
			if (completion[i].equals(participant[i])) { check[i]++;}
		}
		
		for (int i : check) {
			System.out.println(i);
		}
		
		System.out.println(answer);
		
		
		
	}

}
