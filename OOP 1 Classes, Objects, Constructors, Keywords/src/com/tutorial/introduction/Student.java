package com.tutorial.introduction;

public class Student {

	// Variables that our Student objects will have
	// Default values without being initialized are 0, null, and 0.0
	int studentNumber;
	String studentName;
	float studentMarks;

	// Calling another constructor within our constructor
	public Student() {
		// Default values for Student objects that have no values in their parameter
		this(0, "Default Student", 100.0f); // using the this keyword to call another constructor
	}

	// Constructor for our Student class, these have parameters that initialize our
	// object's values
	// Student myStudent = new Student(1, "Name Here", 85.5f);
	public Student(int studentNumber, String studentName, float studentMarks) {
		// The this keyword refers to the variables in our class
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	// Constructor that copies a student object's attributes
	public Student(Student otherStudent) {
		this.studentNumber = otherStudent.studentNumber;
		this.studentName = otherStudent.studentName;
		this.studentMarks = otherStudent.studentMarks;
	}

	void greeting() {
		System.out.println("Hello! My name is " + this.studentName);
	}

	void changeName(String newName) {
		this.studentName = newName;
	}

}
