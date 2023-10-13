package com.rein.teluskogenerics;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

//		Container<Integer> containerOne = new Container<>();

//		containerOne.setValue(5);
//		containerOne.showType();

		Container<Double> containerTwo = new Container<>();

//		containerTwo.setValue(5.5);
//		containerTwo.showType();

		// Throws an error because Container only accepts Numbers
//		Container<String> containerThree = new Container<>(); 

		containerTwo.printGenericList(new ArrayList<Integer>()); // this works
		containerTwo.printGenericList(new ArrayList<Double>());
		
//		containerTwo.printGenericList(new ArrayList<String>()); // throws an error
		
	}

}
