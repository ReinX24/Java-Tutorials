package com.rein.comparingObjects;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Student reinStudent = new Student(1, 91.5f);
		Student claraStudent = new Student(2, 88.6f);
		Student mariaStudent = new Student(3, 87.6f);
		Student reeseStudent = new Student(4, 85.6f);
		Student jadeStudent = new Student(5, 89.6f);
		Student aliceStudent = new Student(6, 82.6f);

		Student[] studentArr = { reinStudent, claraStudent, mariaStudent, reeseStudent, jadeStudent, aliceStudent };

		System.out.println(Arrays.toString(studentArr));
		Arrays.sort(studentArr); // sorts the Student objects using the compareTo method, using their marks
		System.out.println(Arrays.toString(studentArr));

		// Prints the statement because reinStudent has higher marks than Clara
//		if (reinStudent.compareTo(claraStudent) > 0) {
//			System.out.println(reinStudent.compareTo(claraStudent));
//			System.out.println("Rein has more marks then Clara");
//		}

	}

}
