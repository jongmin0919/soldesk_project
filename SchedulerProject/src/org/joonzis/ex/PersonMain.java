package org.joonzis.ex;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		Person[] personArr = new Person[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1 ; i <= personArr.length ; i++) {
			System.out.println(i + "번째 정보를 입력해 주세요. (이름, 나이, 키, 성별 순으로 입력해 주세요)");
			String name = sc.nextLine();
			int age = sc.nextInt();
			sc.nextLine();
			double height = sc.nextDouble();
			sc.nextLine();
			char gender = sc.next().charAt(0);
			sc.nextLine();
			personArr[i-1] = new Person(name, age, height, gender);
			personArr[i-1].output();
			System.out.println();
		}
	}
}
