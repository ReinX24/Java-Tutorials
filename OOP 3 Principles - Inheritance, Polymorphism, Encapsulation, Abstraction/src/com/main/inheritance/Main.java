package com.main.inheritance;

public class Main {

	public static void main(String[] args) {
//		Box boxOne = new Box(4.6, 7.9, 9.9);
//		boxOne.displayBoxInfo();

//		Box boxTwo = new Box(boxOne);
//		boxTwo.displayBoxInfo();

//		BoxWeight boxWeightOne = new BoxWeight();
//		boxWeightOne.displayBoxInfo();

//		BoxWeight boxWeightTwo = new BoxWeight(2, 3, 4, 8); // l, w, h, weight
//		boxWeightTwo.displayBoxInfo();

		// This Box object is a reference variable pointing to a BoxWeight object but
		// does not contain the BoxWeight variables
//		Box boxThree = new BoxWeight(2, 3, 4, 8); // A parent object referencing to a child object
//		boxThree.displayBoxInfo();
//		System.out.println(boxThree.boxWeight); // this throws an exception
		// The variables that an object can access depends on how the reference variable
		// is created. In this case, the Box object can only access variables that are
		// within that class but it can access methods in the BoxWeight class

		// Cannot call the constructor of the parent class because there are variables
		// in the child class that are not in the parent class
//		BoxWeight boxWeightThree = new Box(2, 3, 4); // this throws an exception because

//		BoxPrice boxPriceOne = new BoxPrice();
//		boxPriceOne.displayBoxInfo();

//		BoxPrice boxPriceTwo = new BoxPrice(2, 3, 4, 8, 20);
//		boxPriceTwo.displayBoxInfo();

//		BoxPrice boxPriceThree = new BoxPrice(5, 8, 200); // side, weight, cost
//		boxPriceThree.displayBoxInfo();

		BoxColor boxColorOne = new BoxColor();
		boxColorOne.displayBoxInfo();

		BoxColor boxColorTwo = new BoxColor(6, 8, "Red");
		boxColorTwo.displayBoxInfo();

	}

}
