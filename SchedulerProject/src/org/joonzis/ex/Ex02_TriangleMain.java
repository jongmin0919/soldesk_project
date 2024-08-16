package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_TriangleMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삼각형의 개수를 입력해 주세요.");
		Ex02_Triangle[] triangleArr = new Ex02_Triangle[sc.nextInt()];
		
		for(int i = 1 ; i <= triangleArr.length ; i++) {
			System.out.println(i + "번째 삼각형의 정보를 입력해 주세요. ------------------ \n" +
							   "너비 입력 >> "
			);
			int width = sc.nextInt();
			System.out.println("높이 입력 >>");
			int height = sc.nextInt();
			
			triangleArr[i-1] = new Ex02_Triangle(width, height);
			triangleArr[i-1].output();
			System.out.println();
		}
		System.err.println("프로그램을 종료합니다.");
	}
}
