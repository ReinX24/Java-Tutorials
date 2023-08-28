package com.main.singleClass;

public class Singleton { // this is a class where we can only create 1 object of the class

	// We do not want people to access this constructor. We set it to private so
	// that it could only be called in this class
	private Singleton() {

	}

	private static Singleton instance; // this will be the only object that any created Singleton objects will refer to

	public static Singleton getInstance() {
		// Checking if only an object is already created or not
		if (instance == null) {
			System.out.println("Singleton object created!"); // will only run once even if we create multiple objects
			instance = new Singleton(); // we can call the constructor here because it is in the same file
		}
		return instance;
	}
}
