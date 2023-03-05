package PackageOne;

import PackageTwo.*;

public class ClassTwo extends ClassOne{
	
	public static void main(String[] args) {
		ClassOne protectedTest = new ClassOne();
		System.out.println(protectedTest.protectedStrClassOne); // must be in same package
	}

}
