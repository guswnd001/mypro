package com.hyeon.day_25.pm;

public class BoxExample {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<String>();
		box1.set("hello");
		String str = box1.get();
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(6);
		int i = box2.get();
		
	}

}

class Box1<T> {
	
	private T t;
	
	public T get() { return t; }
	public void set(T t) { this.t = t; }
	
}