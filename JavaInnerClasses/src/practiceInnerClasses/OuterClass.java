package practiceInnerClasses;

public class OuterClass {

	String outerClassString = "Foo";

	public class InnerClass {

		String innerClassString = "Bar";

		public void printFooBar() {
			System.out.println(outerClassString + " : " + innerClassString);
		}

	}

}
