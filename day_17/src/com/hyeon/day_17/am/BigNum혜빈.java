package com.hyeon.day_17.am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigNum혜빈 {

	public static void main(String[] args) {

		int randEleNum = 0;
		int randArrLen = (int) (Math.random() * 9) + 4;
		int[] myArr = new int[randArrLen];

		// 숫자 개수 0~99까지 지정하는 for문
		for (int i = 0; i < randArrLen - 1; i++) {
			// 1~100까지의 랜덤 element num 생성하는 메서드
			randEleNum = (int) (Math.random() * 100) + 10;
			myArr[i] += randEleNum;
			System.out.print(myArr[i] + " ");
		}
		System.out.println();
		System.out.println("=================================");

		// myArr2 : index 1~ end(=end-1) (copy) - 인덱스 0의 0값 removing
		int[] myArr2 = Arrays.copyOfRange(myArr, 0, myArr.length - 1);

		// list에 옮기고, ascend sort
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : myArr2) {
			intList.add(i);
		}

		System.out.println("intList : \t\t\t" + intList);
		Collections.sort(intList);
		System.out.println("ascending sort intList : \t" + intList);

		// 그 다음에 descend sort 해줘서 출력
		List<Integer> desintList = new ArrayList<Integer>();
		for (int i : intList) {
			desintList.add(i);
		}

		Collections.reverse(desintList);
		System.out.println("descending sort intList : \t" + desintList);

		System.out.println("=================================");

		// 이제 뒤에 myArr -> myArr2로 모두 replace 해줘야됨
		// int[] -> string("num"+"num")의 방법을 쓸거임
		// 각각 element의 길이를 계산해서 경우의 수(조건)으로 나눌 것임
		int zeroContent = myArr2[0];
		int zeroContentLen = (int) (Math.log10(zeroContent) + 1);
		int plusContent;
		int plusContentLen;

		// 선택정렬해서 비교해야함 (01,02,03,04)와 같이 0은 고정해놓고 뒤에만 수가 증가하면 된다.
		String FinalStr = "";
		for (int i = 0; i < myArr2.length - 1; i++) {
			plusContent = myArr2[i + 1];
			plusContentLen = (int) (Math.log10(plusContent) + 1);

			// 배열안 element가 each all 같은 자리수라면 단순 descending sort해서 string에 넣어 출력하면 된다.
			// 방법1) 자릿수가 각각 같을 때
			if (zeroContentLen == plusContentLen) {
				for (Integer s : desintList) {
					FinalStr += s + "";
				}
				/**
				 * 굳이..trimming 안해도되게됨 앞뒤랑, 공백(space)들 제거해서 다시 finalStr에 담기 finalStr = a.trim();
				 * finalStr = finalStr.replace(" ", ""); finalStr = finalStr.replace(" ", "");
				 * finalStr = finalStr.replace(",", ""); finalStr = finalStr.replace("]", "");
				 * finalStr = finalStr.replace("[", "");
				 **/
			}
//			break;
		}

		System.out.println("Final String :" + FinalStr);

		System.out.println("=================================");

		for (int i = 0; i < myArr2.length - 1; i++) {
			plusContent = myArr2[i + 1];
			plusContentLen = (int) (Math.log10(plusContent) + 1);

			List<String> OneintList = new ArrayList<String>();
			List<String> TenintList = new ArrayList<String>();
			List<String> HunintList = new ArrayList<String>();

			// 방법2) 자릿수가 각각 다를 때
			if (zeroContentLen != plusContentLen) {
				for (int g = 0; g < myArr.length - 1; g++) {

					// intlist의 각각의 요소에 접근해서 얻은 값을 string ele에 넣음
					String ele = (intList.get(g).toString());
					// ele의 길이를 elelen이라고 잡음
					int eleLen = (int) ele.length();
					String eleLen2 = "" + eleLen;

					// toString()으로 값 확인
					//	               System.out.println("ele : \t" + ele.toString());
					//	               System.out.println("eleLen : \t" + eleLen2.toString());

					// 순차 정렬하면 이제 끝!
					if (eleLen == 1) {
						OneintList.add(ele);

					} else if (eleLen == 2) {
						TenintList.add(ele);

					} else {
						HunintList.add(ele);
					}
				}

				// 확인용
				//	            System.out.println("Onelist : " + OneintList);
				//	            System.out.println("Tenlist : " + TenintList);
				//	            System.out.println("Hunlist : " + HunintList);

				// TenList + HunList + OneList

				List<String> TList = new ArrayList<String>(TenintList);
				List<String> HList = new ArrayList<String>(HunintList);

				TList.addAll(OneintList);
				//	            System.out.println("Tlist : " + TList);
				HList.addAll(TList);
				//	            System.out.println("3 list sum : " + TList);

				/**
				 * List<List<String>> alist = Arrays.asList(TList); System.out.println("3 list
				 * sum:" + alist);
				 **/

				List<String> RList = new ArrayList<String>();

				// str로 변환해서 람다식 사용
				String OneFinalStr = "";
				String TenFinalStr = "";

				for (String v : OneintList) {
					OneFinalStr += v + "";
				}

				for (String z : TenintList) {
					TenFinalStr += z + "";
				}

				for (int z = 0; z < myArr.length - 1; z++) {
					// 100의 자리숫자 출력

					Collections.sort(RList, (t1, t2) -> (t2 + t1).compareTo(t1 + t2));

					if (TList.get(z).equals("0")) { // t1=t2
						//	                  응응 비교해서 같으면..그냥 순서 t1+t2 더한 값 상관없이 넣어라 
						RList.add(z, TList.get(z) + TList.get(z + 1));
						// RList.add(index, element);
						z++;
					}
					if (TList.get(z).equals("1")) { // t1>t2
						//	                  응응 비교해서 t1이 더 크면 t1 먼저 넣어라 
						RList.add(z, TList.get(z + 1) + TList.get(z));
						z++;
					}

					if (TList.get(z).equals("-1")) { // t1<t2
						//	                  응응 비교해서 t2가 더 크면 t2 먼저 넣어라 
						RList.add(z, TList.get(z) + TList.get(z + 1));
						z++;
					}
				}

				System.out.println("RList : " + RList);
			}
		}
	}
}

