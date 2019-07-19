package com.hyeon.day_25.pm;

public class Product<A, M> {

	private A kind;
	private M model;

	public A getKind() { return this.kind; }
	public M getModel() { return this.model; } 
	
	public void setKind(A kind) { this.kind = kind; }
	
	public void setModel(M model) { this.model = model; }

}

class Car {

}

class Tv {

}