package test;

public class SearchBigNumber {

	public static void main(String[] args) {
		
		int[] num = {6, 10, 2, 11};
		int[][] numArr = new int[num.length][2];
		String bigNum = "";
		
		//num 배열의 수를 numArr에 넣기
		for (int row = 0; row < numArr.length; row++) {
			if (num[row] / 10 == 0) { //한자리 수일때  
				numArr[row][0] = num[row];
				numArr[row][1] = num[row]; 
			} else { //두자리 수일때
				numArr[row][0] = num[row]/10;
				numArr[row][1] = num[row]%10;
			}
		}
		
		//숫자 크기 비교 전 배열 출력하기
		for (int row = 0; row < numArr.length; row++) {
			for (int col = 0; col < numArr[row].length; col++) {
				System.out.print(numArr[row][col]);
			}
			System.out.println();
		}
		
		//숫자 크기 비교하기
		//int bigTemp = 0;
		int temp1 = 0;
		int temp2 = 0;
		int[] tmpArr = new int[num.length];
		for (int row1 = 0; row1 < numArr.length-1; row1++) {
			for (int row2 = row1+1; row2 < numArr.length; row2++) {
				if (numArr[row1][0] < numArr[row2][0]) {
					temp1 = numArr[row1][0];
					temp2 = numArr[row1][1];
					numArr[row1][0] = numArr[row2][0];
					numArr[row1][1] = numArr[row2][1];
					numArr[row2][0] = temp1;
					numArr[row2][1] = temp2;
				} else if (numArr[row1][0] == numArr[row2][0]) {
					if (numArr[row1][1] < numArr[row2][1]) {
						temp1 = numArr[row1][0];
						temp2 = numArr[row1][1];
						numArr[row1][0] = numArr[row2][0];
						numArr[row1][1] = numArr[row2][1];
						numArr[row2][0] = temp1;
						numArr[row2][1] = temp2;
					}
				}
			}
			
		}
		
		//숫자 크기 비교 후 배열 출력하기
		System.out.println("=========================");
		for (int row = 0; row < numArr.length; row++) {
			for (int col = 0; col < numArr[row].length; col++) {
				System.out.print(numArr[row][col]);
			}
			System.out.println();
		}
		
		
		
	}

}
