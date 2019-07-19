package com.hyeon.day_06.am.refExam;

public class UseData {

	public static void main(String[] args) {
		
		DataObj obj = new DataObj();
		DataObj objCp = obj;
		
		System.out.println(obj.num1 + ", " + objCp.num1);

		obj.num1 = 700;
		
		System.out.println(obj.num1 + ", " + objCp.num1);
		System.out.println(obj);
		System.out.println(obj.toString());
	}

}
