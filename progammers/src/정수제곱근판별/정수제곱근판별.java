package 정수제곱근판별;

public class 정수제곱근판별 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int n = 625;
//		int numchk = 1;
//		if (n >= 10) {
//			numchk = (int) Math.log10(n);
//		}
//		int start = (int) Math.pow(10, numchk - 1);
//		int end = (int) Math.pow(10, numchk);
//
//		System.out.println(numchk);
//		System.out.println(start);
//		System.out.println(end);
//		System.out.println("================");
//
//		for (int i = start; i < end; i++) {
//			if ((n / (double) i) == (double) i) {
//				answer = (long) Math.pow(i + 1, 2);
//			}
//		}
//		System.out.println(answer);

//		Solution s = new Solution();
//		System.out.println(s.solution(3));

		long n = 625;
		long answer = 0;
		int x = (int) Math.sqrt(n);
		answer = (Math.pow(x, 2) == n)? (long) Math.pow(x + 1, 2) : -1;
		System.out.println(answer);
	}
	

}

class Solution {
	public long solution(long n) {
		long answer = -1;
		int numchk = 1;
		if (n >= 10) {
			numchk = (int) Math.log10(n);
		}
		int start = (int) Math.pow(10, numchk - 1);
		int end = (int) Math.pow(10, numchk);

		for (int i = start; i < end; i++) {
			if ((n / (double) i) == (double) i) {
				answer = (long) Math.pow(i + 1, 2);
			}
		}
		return answer;
	}
}