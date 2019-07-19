package test;

public class SearchBigNumberFinal {

	public static void main(String[] args) {
		
		//랜덤수로 배열과 수 만들기
		int randNum = (int)(Math.random()*10) + 1;
		int[] num = new int[randNum];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*99) + 1;;
		}
		String bigNum = "";
		
		//숫자 크기 비교 전 배열 출력하기
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + ", "); 
		}
		System.out.println();
		
		//숫자 크기 비교하기
		int temp = 0;
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				//비교하는 두 수 중 하나라도 10보다 작을 경우 비교
				if (num[i] < 10) {
					if (num[i]*11 < num[j]) {
						temp = num[i];
						num[i] = num[j];
						num[j] = temp;
					
					}
				} else if(num[j] < 10) {
					if (num[i] < num[j]*11) {
						temp = num[j];
						num[j] = num[i];
						num[i] = temp;
					
					}
				//두 수 다 10보다 작거나 큰 경우 비교
				} else {
					if (num[i] < num[j]) {
						temp = num[i];
						num[i] = num[j];
						num[j] = temp;
					}
				}
			}
		}
		
		//숫자 크기 비교 후 배열 출력하기
		System.out.println("=========================");
		for (int i = 0; i < num.length; i++) {
			bigNum += num[i] + "";
		}
		System.out.println(bigNum);
		
	}
}
