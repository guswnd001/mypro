package test;

public class LadderGame04 {

	public static void main(String[] args) {

		LadderOutput(5);
		System.out.println("=================================");
		System.out.println();
		
	}

	public static int LadderInput() {
		
		int num = (int)(Math.random()*8) + 5; //5부터 12까지의 무작위 수
		return num;
		
	}
	
	public static void LadderOutput(int num) {
		
		String[][] ladderArr = new String[6][num];
		String[] ladderParts = { "│\t", "├───────", "┤\t" };
		String tab = "\t";
		
		for (int i = 0; i < ladderArr.length; i++) {
			for (int j = 0; j < ladderArr[i].length; j++) {
				if (i == 0) {
					ladderArr[i][j] = j+1 + tab;
				} else if (j == 4) {
					ladderArr[i][j] = ladderParts[0];
				} else {	
					ladderArr[i][j] = ladderParts[(int)(Math.random()*2)];
				}
				ladderConnect(ladderArr, ladderParts, i);
				System.out.print(ladderArr[i][j]);
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
