package com.rein.abstractDemo;

public class Daughter extends Parent {

	public Daughter(int daughterAge) {
		super(daughterAge);
	}

	@Override
	void setCareer(String careerName) {
		System.out.println("I am going to be a " + careerName);
	}

	@Override
	void setPartnet(String partnerName) {
		System.out.println("I love " + partnerName);
	}

	@Override
	void sayAge() {
		System.out.println("I am " + this.personAge + " years old");
	}

}
