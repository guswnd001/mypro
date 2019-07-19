package com.hyeon.day_25.am;

public class DecimalFormat {

	public DecimalFormat(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		double num = 1234567.89;
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(num));
		df = new DecimalFormat("0.0");
		System.out.println(df.format(num));
		df = new DecimalFormat("0000000000.00000");
		System.out.println(df.format(num));
		df = new DecimalFormat("#");
		System.out.println(df.format(num));
		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));
		df = new DecimalFormat("##########.#####");
		System.out.println(df.format(num));
		df = new DecimalFormat("#.0");
		System.out.println(df.format(num));
		df = new DecimalFormat("+#.0");
		System.out.println(df.format(num));
		df = new DecimalFormat("-#.0");
		System.out.println(df.format(num));
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
		df = new DecimalFormat("0.0E0");
		System.out.println(df.format(num));
		df = new DecimalFormat("+#,### ; -#,###");
		System.out.println(df.format(num));
		df = new DecimalFormat("#.# %");
		System.out.println(df.format(num));
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println(df.format(num));
		
	}

	private char[] format(double num) {
		// TODO Auto-generated method stub
		return null;
	}

}
