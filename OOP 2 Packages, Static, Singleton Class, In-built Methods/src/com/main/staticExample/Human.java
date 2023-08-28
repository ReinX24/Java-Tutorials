package com.main.staticExample;

public class Human {
	// Instance variables, these are dependent for each object
	int humanAge;
	String humanName;
	int salaryAmount;
	boolean isMarried;
	// Static variable/s, these are independent from the object, these are saved
	// within the class and not the object
	static long currentPopulation;

	public Human(int humanAge, String humanName, int salaryAmount, boolean isMarried) {
		this.humanAge = humanAge;
		this.humanName = humanName;
		this.salaryAmount = salaryAmount;
		this.isMarried = isMarried;
		// One should use the class name whenever accessing a static variable
		Human.currentPopulation++; // increments currentPopulation
		Human.message(); // calls the message method inside this class
	}

	static void message() {
		System.out.println("This is a message from the message class!");
//		System.out.println(this.humanAge); 
		// cannot do this because this needs an object to be called and it is not a
		// static variable
	}

}
