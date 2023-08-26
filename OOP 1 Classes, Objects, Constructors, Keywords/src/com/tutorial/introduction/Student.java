package com.tutorial.introduction;

public class Student {
	
	// Variables that our Student objects will have
	// Default values without being initialized are 0, null, and 0.0
	int studentNumber; 
	String studentName;
	float studentMarks;
	
	// Constructor for our Student class, these have parameters that initialize our object's values
	public Student(int studentNumber, String studentName, float studentMarks) {
		// The this keyword refers to the variables in our class
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}
	
	void greeting() {
		System.out.println("Hello! My name is " + this.studentName);
	}
	
	void changeName(String newName) {
		this.studentName = newName;
	}

}
