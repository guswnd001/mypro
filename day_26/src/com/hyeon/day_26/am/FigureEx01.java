package com.hyeon.day_26.am;

public class FigureEx01 {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(2);
		Circle c3 = new Circle(3, 2, 2);
		System.out.println("c1의 반지름: " + c1.radius);
		System.out.println("c1의 x좌표: " + c1.x);
		System.out.println("c1의 y좌표: " + c1.y);
		System.out.println("c1의 넓이: " + c1.area());
		System.out.println("c1의 원주: " + c1.length());
		System.out.println("===========================");
		System.out.println("c2의 반지름: " + c2.radius);
		System.out.println("c2의 x좌표: " + c2.x);
		System.out.println("c2의 y좌표: " + c2.y);
		System.out.println("c2의 넓이: " + c2.area());
		System.out.println("c2의 원주: " + c2.length());
		System.out.println("===========================");
		System.out.println("c3의 반지름: " + c3.radius);
		System.out.println("c3의 x좌표: " + c3.x);
		System.out.println("c3의 y좌표: " + c3.y);
		System.out.println("c3의 넓이: " + c3.area());
		System.out.println("c3의 원주: " + c3.length());
		System.out.println("===========================");
		
		Rectangle r1 = new Rectangle(1, 1);
		Rectangle r2 = new Rectangle(1, 1, 5, 7);
		System.out.println("r1의 x1좌표: " + r1.x1);
		System.out.println("r1의 y1좌표: " + r1.y1);
		System.out.println("r1의 x2좌표: " + r1.x2);
		System.out.println("r1의 y2좌표: " + r1.y2);
		System.out.println("r1의 넓이: " + r1.area());
		System.out.println("r1의 둘레: " + r1.length());
		System.out.println("===========================");
		System.out.println("r2의 x1좌표: " + r2.x1);
		System.out.println("r2의 y1좌표: " + r2.y1);
		System.out.println("r2의 x2좌표: " + r2.x2);
		System.out.println("r2의 y2좌표: " + r2.y2);
		System.out.println("r2의 넓이: " + r2.area());
		System.out.println("r2의 둘레: " + r2.length());
	}

}

class Figure {
	String type;
	
	public Figure() { }
	public Figure(String type) { this.type = type; }
	
}

class Circle extends Figure {
	int radius = 1;
	int x = 1;
	int y = 1;
	static int count;
	
	public Circle() { count++; }
	public Circle(int radius) {	this.radius = radius; count++; }
	public Circle(int radius, int x, int y) {
		this.radius = radius;
		this.x = x;
		this.y = y;
		count++;
	}
	
	//원의 넓이
	public double area() {
		double cArea;
		cArea = radius * radius * Math.PI;
		return Math.round(cArea*1000)/1000.0;
	}
	//원의 둘레
	public double length() {
		double cLength;
		cLength = 2 * radius * Math.PI;
		return Math.round(cLength*1000)/1000.0;
	}
}

class Rectangle extends Figure {
	int x1, y1;
	int x2, y2;
	static int count;
	
	public Rectangle(int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x + 1;
		this.y2 = y + 1;
		count++;
	}
	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		count++;
	}
	
	//사각형의 넓이
	public int area() {
		int rArea;
		rArea = Math.abs(x1-x2) * Math.abs(y1-y2);
		return rArea;
		
	}
	//사각형의 둘레
	public int length() {
		int rLength;
		rLength = (Math.abs(x1-x2) + Math.abs(y1-y2)) * 2;
		return rLength;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}