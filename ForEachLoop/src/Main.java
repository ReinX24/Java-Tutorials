import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		// for-each = 	traversing technique to iterate through the elements in an array/collection
		//				less steps, more readable
		//				less flexible
		
		// Creating an Array of Strings
		String[] animalArr = { "Cat", "Dog", "Rat", "Bird" };
		// Iterating through Array using a for each loop
		for (String eachAnimal : animalArr) {
			System.out.println(eachAnimal);
		}
		
		System.out.println();
		
		// Creating an ArrayList of Strings
		ArrayList<String> animalList = new ArrayList<String>();
		animalList.add("Cat");
		animalList.add("Dog");
		animalList.add("Rat");
		animalList.add("Bird");
		// Printing ArrayList of Strings
		for (String eachAnimalList : animalList) {
			System.out.println(eachAnimalList);
		}
	}

}
