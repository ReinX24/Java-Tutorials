package com.rein.comparingObjects;

// Implementing the Comparable interface for comparing objects
public class Student implements Comparable<Student> {

	int studentNo;
	float studentMarks;

	public Student(int studentNo, float studentMarks) {
		this.studentNo = studentNo;
		this.studentMarks = studentMarks;
	}

	@Override
	public int compareTo(Student o) {
		System.out.println("Running compareTo");
		int diffNum = (int) (this.studentMarks - o.studentMarks);
		return diffNum;
		// if diffNum == 0: both objects have equal value
		// if diffNum < 0: o is bigger, else o is smaller

		// If the diffNum is greater than 0, it would mean that the object that we used
		// the method on is greater than the compared object. If diffNum is not greater
		// than 0, then that would mean that the compared object is greater than the
		// object that we used the compareTo method on. If the diffNum is equal to 0,
		// that means that they have the same value.
	}

	@Override
	public String toString() {
		return studentMarks + "";
	}

}
