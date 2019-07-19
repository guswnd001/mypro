package com.hyeon.day_07.arrayTest;

import com.hyeon.day_07.classes.MemberVO;

public class ArrayExam01 {

	public static void main(String[] args) {
		
		int[] nums = new int[5];
		System.out.println(nums);
		System.out.println(nums[0] + "   " + nums.length);
		
		String strArr[] = {"hi", "bye"};
		System.out.println(strArr);
		System.out.println(strArr[0] + "   " + strArr.length);
		
		MemberVO[] vo;
		vo = new MemberVO[] {new MemberVO("김현중"), new MemberVO("박성범"),
								new MemberVO("정대화")};
		System.out.println(vo[0].getIrum());
		
		
	}

}
