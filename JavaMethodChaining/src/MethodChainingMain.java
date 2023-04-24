
public class MethodChainingMain {

	public static void main(String[] args) {

		// method chaining = a common syntax for invoking multiple method calls in OOP
		// condense code into less lines
		
		String myName = "Rein";
		
		// .concat() adds text
		myName = myName.concat(" Champ           ");
		
		// makes String all upper case
		myName = myName.toUpperCase();
		
		// removes white spaces before and after String
		myName = myName.trim();
		
		System.out.println(myName);
		
		// condensing all methods into one line
		
		String nameOne = "Nikole";
		
		// using all the methods above in one line using method chaining
		nameOne = nameOne.concat(" Champ     ").toUpperCase().trim();
		
		System.out.println(nameOne);

	}

}
