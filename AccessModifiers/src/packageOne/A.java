package packageOne;

import packageTwo.*; // imports all classes in packagetTwo

public class A {

	protected String protectedStr = "Protected String from class A!"; // can be accessed by subclasses of A

	public static void main(String[] args) {
		C c = new C();
//		System.out.println(c.defaultStr);
		// cannot be accessed since default variables can only be used in their own
		// packages
		System.out.println(c.publicStr); // can be accessed since public could be accessed through any package
//		System.out.println(c.protectedStr); // cannot be used, not a subclass of C

	}

}
