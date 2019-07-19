package 자릿수더하기;

public class 자릿수더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int answer = 0;
		int n = 987;
		
		while (n != 0) {
			answer += n % 10;
			n /= 10;
		}
		
		System.out.println(answer);
		
	}

}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int length = (int) Math.log10(n) + 1;

        return answer;
    }
}