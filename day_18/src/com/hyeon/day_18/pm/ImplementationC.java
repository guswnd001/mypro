package com.hyeon.day_18.pm;

public class ImplementationC implements InterfaceC{
	
	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodA() 실행");
	}
	
	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodB() 실행");
	}
	
	@Override
	public void methodC() {
		// TODO Auto-generated method stub
		System.out.println("ImplementationC-methodC() 실행");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementationC imp = new ImplementationC();
		
		InterfaceA iA = imp;
		iA.methodA();
		System.out.println();
		
		InterfaceB iB = imp;
		iB.methodB();
		System.out.println();
		
		InterfaceC iC = imp;
		iC.methodA();
		iC.methodB();
		iC.methodC();
		
	}

}
