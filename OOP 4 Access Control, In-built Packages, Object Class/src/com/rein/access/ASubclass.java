package com.rein.access;

public class ASubclass extends A {

	public ASubclass(int aNum, String aString) {
		super(aNum, aString);
	}

	public static void main(String[] args) {
		ASubclass aSubOne = new ASubclass(10, "Rein");
		System.out.println(aSubOne.aArr); // protected access modifier can be accessed by subclasses
	}

}
