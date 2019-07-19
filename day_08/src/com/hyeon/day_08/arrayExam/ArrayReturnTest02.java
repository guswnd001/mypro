package com.hyeon.day_08.arrayExam;

public class ArrayReturnTest02 {
	
	public static void main(String[] args) {
		
		ClassReturn cr = new ClassReturn();
		ValueClass vc = cr.fieldValueReturn();
		System.out.println(vc.num1 +"/" + vc.num2 +"/"+ vc.num3);
		
	}
}

class ClassReturn{
	
	int value1 = 100, value2 = 200;
	String value3 = "길동";
	public ValueClass fieldValueReturn() {
		
		ValueClass rtnValue = new ValueClass(value1, value2, value3);
		return rtnValue;
		
	}
}
class ValueClass{ //Value Object = DTO
	
	int num1, num2; //필드변수
	String num3;
	public ValueClass(int num1, int num2, String num3) { //지역변수
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		/* 필드변수랑 지역변수가 이름이 같은때, 필드변수이름 앞에 this.을 붙인다.
		 * 보통 이름을 똑같이 두고 앞에 this.를 붙이는게 관례이다. 
		 */
	}
}

/* 여러개의 자료를 반환하는 방법
 * 1.동일한 타입의 자료라면 배열로 묶어서 반환한다
 * 2.동일  하지 않은 타입의 자료라면 클래스로 묶어서 반환
 * 3.클래스를 이용해서 자료를 표현하면 좋은 점 => 배열의 차수를 줄일 수 있다.
 */
