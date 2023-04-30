
public class OutsideClass {

	String myOuterString = "Hello";

	public class InsideClass {

		String myInnerString = "World";

		public void greetUser() {
			// method can user other public variables
			System.out.println(myOuterString + ", " + myInnerString);
		}

	}

}
