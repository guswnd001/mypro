package com.hyeon.day_21.pm;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if (obj1 == obj2) {
			System.out.println("obj1과 obj2는 같습니다.");
		} else {
			System.out.println("obj1과 obj2는 다릅니다.");
		}
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 같습니다.");
		} else {
			System.out.println("obj1과 obj2는 다릅니다.");
		}
		
		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 같습니다.");
		} else {
			System.out.println("obj1과 obj3는 다릅니다.");
		}
	}

}

class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			
			if (id.equals(member.id)) {
				return true;
			}
			
		}
		return false;
	}
}