package com.hyeon.day_22.am;

public class Key {
	
	public int number;
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) { //부모
		if (obj instanceof Key) { //true가 나왔다는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 뜻이다.
			//참조변수 instanceof 타입(클래스명)
			Key compareKey = (Key)obj; //부모를 자식에 넣기 위해서 캐스팅을 해야한다.
			if (this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return "Key [number=" + number + "]";
	}
	
	
}
