package test;

public class LadderGame {

	public static void main(String[] args) {

		//System.out.println(LadderInput());
		//String[][] ladder = new String[5][5];
		LadderOutput(5);
		
	}

	public static int LadderInput() {
		
		int num = (int)(Math.random()*8) + 5; //5부터 12까지의 무작위 수
		return num;
		
	}
	
	public static void LadderOutput(int num) {
		
		int colNum = num*6 - 5; //사다리 사이 간격이 5인 사다리게임의 총 열 개수
		String[][] ladder = new String[7][colNum]; //사다리 2중 배열 생성
		int[] pointNum = new int[num]; //사다리 세로 줄 수
		for (int i = 0; i < num; i+=1) {
			 pointNum[i] = i*6;
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < colNum; j+=1) {
				ladder[i][j] = " ";
				for (int k = 0; k < pointNum.length; k++) {
					if(j == pointNum[k]) {
						ladder[i][j] = "├────";
						ladder[0][j] = String.valueOf(k+1);
					}
				}
				System.out.print(ladder[i][j]);
			
			}
			System.out.println();
		}
		
		
		
		
		
		
	}

}
