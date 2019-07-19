package test;

public class LadderGame05 {

	public static void main(String[] args) {

		LadderOutput(4);
		
		System.out.println();
		
	}

	public static int LadderInput() {
		
		int num = (int)(Math.random()*8) + 5; //5부터 12까지의 무작위 수
		return num;
		
	}
	
	public static void LadderOutput(int num) {
		
		String[][] ladderArr = new String[6][num];
		String[] ladderParts = { "│\t", "├───────", "┤\t" };
		//String[] ladderParts = { "0\t", "1\t", "2\t" };
		
		for (int i = 0; i < ladderArr.length; i++) {
			for (int j = 0; j < ladderArr[i].length; j++) {
				if (i == 0) {
					ladderArr[i][j] = j+1 + "\t";
				} else if (j == ladderArr[i].length-1) {
					ladderArr[i][j] = ladderParts[0];
				} else {	
					ladderArr[i][j] = ladderParts[(int)(Math.random()*2)];
				}
				ladderConnect(ladderArr, ladderParts, i);
				System.out.print(ladderArr[i][j]);
			}
			System.out.println();
		}
		System.out.println("=================================");
		int[][] point = new int[5][num]; //각 사다리별 가짓수 계산 [행], [열]

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5; j++) {
				if (ladderArr[j+1][i] == ladderParts[1]) {
					point[i][j] = 1;
				} else if (ladderArr[j+1][i] == ladderParts[2]) {
					point[i][j] = 2;
				} else {
					point[i][j] = 0;
				}
				System.out.print(point[i][j] + ", ");
			}
			System.out.println();
		}
		
	}
	
	public static String[][] ladderConnect(String[][] strArr1, String[] strArr2, int num) {
		
		for (int k = 0; k < strArr1[num].length-1; k++) {
			if (strArr1[num][k] == strArr2[1]) {
				strArr1[num][k+1] = strArr2[2];
			}
		}
		return strArr1;
	}

}
