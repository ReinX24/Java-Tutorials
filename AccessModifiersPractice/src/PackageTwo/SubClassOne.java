package PackageTwo;

import PackageOne.*;

public class SubClassOne extends ClassOne {

	public static void main(String[] args) {

		SubClassOne protectedTest = new SubClassOne();
		System.out.println(protectedTest.protectedStrClassOne); // can only be accessed by creating an object of this
																// class (a subclass of ClassOne)
	}

}
