package com.tutorial.introduction;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Store 5 numbers
//		int[] numbersArr = new int[5];

		// Store 5 Strings
//		String[] namesArr = new String[5];

		// Array that will hold our own custom student objects
		Student[] studentsArr = new Student[5];

		// Declaring a Student object and initializing it using a constructor
		Student rein = new Student(1, "Rein", 85.8f);
		Student nikole = new Student(2, "Nikole", 88.6f);

		// Instantiating Student object values
//		rein.studentNumber = 1;
//		rein.studentName = "Rein";
//		rein.studentMarks = 85.8f;
		
		// Printing Student object values
//		System.out.println(rein.studentNumber);
//		System.out.println(rein.studentName);
//		System.out.println(rein.studentMarks);
		
		rein.greeting();
		rein.changeName("Shoe Lover");
		rein.greeting();
		nikole.greeting();
		
//		System.out.println(Arrays.toString(studentsArr));


	}

}
