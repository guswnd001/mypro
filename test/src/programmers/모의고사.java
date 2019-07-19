package programmers;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static void main(String[] args) {
		
//		int[] answers = { 1, 2, 3, 4, 5 }; //1
//		int[] answers = { 2, 1, 2, 3, 2 }; //2,3
//		int[] answers = { 3, 3, 1, 1, 2 }; //3,2
//		int[] answers = { 1, 3, 2, 4, 2 }; //1,2,3
		int[] answers = { 2, 2, 2, 2, 2 ,2,2,2,2,2,2}; //2,1,3
		Solution2 s = new Solution2();
		int[] a = new int[answers.length];
		a = s.solution(answers);
		for (int i : a) {
			System.out.print(i + ", ");
		}
		
	}
}

class Solution2 {
	//how2 : 각 수포자들의 답을 가진 리스트를 만들어 문제수만큼 길이를 정한뒤 답과 비교후 결과 출력
    public int[] solution(int[] answers) {
    	int[][] soopo = { { 1, 2, 3, 4, 5 },
				  { 2, 1, 2, 3, 2, 4, 2, 5 },
				  { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
    	
    	List<Integer> soopo1Answers = new ArrayList<Integer>();
    	soopo1Answers = soopo1Method(answers, soopo[0], soopo1Answers);
    	
    	List<Integer> soopo2Answers = new ArrayList<Integer>();
    	soopo2Answers = soopo2Method(answers, soopo[1], soopo2Answers);
    	
    	List<Integer> soopo3Answers = new ArrayList<Integer>();
    	soopo3Answers = soopo3Method(answers, soopo[2], soopo3Answers);
    	
    	
    	int[] aCnt = { 0, 0, 0 };
    	
    	for (int i = 0; i < answers.length; i++) {
			if (answers[i] == soopo1Answers.get(i)) {
				aCnt[0]++;
			}
		}
    	for (int i = 0; i < answers.length; i++) {
    		if (answers[i] == soopo2Answers.get(i)) {
    			aCnt[1]++;
    		}
    	}
    	for (int i = 0; i < answers.length; i++) {
    		if (answers[i] == soopo3Answers.get(i)) {
    			aCnt[2]++;
    		}
    	}
    	
    	if ( (aCnt[0] == aCnt[1]) && (aCnt[1] == aCnt[2]) ) { //점수가 다 같을 때
			int[] answer = { 1, 2, 3 };
			return answer;
		} else { //점수가 다 다를때
			int sCnt = 0;
			for (int i = 0; i < aCnt.length; i++) {
				if (aCnt[i] != 0) {	sCnt++;	}
			}
			int[] answer = new int[sCnt];
			int chk = 0;
			for (int i = 0; i < aCnt.length; i++) {
				if (aCnt[i] != 0) {	
					answer[chk] = aCnt[i];	
					chk++;
				}
			}
			for (int i = 0; i < answer.length-1; i++) {
				if (answer[i] < answer[i+1]) {
					chk = answer[i];
					answer[i] = answer[i+1];
					answer[i+1] = chk;
				}
			}
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < aCnt.length; j++) {
					if (answer[i] == aCnt[j]) {
						answer[i] = j+1;
						aCnt[j] += 1;
						break;
					}
				}
			}
			
			return answer;
		}
    	
    }
    
    public List<Integer> soopo1Method(int[] a, int[] s, List<Integer> sa) {
    	int repeat = a.length / s.length;
    	if (repeat != 0) {
    		for (int i = 0; i < repeat; i++) {
    			for (int j = 0; j < 5; j++) { 
    				sa.add(s[j]); 
    			}
    		}
		}
    	int rmd = a.length % s.length;
    	if ( rmd != 0) {
			for (int i = 0; i < rmd; i++) { 
				sa.add(s[i]); 
			}
		}
		return sa; }
    
    public List<Integer> soopo2Method(int[] a, int[] s, List<Integer> sa) {
    	int repeat = a.length / s.length;
    	if (repeat != 0) {
    		for (int i = 0; i < repeat; i++) {
    			for (int j = 0; j < 8; j++) { sa.add(s[j]);	}
    		}
		}
    	int rmd = a.length % s.length;
    	if ( rmd != 0) {
			for (int i = 0; i < rmd; i++) {	sa.add(s[i]); }
		}
    	return sa; }
    
    public List<Integer> soopo3Method(int[] a, int[] s, List<Integer> sa) {
    	int repeat = a.length / s.length;
    	if (repeat != 0) {
    		for (int i = 0; i < repeat; i++) {
    			for (int j = 0; j < 10; j++) { sa.add(s[j]); }
    		}
		}
    	int rmd = a.length % s.length;
    	if ( rmd != 0) {
			for (int i = 0; i < rmd; i++) {	sa.add(s[i]); }
		}
    	return sa; }
    
}