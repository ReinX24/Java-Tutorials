package com.rein.abstractDemo;

// This is an example of an abstract class, this class can pass on methods that are required in child classes
public abstract class Parent {

	int personAge;

	public Parent(int personAge) {
		this.personAge = personAge;
	}

	abstract void setCareer(String careerName);

	abstract void setPartnet(String partnerName);

	abstract void sayAge();

}
