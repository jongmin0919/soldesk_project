package org.joonzis.ex;

import java.util.Scanner;

public class Ex03_StudentManager {
	int idx = 0;
	Ex03_Student[] studentArr;
	Scanner sc = new Scanner(System.in);
	
	public Ex03_StudentManager() {

	}
	
	public Ex03_StudentManager(int length) {
		studentArr = new Ex03_Student[length];
	}
	
	Ex03_Student input() {
			if(idx == studentArr.length) {
				return null;
			}
			
			System.out.println("학생 이름을 입력해 주세요.");
			String name = sc.next();			
			System.out.println("학생 학과를 입력해 주세요.");
			String dept = sc.next();
			System.out.println("학생의 중간 점수를 입력해 주세요.");
			String score1 = sc.next();
			System.out.println("학생의 기말 점수를 입력해 주세요.");
			String score2 = sc.next();
			return new Ex03_Student(name, dept, score1, score2);
	}
	
	void addNewStudent(Ex03_Student student) {
			if(student != null) {
				studentArr[idx] = student;
				System.out.println("학생 정보가 정상적으로 저장되었습니다.");
				idx++;
			}else {
				System.out.println("학생 정보를 저장하지 못했습니다. 새로운 학생 그룹을 생성해 주세요.");
			}
	}
	
	void outputAllStudents() {
		for(int i = 0 ; i < idx ; i++) {
			studentArr[i].output();
		}
	}
	void outputAverage() {
		double totalAvg = 0;
		for(int i = 0 ; i < idx ; i++) {
			totalAvg += studentArr[i].average;
		}
		
		System.out.println(
				"학생의 총 평균 점수는 : " + (totalAvg/idx) + "입니다."
		);
	}
	
	Ex03_Student findStudent() {
		System.out.println("찾을 학생의 이름을 입력해 주세요.");
		
		String name = sc.next();
		
		for(int i = 0 ; i < idx + 1 ; i++) {
			if(studentArr[i].name.equals(name)) {
				return studentArr[i];
			}
		}
		return null;
	}
	
	void output(Ex03_Student student) {
		try {
			student.output();
		} catch (NullPointerException e) {
			System.out.println("찾는 학생이 없습니다.");
		}
	}
}
