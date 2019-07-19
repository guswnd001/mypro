package com.hyeon.day_26.am;

public class ChildProduct<T, M, C> extends Product<T, M> {
	private C company;
	
	public C getCompany() {
		return company;
	}
	
	public void setCompany(C company) {
		this.company = company;
	}
}
 
class Product<T, M> {
	private T kind;
	private M model;
	
	public T getKind() {
		return this.kind;
	}
	public M getModel() {
		return this.model;
	}
	
	public void setKind(T kind) {
		this.kind = kind;
	}
	public void setModel(M model) {
		this.model = model;
	}
}

class Tv {
	
}
