package com.hyeon.day_10.am;

public class ArrayCopyExample {

	public static void main(String[] args) {

		String[] oldStrArr = {"java", "array", "copy"};
		String[] newStrArr = new String[5];
		
		System.arraycopy(oldStrArr, 0, newStrArr, 0, oldStrArr.length);
		//arraycopy(복사할 배열, 복사할 시작위치, 복사될 배열, 복사될 시작위치, 복사할 배열 끝위치)
		
		for (int i = 0; i < newStrArr.length; i++) {
			System.out.print(newStrArr[i] + ", ");
		}
		
	}

}
