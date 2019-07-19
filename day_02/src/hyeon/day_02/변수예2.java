package hyeon.day_02;

import java.util.Scanner;

public class 변수예2 {

		public static void main(String[] args) {
			
			int numBox; 
			numBox = 123; //int numBox = 123; 정수 123을 저장
			System.out.println("numBox에 들어있는 값 : " + numBox); 
			System.out.println();
			
 			long numBox2; //큰 수를 저장하기 때문에 long타입으로 저장
			numBox2 = 12345678912L + 64;
			System.out.println("numBox2에 들어있는 값 : " + numBox2);
			System.out.println(); //한줄 띄우기
			
			String strBox;
			strBox = "Hello World"; //String strBox = "Hello World";
			System.out.println("strBox에 들어있는 값 : " + strBox);
			

		}

	}

