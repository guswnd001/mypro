package hyeon.day_03;

import java.util.Scanner;

public class OperateTest02 {

	public static void main(String[] args) {
		
		int i = 10;
		//int result1 = i++; // 단독으로만 사용하자!
		int result1 = i;
		i++; // i+=1; => i=i+1; => i++;
		System.out.println(i + "result => " + result1);
		
		int j = 10;
		j++;
		int result2 = j; //혼자 쓰일 때는 위와 다르지 않지만, 대입문으로 쓰일 때에는 먼저 증가하고 대입.
		System.out.println(j + "result => " + result2);
		
		System.out.println("==============3항 연산자 실습과 다양한 형태===============");
		
		int value1 = 20;
		int value2 = 50;
		String resultValue = (value1 < value2)? "성범": "대화"; 
		System.out.println(resultValue);
		
		System.out.println("----------------------------------------------------------");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("연산을 선택하시오 [덧셈 1 : 뺄셈 2 : 곱셈 3 : 나눗셈 4]");
		int select = scan.nextInt();
		/*int result = (1 == select)? add(200, 100): 
						(2 == select)? sub(200, 100) : 
						 (3 == select)? mul(200, 100) : div(200, 100);*/
		//또 다른 방법 => 어떤 것이 가독성이 더 좋은지
		int result = (1 == select%2)? 
						(1 == select)? add(200, 100):mul(200, 100) : 
						(2 == select)? sub(200, 100):div(200, 100); 
		System.out.println("연산결과 : " + result);
		
	}
	
	public static int add(int data1, int data2) {
		return data1 + data2;
	}
	
	public static int sub(int data1, int data2) {
		return data1 - data2;
	}
	
	public static int mul(int data1, int data2) {
		return data1 * data2;
	}
	
	public static int div(int data1, int data2) {
		return data1 / data2;
	}

}
