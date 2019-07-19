package samsung;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static void main(String[] args) {

//		int[] answers = { 1, 2, 3, 4, 5 }; //1
		int[] answers = { 2, 1, 2, 3, 2 }; //2,3
//		int[] answers = { 3, 3, 1, 1, 2 }; //3,2
//		int[] answers = { 1, 3, 2, 4, 2 }; //1,2,3
//		int[] answers = { 2, 2, 2, 2, 2 ,2,2,2,2,2,2}; //2,1,3
		int[] a = new int[answers.length];
		Solution s = new Solution();
		a = s.solution(answers);
		for (int i : a) {
			System.out.print(i + ", ");
		}

	}
}

class Solution {

	public int[] solution(int[] answers) {

		int[][] soopo = { { 1, 2, 3, 4, 5 },
						  { 2, 1, 2, 3, 2, 4, 2, 5 },
						  { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] answerCnt = { 0, 0, 0 };
		for (int i = 0; i < answerCnt.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if ((soopo[i][j%(soopo[i].length)])  == answers[j]) {
					answerCnt[i]++;
				}
			}
		}
		
		int max = Math.max(answerCnt[0], Math.max(answerCnt[1], answerCnt[2]));
		List<Integer> list = new ArrayList<Integer>();
		if (answerCnt[0] == answerCnt[1] && answerCnt[1] == answerCnt[2]) {
			for (int i = 0; i < answerCnt.length; i++) {
				list.add(i + 1);
			}
		} else {
			for (int i = 0; i < answerCnt.length; i++) {
				if (max == answerCnt[i]) {
					list.add(0, i + 1);
				} else if (answerCnt[i] != 0){
					list.add(i + 1);
				}
			}
		}
			
		int[] answer = new int[list.size()];
		int cnt = 0;
		for (int i : list) {
			answer[cnt++] = i;
		}
		return answer;
	}
}