package 이천십육년;

public class 이천십육년 {

	public static void main(String[] args) {
		
		String answer = "";
//		String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int a = 5;
		int b = 24;
		
		//1월 1일 금
		//1월 8일 금
		//1월 31 금/ 2월 29 월/ 3월 31 화/ 4월 30 금/ 5월 31 일/ 6월 30 수
		//7월 31 금/ 8월 31 월/ 9월 30 목/ 10월 31 토/ 11월 30 화/ 12월 31 목
		
		
		//1월 3일 일  
		
		for (int i = 0; i < a - 1; i++) {
			b += month[i];
		}
		System.out.println(b);
		
		answer = day[(b-1) % 7];		
		
		
		System.out.println(answer);
		
		
	}

}
