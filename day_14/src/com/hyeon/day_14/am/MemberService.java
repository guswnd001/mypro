package com.hyeon.day_14.am;
//15번
public class MemberService {
	
	public static boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void logout(String id) {
			System.out.println("로그아웃 되었습니다.");
	}
	
}
