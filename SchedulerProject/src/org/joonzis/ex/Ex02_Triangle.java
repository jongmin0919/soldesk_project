package org.joonzis.ex;

public class Ex02_Triangle {
	int width, height;
	
	public Ex02_Triangle() {
		
	}
	
	public Ex02_Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	double calcArea(){
		return (width * height) / 2.0;
	}
	
	void output() {
		System.out.println(
				"너비 : " + width + "cm \n" +
				"높이 : " + height + "cm \n" +
				"넓이 : " + calcArea() + "cm"
		);
	}
	
}
