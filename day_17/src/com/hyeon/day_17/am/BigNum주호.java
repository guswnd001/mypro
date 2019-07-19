package com.hyeon.day_17.am;

public class BigNum주호 {

	public static void main(String[] args) {
		
		int[] num = {86, 3, 38, 35, 28};
		String[] sort = new String[20];
		int check[] = new int[20];
		int[] convert = new int[20];
		int concnt = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] < 10) {
				sort[i] = num[i] * 11 + "";
				check[i] = num[i] * 11;
			} else {
				sort[i] = num[i] + "";
			}
		}

		for (int i = 0; i < sort.length; i++) {
			if (sort[i] == null) {
				break;
			}
			convert[i] = Integer.parseInt(sort[i]);
			concnt++;
		}

		for (int i = 0; i < convert.length; i++) {
			for (int j = i; j < convert.length; j++) {
				if (convert[i] < convert[j]) {
					int temp = convert[i];
					convert[i] = convert[j];
					convert[j] = temp;
				}
			}
		}

		System.out.print("조합 할 수 있는 가장 큰 수 : ");
		for (int i = 0; i < concnt; i++) {
			for (int j = 0; j < check.length; j++) {
				if (convert[i] == check[j]) {
					convert[i] = (convert[i] / 10);
					check[j] = 0;
				}
			}

			System.out.print(convert[i] + "");
		}
	}

}


