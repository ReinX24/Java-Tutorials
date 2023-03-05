package PackageTwo;

import PackageOne.*;

public class ClassThree {

	String defaultStr = "Default String from ClassThree!"; // must be in same package
	public String publicStr = "This is a public String from ClassThree!"; // can be used in all packages
	protected String protectedStr = "This is a protected String from ClassThree!"; // can be used in all subclasses or
																					// if in the same package
	private String privateStr = "This is a private String from ClassThree!"; // only accessible in the same class

	public static void main(String[] args) {
		ClassThree modifierTest = new ClassThree();
		System.out.println(modifierTest.privateStr);
	}

}
