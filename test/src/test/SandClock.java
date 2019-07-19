package test;

public class SandClock {

	public static void main(String[] args) {
		
		sandClockOut();
		
		
	}

	public static void sandClockOut() {
		

		int num = ((int)(Math.random()*14)+2)*2-1;
		//int oddNum = num*2 - 1; //3부터 30아래의 무작위 홀수 
		int halfNum = num/2; //가운데 기준이 될 수
		System.out.println("모래지계를 만들 무작위 홀수 : " + num);
		System.out.println();
		
		for (int i = 0; i <= halfNum; i++) { //모래시계 윗부분
			for (int j = 0; j < i; j++) { //왼쪽부터 공백을 출력하는 반복문
				System.out.print(" ");
			}
			for (int j = i; j < num-i; j++) { //이어서 *를 출력할 반복문
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = halfNum+1; i <= num; i++) { //모래시계 아래부분
			for (int j = 0; j < num-i; j++) { //왼쪽부터 공백을 출력한 반복문
				System.out.print(" ");
			}
			for (int j = num-i; j < i; j++) { //이어서 *를 출력할 반복문
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
}
