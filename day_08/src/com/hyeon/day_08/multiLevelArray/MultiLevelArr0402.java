package com.hyeon.day_08.multiLevelArray;

public class MultiLevelArr0402 {

	public static void main(String[] args) {
		
		System.out.println("================배열 참조===============");
		int[] numMaster = {1, 2, 3, 4, 5};
		int[] numAssign = numMaster; 
		System.out.println("numMaster : " + numMaster); //해시코드 : 실제 자료의 주소를 계산할 수 있는 정보
		System.out.println("numAssign : " + numAssign);
		
		System.out.println("================배열 복사===============");
		int[] numCopy = new int[numMaster.length]; //원본의 길이값을 가져온다.
		for (int i  = 0; i  < numMaster.length; i += 1) {//완전 복사
			numCopy[i] = numMaster[i];
			//System.out.println("원본 : " + numMaster[i] + "복사본 : " + numCopy[i]);
		}

		System.out.println("numMaster : " + numMaster);
		System.out.println("numCopy   : " + numCopy + "\t" + numCopy.hashCode());
										   //16진수 				//10진수
		
	}
	
}
