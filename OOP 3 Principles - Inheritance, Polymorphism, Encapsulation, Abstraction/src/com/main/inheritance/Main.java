package com.main.inheritance;

public class Main {

	public static void main(String[] args) {
//		Box boxOne = new Box(4.6, 7.9, 9.9);
//		boxOne.displayBoxInfo();
//
//		Box boxTwo = new Box(boxOne);
//		boxTwo.displayBoxInfo();

		BoxWeight boxWeightOne = new BoxWeight();
		boxWeightOne.displayBoxInfo();
		
		BoxWeight boxWeightTwo = new BoxWeight(2, 3, 4, 8); // l, w, h, weight
		boxWeightTwo.displayBoxInfo();

	}

}
