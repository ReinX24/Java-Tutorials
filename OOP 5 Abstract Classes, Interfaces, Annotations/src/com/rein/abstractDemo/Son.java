package com.rein.abstractDemo;

public class Son extends Parent {

	public Son(int sonAge) {
		super(sonAge);
	}

	// We are required to have this method in this class because Parent and this
	// method are abstract
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
