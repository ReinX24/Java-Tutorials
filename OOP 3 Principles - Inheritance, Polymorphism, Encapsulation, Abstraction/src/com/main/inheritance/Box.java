package com.main.inheritance;

public class Box {
	double boxLength;
	double boxWidth;
	double boxHeight;

	public Box() {
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
