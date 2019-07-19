package com.hyeon.day_08.multiLevelArray;

public class MultiLevelArr01 {

	public static void main(String[] args) {
		//배열의 개수 => 메모리가 허용하는 범위까지 배열을 만들 수 있다.
		//int[] k = new int[100]; //메모리가 차지하는 용량 = 100 * 4byte
		int[][] numbers = new int[3][2]; //고정적인 배열
		//numbers[0] = new int[10]; //2차 배열을 원하는 대로 초기화
		System.out.println("배열의 개수 : " + numbers.length); //3
		System.out.println("배열 첫번째의 개수 : " + numbers[0].length); //2
		
		int value = 0;
		
		for (int i = 0; i < numbers.length; i += 1) {
			for (int j = 0; j < numbers[i].length; j += 1) {
				value += 1;
				numbers[i][j] = value;
				System.out.print("numbers[" + i + "][" + j + "]의 값 : " + numbers[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
		int[][] numbers2 = { {1, 23,45, 22}, {}, {2, 5} }; //가변적인 배열
		System.out.println(numbers2.length);
		System.out.println(numbers2[0].length);
		System.out.println(numbers2[1].length);
		System.out.println(numbers2[2].length);
		//numbers2 배열에 저장할 수 있는 자료의 개수를 출력하는 프로그램을 작성해라. 지금!!
		
		System.out.println("=====================================");
		int cnt = 0;
		for (int i = 0; i < numbers2.length; i +=1 ) {
			cnt += numbers2[i].length;
			System.out.println("numbers2[" + i + "]에 저장할 수 있는 자료의 개수는 : " + numbers2[i].length);
		}
		System.out.println("\r총 저장할 수 있는 자료의 개수는 : " + cnt);
		
	}
}
