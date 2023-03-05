package packageTwo;

import packageOne.*;

public class C {

	String defaultStr = "This is a default String"; // should be in the same package
	public String publicStr = "This is a public String"; // can be used in other packages
	protected String protectedStr = "This is a protected String"; // can only be called by subclasses, E
	private String privateStr = "This is a private String"; // can only be visible in this classes

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.privateStr);
	}

}
