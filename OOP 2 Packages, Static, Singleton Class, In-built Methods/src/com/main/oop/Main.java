package com.main.oop;

import com.main.hello.*;

public class Main {

	public static void main(String[] args) {
		Person personOne = new Person("Rein", 20);
		System.out.println(personOne);
		Message.message(); // this is from the Message class within the hello package
	}

}

class Person {
	int personAge;
	String personName;

	public Person(String personName, int personAge) {
		this.personName = personName;
		this.personAge = personAge;
	}

	// Using the @Override to override toString method for this object
	@Override
	public String toString() {
		return this.personName + " : " + this.personAge;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object removed from memory");
	}
}
