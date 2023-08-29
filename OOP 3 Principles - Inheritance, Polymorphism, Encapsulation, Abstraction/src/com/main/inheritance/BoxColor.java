package com.main.inheritance;

public class BoxColor extends BoxWeight {

	String boxColor;

	public BoxColor() {
		super();
		this.boxColor = "Brown"; // Brown by default
	}

	public BoxColor(BoxColor copyBoxColor) {
		super(copyBoxColor);
		this.boxColor = copyBoxColor.boxColor;
	}

	public BoxColor(double boxSide, double boxWeight, String boxColor) {
		super(boxSide, boxWeight);
		this.boxColor = boxColor;
	}

	public BoxColor(double boxLength, double boxWidth, double boxHeight, double boxWeight, String boxColor) {
		super(boxLength, boxWidth, boxHeight, boxWeight);
		this.boxColor = boxColor;
	}

	@Override
	public void displayBoxInfo() {
		System.out.println("[L: " + this.boxLength + " W: " + this.boxWidth + " H: " + this.boxHeight + " WEIGHT: "
				+ this.boxWeight + " COLOR: " + this.boxColor + "]");
	}

}
