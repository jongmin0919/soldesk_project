package org.joonzis.ex;

public class Ex03_StudentMain {
	public static void main(String[] args) {
		Ex03_StudentManager manager = new Ex03_StudentManager(3);
		manager.addNewStudent(manager.input());
		manager.addNewStudent(manager.input());
		manager.addNewStudent(manager.input());
		manager.outputAllStudents();
		manager.outputAverage();
		manager.output(manager.findStudent());
	}
}
