package com.hyeon.day_08.multiLevelArray;

public class MultiLevelArr02 {

	public static void main(String[] args) {
		
		String[][] studentInfos = new String[5][];
		studentInfos[0] = new String[5];
		studentInfos[1] = new String[7];
//		studentInfos[2] = {"가나다", "라마바", "사아자", "차카파"}; 오류
//		studentInfos[2] = new String[] {"가나다", "라마바", "사아자", "차카파"};
		studentInfos[3] = new String[] {"홍길동", "경기도 수원", "01022223333"};
		studentInfos[4] = new String[11];
		
		//서로 다른 종류의 자료를 하나의 배열처럼 사용하고 싶을 때 => Java Script처럼 사용하고 싶을때
//		arrData = {1, "길동아", 2, "꺽정아", 3, "순신아", 4, "감찬아"} => js code
		//2개의 배열 2차원으로 만들어 버린다.
/*		for (int i = 0; i < arrData.length; i += 2) {
			System.out.println(arr.Data[i]); //짝수 
			System.out.println(arr.Data[i+1]); //홀수 
		}
*/	
		int[] nos = {1, 2, 3, 4};
		String[] names = {"홍", "임", "이", "강"};
		
		for (int i = nos.length-1; i >= 0; i -= 1) {
			System.out.print(nos[3-i] + " : ");
			System.out.println(names[3-i]);
		}
		
		
	}
}
