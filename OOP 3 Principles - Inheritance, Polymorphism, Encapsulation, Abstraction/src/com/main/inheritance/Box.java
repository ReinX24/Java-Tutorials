package com.main.inheritance;

public class Box {

	double boxLength;
	double boxWidth;
	double boxHeight;
//	private double boxId; // this is not passed down to children classes of this class, this can only be
	// used in this class
//	double classID = 0;

	static void greeting() {
		System.out.println("Hey, I am in Box class. Greetings!");
	}
	
	public Box() {
		super(); // this calls the constructor of the Object class, does not do anything for now
		this.boxLength = -1;
		this.boxWidth = -1;
		this.boxHeight = -1;
	}

	// Constructor for creating a cube
	Box(double sideLength) {
		this.boxLength = sideLength;
		this.boxWidth = sideLength;
		this.boxHeight = sideLength;
	}

	public Box(double boxLength, double boxWidth, double boxHeight) {
//		System.out.println("Box class constructor called!");
		this.boxLength = boxLength;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
	}

	Box(Box oldBox) {
		this.boxLength = oldBox.boxLength;
		this.boxWidth = oldBox.boxWidth;
		this.boxHeight = oldBox.boxHeight;
	}

	public void displayBoxInfo() {
		System.out.println("[L: " + this.boxLength + " W: " + this.boxWidth + " H: " + this.boxHeight + "]");
	}

}
