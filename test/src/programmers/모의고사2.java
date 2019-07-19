package programmers;

import java.util.ArrayList;
import java.util.List;

public class 모의고사2 {
	public static void main(String[] args) {
		
//		int[] answers = { 1, 2, 3, 4, 5 }; //1
//		int[] answers = { 2, 1, 2, 3, 2 }; //2,3
//		int[] answers = { 3, 3, 1, 1, 2 }; //3,2
//		int[] answers = { 1, 3, 2, 4, 2 }; //1,2,3
		int[] answers = { 2, 2, 2, 2, 2 ,2,2,2,2,2,2}; //2,1,3
		Solution3 s = new Solution3();
		int[] a = new int[answers.length];
		a = s.solution(answers);
		for (int i : a) {
			System.out.print(i + ", ");
		}
		
	}
}

class Solution3 {
	//how2 : 각 수포자들의 답을 가진 리스트를 만들어 문제수만큼 길이를 정한뒤 답과 비교후 결과 출력
    public int[] solution(int[] answers) {
    	int[][] soopo = { { 1, 2, 3, 4, 5 },
				  { 2, 1, 2, 3, 2, 4, 2, 5 },
				  { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
    	
    	int[] aCnt = { 0, 0, 0 };
    	
    	for (int i = 0; i < aCnt.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if ((soopo[i][j%(soopo[i].length)])  == answers[j]) {
					aCnt[i]++;
				}
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
    
}