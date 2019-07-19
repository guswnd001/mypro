package hyeon.day_02;

import java.util.Scanner;

public class 김현중 {

	public static void main(String[] args) {
		
		사칙연산 어이 = new 사칙연산();
		
		어이.더하기(1245, 400); 
		어이.빼기(144, 40);
		어이.곱하기(17, 18);
		어이.나누기(300, 30);
		 
		어이.빼기(returnValue(), 100);
		
	}
	
	public static int returnValue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		return scan.nextInt(); 
		
	}

}
