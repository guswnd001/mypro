package com.hyeon.day_06.am.refExam;

public class DataPack { //heap 영역에 생성되기 때문에 초기화할 필요가 없다.

	int numData = 10;
	long longData;
	boolean isCheck;
	String iname;
	
	public void prnData() { //stack 영역 (지역변수)
		int i = 0;
		System.out.println(numData);
		System.out.println(longData);
		System.out.println(isCheck);
		System.out.println(iname);
		System.out.println(i);
	}	

}
/* class의 이름 => dataPack
 * 변수 이름 => numData
 * 			 longData	[DataPack]
 * 			 isCheck
 * 			 iname
 * 			 
 * 			 i  [prnData] 
 */
