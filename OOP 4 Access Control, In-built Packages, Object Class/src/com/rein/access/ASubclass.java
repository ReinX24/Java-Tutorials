package com.rein.access;

public class ASubclass extends A {

	public ASubclass(int aNum, String aString) {
		super(aNum, aString);
	}

	public static void main(String[] args) {
		ASubclass aSubOne = new ASubclass(10, "Rein");
		System.out.println(aSubOne.aArr); // protected access modifier can be accessed by subclasses

		// Checking if this object is an instance of different classes
		System.out.println(aSubOne instanceof A); // true
		System.out.println(aSubOne instanceof ASubclass); // true
		System.out.println(aSubOne instanceof Object); // true

	}

}
