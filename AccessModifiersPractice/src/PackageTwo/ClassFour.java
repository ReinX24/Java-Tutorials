package PackageTwo;

import PackageOne.*;

public class ClassFour extends ClassThree {

	public static void main(String[] args) {
		ClassThree modifierTest = new ClassThree();
		System.out.println(modifierTest.defaultStr);
		System.out.println(modifierTest.publicStr);
		System.out.println(modifierTest.protectedStr);
//		System.out.println(modifierTest.privateStr); // can only be accessed in the same class
	}

}
