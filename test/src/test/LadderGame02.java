package test;

public class LadderGame02 {

	public static void main(String[] args) {

		//System.out.println(LadderInput());
		//String[][] ladder = new String[5][5];
		LadderOutput(5);
		//System.out.println("=================================");
		System.out.println();
		
	}

	public static int LadderInput() {
		
		int num = (int)(Math.random()*8) + 5; //5부터 12까지의 무작위 수
		return num;
		
	}
	
	public static void LadderOutput(int num) {
		
		String[][] ladderArr = new String[6][num];
		String[] ladderParts = { "│\t", "├───────", "┤\t" }; // 0, 1, 2
		int [] a = {0, 2};
		String tab = "\t";
		
		for (int i = 0; i < ladderArr.length; i++) {
			for (int j = 0; j < ladderArr[i].length; j++) {
				if (i == 0) {
					ladderArr[i][j] = j+1 + tab;
				} else if (j == 0) {
					ladderArr[i][j] = ladderParts[(int)(Math.random()*2)];
				} else if (j == 4){
					ladderArr[i][j] = ladderParts[a[(int)(Math.random())]];
				} else {		
					ladderArr[i][j] = ladderPartsRandom(ladderParts);
				}
				for (int k = 0; k < ladderArr[i].length-1; k++) {
					if (ladderArr[i][k] == ladderParts[1]) {
						ladderArr[i][k+1] = ladderParts[2];
					}
				}
				System.out.print(ladderArr[i][j]);
			}
			System.out.println();
			
		}
		
	}
	
	public static String ladderPartsRandom(String[] str) {
		
		int num = (int)(Math.random()*2); //0, 1, 2 랜덤
		return str[num];
		
	}

}
