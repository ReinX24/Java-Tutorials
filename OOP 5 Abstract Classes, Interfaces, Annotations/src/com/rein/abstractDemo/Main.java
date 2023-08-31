package com.rein.abstractDemo;

public class Main {

	public static void main(String[] args) {

		Son sonOne = new Son(20);
		sonOne.setCareer("Software Developer");
		sonOne.setPartnet("Reese");
		sonOne.sayAge();
		
		Daughter daughterOne = new Daughter(25);
		daughterOne.setCareer("Accountant");
		daughterOne.setPartnet("Rain");
		daughterOne.sayAge();
		
	}

}
