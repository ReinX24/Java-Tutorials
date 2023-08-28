package com.main.inheritance;

public class BoxWeight extends Box {
	// this class inherits all the variables and methods from the Box class

	double boxWeight;

	public BoxWeight() {
		this.boxWeight = -1;
	}

	public BoxWeight(double boxLength, double boxWidth, double boxHeight, double boxWeight) {
		this.boxLength = boxLength;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.boxWeight = boxWeight;
	}

	public void displayBoxInfo() {
		System.out.println("[L: " + this.boxLength + " W: " + this.boxWidth + " H: " + this.boxHeight + " WEIGHT: "
				+ this.boxWeight + "]");
	}
}
