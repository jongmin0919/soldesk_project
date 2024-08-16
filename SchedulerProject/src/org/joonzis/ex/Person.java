package org.joonzis.ex;

public class Person {
	String name;
	int age;
	double height;
	char gender;
	
	public Person() {
		
	}
	
	public Person(String name, int age, double height, char gender) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
	}
	
	void output() {
		System.out.println(
				"이름 : " + name + "\n" +
				"나이 : " + age + "\n" +
				"키 : " + height + "\n" +
				"성별 : " + gender 
		);
	}
	
}
