package com.hyeon.day_27.am;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
	static int num2 = 0;
	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random() * 6) + 1;
			return num;
		};
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수: " + num);
		
		Supplier<Integer> su = () -> {
			num2 = (int)(Math.random() * 6) + 1;
			return num2;
		};
		num = su.get();
		System.out.println("눈의 수: " + num);
	}

}
