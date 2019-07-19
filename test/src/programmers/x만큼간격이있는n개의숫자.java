package programmers;

public class x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.solution(2, 5));
		s.solution(-4, 2);
	}

}

class Solution {
	public long[] solution(int x, int n) {

		long[] answer = new long[n];
		answer[0] = x;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i-1] + x;
		}
		return answer;
	}
}
