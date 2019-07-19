package com.hyeon.day_05.am;

public class ForExam04 {

		public static void main(String[] args) {
			
			char[] numArr = new char[5]; //new는 객체 생성 연산자. heap메모리 영역에 객체 생성.
			/* numArr = stack영역 | new = heap영역
			 * new int[5] → 메모리 생성후 주소값을 반환
			 * 타입 사이즈 * 배열 길이 = 배열의 총 크기
			 * [2byte][2byte][2byte][2byte][2byte] = 10byte
			 * 모든 배열은 참조타입이다 → 메모리의 주소를 값으로 갖는다
			*/
//			numArr[0] = 'A';
//			numArr[1] = 66;
//			numArr[2] = 67;
//			numArr[3] = 68;
//			numArr[4] = 69;
			
			for (char i = 'A', j = 0; i < 'E'; i += 1, j += 1) {
				numArr[j] = i;
				System.out.println(j+1 + "번째 글자 => " + numArr[j]);				
				j++;
			}
			
			//System.out.println(numArr);
			System.out.println("=============================================");
			
			// int[] numArr = {10, 20, 50, 80, 100};
			
			String iname = "hyeonjoong";
//			System.out.println(iname.length()); //길이 10
//			System.out.println(iname.charAt(5)); // 글자 하나 추출 
			int inameCharCnt = iname.length();
			
			for (int i = 0; i < inameCharCnt; i += 2) {
//				System.out.println(i+1 + "번째 글자 => " + iname.charAt(i));
				System.out.println(i+1 + "번째 글자 => " + iname.charAt(i));
			}
			
		
		}
}
