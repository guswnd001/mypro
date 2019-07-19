package com.hyeon.day_25.pm;

public class BoxingMethodExample {
	public static void main(String[] args) {
		Box<Integer> box1 = Util.boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 = Util.boxing("김현중");
		String strValue = box2.get();
	}
}

class Util {
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
}

class Box<T> {
	private T t;
	public T get() { return t; }
	public void set(T t) { this.t = t; }
}