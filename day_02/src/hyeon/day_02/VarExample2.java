package hyeon.day_02;

import java.util.Scanner;

public class VarExample2 {
	
	public static void main(String[] args) {
		//키보드로 숫자를 2개를 입력을 받는다.
		//합과 곱의 결과를 출력하는 프로그램을 작성하시오.
		
		/*
		 * System.out.println("두 개의 숫자를 입력해주세요."); 
		 * int num1 = returnValue(); 
		 * int num2 = returnValue();
		 * 
		 * VarCal vc = new VarCal(); 
		 * vc.plus(num1, num2); 
		 * vc.multi(num1, num2);
		 * }
		 * 
		 * public static int returnValue() {
		 */	
		int kor = readData("국어");
		int eng = readData("영어");
		int mat = readData("수학");
		int tot = totCalData(kor, eng, mat);
		double avg = avgCalData(tot);
		
		printData("총점", tot);
		printData("평균", avg);
		
	}
		
//-----------------------------------------------------------------메소드 부분		
		
	public static int readData(String sub) { //입력기능을 담당하는 메소드
		Scanner scan = new Scanner(System.in);
		System.out.println(sub + "점수를 입력해주세요.");
		return scan.nextInt();
	}
	
	public static int totCalData(int num1, int num2, int num3) { //계산기능을 담당하는 메소드
		int tot = num1 + num2 + num3;
		return tot;
	}
	
	public static double avgCalData(int tot) { //계산기능을 담당하는 메소드
		double avg = tot/3;
		return avg;
	}
	
	public static void printData(String sub, double data) { //출력기능을 담당하는 메소드
		System.out.println("세 과목의 " + sub + "은 " + data);
	}
	
}
