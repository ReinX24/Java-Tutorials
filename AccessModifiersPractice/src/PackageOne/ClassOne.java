package PackageOne;

import PackageTwo.*;

public class ClassOne {

	protected String protectedStrClassOne = "This is a protected String from ClassOne!";
	
	public static void main(String[] args) {
		ClassThree modifierTest = new ClassThree();
//		System.out.println(modifierTest.defaultStr); // cannot be accessed, default, package level only
		System.out.println(modifierTest.publicStr); // works here even if in another package
//		System.out.println(modifierTest.protectedStr); // must be same package or subclass
	}
}
