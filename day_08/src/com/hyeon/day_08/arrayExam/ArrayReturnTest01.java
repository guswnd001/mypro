package com.hyeon.day_08.arrayExam;

public class ArrayReturnTest01 {
	
	public static void main(String[] args) {
		
		ArrayReturn ar = new ArrayReturn();
		int[] ardata1 = ar.fieldValueReturn();
		System.out.println(ardata1[0] + ardata1[1] + ardata1[2]);
	}
}

class ArrayReturn{
	
	int value1 = 100;
	int value2 = 200;
	int value3 = 300;
	
	public int[] fieldValueReturn() {
		
		int[] rtnValue = {value1, value2, value3};
		return rtnValue;
		//return value1, value2, value3;
		//이렇게는 줄 수 없다. return은 오직 하나의 자료만을 보낸다. 
		
	}
}
