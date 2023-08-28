package com.main.singleClass;

public class Main {

	public static void main(String[] args) {
//		Singleton objOne = new Singleton(); // throws an exception since the constructor is private
		Singleton objOne = Singleton.getInstance();
		Singleton objTwo = Singleton.getInstance();
		Singleton objThree = Singleton.getInstance();

		// All three reference variables are all just pointing to one object
		System.out.println(objOne.toString());
		System.out.println(objTwo.toString());
		System.out.println(objThree.toString()); // all points to the same reference in memory
	}

}
