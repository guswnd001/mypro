package programmers;

public class 하샤드수 { // 각 자리수의 합으로 나누어지는 수

	public static void main(String[] args) {
		// true
		int a = 10;
		int b = 12;
		// false
		int c = 11;
		int d = 13;

//		System.out.println(solution(c));
		solution(a);
		solution(b);
		solution(c);
		solution(d);
	}

	public static boolean solution(int x) {
		boolean answer;
		int xCopy = x;
		int xLength = (int) (Math.log10(x));
		int sum = 0;
		for (int i = xLength; i >= 0; i--) {
			sum += xCopy / (int) Math.pow(10, i);
			xCopy = xCopy % (int) Math.pow(10, i);
		}
		
		if ((x % sum) == 0) {
			System.out.println("하샤드 수가 맞습니다.");
			return answer = true;
		} else {
			System.out.println("하샤드 수가 아닙니다.");
			return answer = false;
		}
	}

}
