import TextTools.PrintText;
import Tools.Toolbox; // importd Toolbox class

public class JavaPackagesMain {

	public static void main(String[] args) {

		Toolbox myToolBox = new Toolbox(); // creates a Toolbox object from our Tools package

		myToolBox.useHammer();
		myToolBox.useScrewDriver();

		/*
		 * What if we want to create an object that is in another package? we import
		 * than package so that we could create our desired object.
		 * 
		 */

		// Creating a PrintText object from our TextTools package
		PrintText testTextOne = new PrintText("Hello, World!");

		testTextOne.printUpperCase();
		testTextOne.printLowerCase();

	}

}
