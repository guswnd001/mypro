package com.hyeon.day_30.am;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
	int x, y;
	
	Shape() { this(0, 0); }
	Shape(int x, int y) {
		this.x = x;
		this.y = y;	}
	
	abstract double area();
	abstract double length();
	public String getLocation() { return "x: " + x + ", y: " + y; }
	public String toString() {
		return ", 넓이: " + String.format("%.2f", area()) +
				", 둘레: " + String.format("%.2f", length()); }
}

class Circle extends Shape {
	double r;
	
	Circle() { this(1); }
	Circle(double r) { this.r = r; }
	Circle(int x, int y, double r) {
		super(x, y);
		this.r = r;	}
	
	@Override
	double area() {	return r * r * Math.PI; }
	@Override
	double length() { return 2 * r * Math.PI; }
	@Override
	public String toString() {
		return "좌표: " + getLocation() + ", 반지름: " + r + super.toString();	}
}

class Rectangle extends Shape {
	int w, h;
	
	Rectangle() { this(1, 1); }
	Rectangle(int w, int h) {
		this.w = w;
		this.h = h;	}
	Rectangle(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h = h;	}
	
	@Override
	double area() {	return w * h; }
	@Override
	double length() { return (w + h) * 2; }
	@Override
	public String toString() {
		return "좌표: " + getLocation() + ", 가로: " + w + ", 세로: " + h + super.toString();	}
}

public class ListEx3 {
	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();
		
		list.add(new Circle());
		list.add(new Circle(5));
		list.add(new Circle(10, 10, 3));
		
		list.add(new Rectangle());
		list.add(new Rectangle(5, 10));
		list.add(new Rectangle(3, 3, 5, 10));
		
		for (Shape s : list) {	System.out.println(s);	}
	}
}
