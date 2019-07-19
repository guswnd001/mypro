package test;

public class DiamondTriangle {

	public static void main(String[] args) {
		
		diamondInput();
		
	}

	public static void diamondInput() {
		
		int num = ((int)(Math.random()*12) + 3)*2 - 1; //5부터 30사이 무작위 홀수 
		System.out.println("랜덤 홀수 : " + num);
		System.out.println("==============================");
		int centerNum = num/2; //기준점
		String[][] diaArr = new String[num][num]; //주어진 홀수로 행렬을 만듬
		
		for (int i = 0; i < num; i++) {
			if(i <= centerNum) { //다이아의 윗부분
				for (int j = 0; j < num; j++) {
					if(j == (centerNum-i) || j == (centerNum+i)) {
						diaArr[i][j] = "*";
					} else {
						diaArr[i][j] = " ";
					}
					System.out.print(diaArr[i][j]);
				}
				System.out.println();
			} else { //다이아의 아랫부분
				for (int j = 0; j < num; j++) {
					if(j == (i-centerNum) || j == (3*centerNum - i)) {
						diaArr[i][j] = "*";
					} else {
						diaArr[i][j] = " ";
					}
					System.out.print(diaArr[i][j]);
				}
				System.out.println();
			}

		}
	}
		
}
