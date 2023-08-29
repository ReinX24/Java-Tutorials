package com.main.inheritance;

public class BoxPrice extends BoxWeight {

	double boxCost;

	public BoxPrice() {
		super();
		this.boxCost = -1;
	}

	public BoxPrice(BoxPrice copyBoxPrice) {
		super(copyBoxPrice);
		this.boxCost = copyBoxPrice.boxCost;
	}

	public BoxPrice(double boxSide, double boxWeight, double boxCost) {
		super(boxSide, boxWeight);
		this.boxCost = boxCost;
	}

	public BoxPrice(double boxLength, double boxWidth, double boxHeight, double boxWeight, double boxCost) {
		super(boxLength, boxWidth, boxHeight, boxWeight);
		this.boxCost = boxCost;
	}

	@Override
	public void displayBoxInfo() {
		System.out.println("[L: " + this.boxLength + " W: " + this.boxWidth + " H: " + this.boxHeight + " WEIGHT: "
				+ this.boxWeight + " COST: " + this.boxCost + "]");
	}

}
