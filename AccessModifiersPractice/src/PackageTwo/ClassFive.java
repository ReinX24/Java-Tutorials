package PackageTwo;

import PackageOne.*;

public class ClassFive {

	public static void main(String[] args) {
		ClassThree modifierTest = new ClassThree();
		System.out.println(modifierTest.protectedStr);
	}

}
