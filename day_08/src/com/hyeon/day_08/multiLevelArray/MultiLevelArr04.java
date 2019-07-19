package com.hyeon.day_08.multiLevelArray;

public class MultiLevelArr04 {

	public static void main(String[] args) {
		
		int[] numMaster = {1, 2, 3, 4, 5};
		int[] numAssign = numMaster; 
		//만들어진 배열은 하나이고 두개의  서로 다른 변수가 같은 배열을 가르킨다.
		
		//for문에 의한 복사 =>System.arraycopy()메소드를 이용한 복사보다 조금 더 안전하다.
		int[] numCopy = new int[numMaster.length]; //원본의 길이값을 가져온다.
		
		for (int i  = 0; i  < numMaster.length; i += 1) {//완전 복사
			numCopy[i] = numMaster[i];
			System.out.println("원본 : " + numMaster[i] + "복사본 : " + numCopy[i]);
		}

		int[] numCopy1 = new int[3];
		
		for (int i  = 0; i  < 3; i += 1) {//완전 복사
			numCopy[i] = numMaster[i+2];
			System.out.println("원본 : " + numMaster[i] + "복사본 : " + numCopy[i]);
		}
		
		
		
	}
	
}
