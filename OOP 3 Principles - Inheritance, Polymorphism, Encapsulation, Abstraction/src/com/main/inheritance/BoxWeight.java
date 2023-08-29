package com.main.inheritance;

public class BoxWeight extends Box {
	// this class inherits all the variables and methods from the Box class

	double boxWeight;
//	double classID = 1;

	public BoxWeight() {
		super();// This calls the constructor in the parent class as well
		this.boxWeight = -1;
//		this.boxId = -1; // this is not visible here because boxId is private in the Box class
	}

	public BoxWeight(BoxWeight copyBoxWeight) {
		super(copyBoxWeight); // calls parent class constructor that takes an object as a parameter
		this.boxWeight = copyBoxWeight.boxWeight;
	}

	public BoxWeight(double boxLength, double boxWidth, double boxHeight, double boxWeight) {
		super(boxLength, boxWidth, boxHeight); // calls a constructor for the parent class
		// Used to initialize values that are in the parent class, this points to the
		// parent class directly above the child class
		this.boxWeight = boxWeight;
//		super(boxLength, boxWidth, boxHeight); // this throws an exception, it must be called first in a constructor
	}

	// Constructor that takes boxSide to be used for length, width, and height, and
	// boxWeight
	public BoxWeight(double boxSide, double boxWeight) {
		super(boxSide);
		this.boxWeight = boxWeight;
	}

	@Override
	public void displayBoxInfo() {
		System.out.println("[L: " + this.boxLength + " W: " + this.boxWidth + " H: " + this.boxHeight + " WEIGHT: "
				+ this.boxWeight + "]");
//		System.out.println(super.classID); // this accesses a variable in the parent class
//		System.out.println(this.classID); // this is within this class, prints 1
	}

}
