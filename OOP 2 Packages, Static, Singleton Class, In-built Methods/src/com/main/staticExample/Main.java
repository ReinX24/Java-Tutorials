package com.main.staticExample;

public class Main {

	public static void main(String[] args) {
//		Human rein = new Human(20, "Rein", 15000, false);
//		Human nikole = new Human(20, "Nikole", 13000, false);
//		Human sofia = new Human(20, "Sofia", 14000, false);

		// This is not recommended, but it does work
//		System.out.println(rein.currentPopulation);
//		System.out.println(nikole.currentPopulation);
//		System.out.println(sofia.currentPopulation);

		// A better way of accessing static variables
//		System.out.println(Human.currentPopulation);

		// The main static method can only call other static methods
//		fun();

//		Main mainObj = new Main();
//		mainObj.callGreeting();
	}

	// This method calls another instance method
	void callGreeting() {
		System.out.println("greeting() being called...");
		greeting();
	}

	// This is not dependent on objects
	void greeting() {
		System.out.println("Hello world");
//		fun(); // we can call static methods in a non static method
	}

	// This is dependent on objects
	static void fun() {
		System.out.println("Java is fun");
//		greeting();
		// the fun method cannot call the greeting method because it needs an object to
		// call that method since it is an instance method

		// The only way we could access the greeting method is to make an object
		Main mainObj = new Main();
		mainObj.greeting();
	}

}
