package org.joonzis.ex;

public class Ex03_Student {
	String name, dept, score1, score2;
	double average;
	boolean isPass;
	
	public Ex03_Student() {
	}
	
	public Ex03_Student(String name, String dept, String score1, String score2) {
		this.name = name;
		this.dept = dept;
		this.score1 = score1;
		this.score2 = score2;
		average = (Double.parseDouble(score1) + Double.parseDouble(score2) / 2);
		isPass = average >= 80 ? true : false;
	}
	
	double getAverage() {
		return average;
	}
	
	String getPass() {
		return (getAverage() >= 80 ? "합격" : "불합격");
	}
	
	void output(){
		System.out.println(
				"이름 : " + name + "\n" +
				"학과 : " + dept + "\n" +
				"평균 : " + getAverage() + "\n" +
				"합격 유무 : " + getPass() + "\n"
		);
	}
}
