
public class InnerClassesMain {

	public static void main(String[] args) {

		/*
		 * inner class = A class inside of another class. useful if a class should be
		 * limited in scope. usually private, but not necessary helps group classes that
		 * belong together extremely useful for listeners for specific events precursor
		 * for anonymous inner classes
		 */

		/* Creating an outer class */
		OutsideClass classOne = new OutsideClass();
		System.out.println(classOne.myOuterString);

		/* Creating an inner class */
		OutsideClass.InsideClass classTwo = classOne.new InsideClass();
		System.out.println(classTwo.myInnerString);

		System.out.println(classOne.myOuterString + ", " + classTwo.myInnerString);
		classTwo.greetUser();
		
	}

}
