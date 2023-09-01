package com.rein.abstractDemo;

// This is an example of an abstract class, this class can pass on methods that are required in child classes
public abstract class Parent {

	int personAge;
	final String LAST_NAME;

	// We can create a constructor but we cannot use it because we cannot create
	// abstract class objects
	public Parent(int personAge) {
		this.personAge = personAge;
		this.LAST_NAME = "Solis";
	}

//	abstract Parent(); // cannot create abstract constructors

	// We can create static methods in abstract classes
	static void sayClass() {
		System.out.println("I am an abstact class (Parent Class)");
	}

	// We cannot call normal methods using this class but we can call it using child
	// classes
	void sayHello() {
		System.out.println("Hello!");
	}

	// If one of the methods are abstract, then the entire class needs to be
	// abstract too
	abstract void setCareer(String careerName);

	abstract void setPartnet(String partnerName);

	abstract void sayAge();

}
