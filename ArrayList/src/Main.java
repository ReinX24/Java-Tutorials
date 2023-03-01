import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {


		// ArrayList = 	a resizable array. 
		//				Elements can be added and removed after compilation phase
		//				store reference data types
		
		// Can only contain reference types
		ArrayList<String> foodList = new ArrayList<String>();
		foodList.add("Banana");
		foodList.add("Apple");
		foodList.add("Strawberry");
		foodList.add("Pizza");
		foodList.add("Hamburger");
		foodList.add("Hotdog");
		// set method
		foodList.set(0, "Peanuts"); // replaces index 0 element
		// remove method
		foodList.remove(2); // removes element at index 2
		
		// Printing the ArrayList
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println(foodList.get(i));
		}
		
		// clears the ArrayList
		foodList.clear();
		// Printing ArrayLists
		System.out.println(foodList);
	}
	
}
