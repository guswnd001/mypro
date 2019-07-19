package programmers;

public class 콜라츠추측 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution(6));
		System.out.println(s.solution(16));
		System.out.println(s.solution(626331));
	}

}

class Solution1 {
	public int solution(long num) {
		int answer = 0;
		while ((answer < 500) && (num != 1)) {
			num = (num % 2 == 0)? num / 2 : num * 3 + 1;
			answer++;
		}
		return (answer == 500)? -1 : answer;
	}
}
