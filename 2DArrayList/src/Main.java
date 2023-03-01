import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// 2D ArrayList = dynamic list of lists
		// You can change the size of these lists during runtime

		// Creating an ArrayList that accepts ArrayLists of String
		ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>();

		ArrayList<String> bakeryList = new ArrayList<String>();
		bakeryList.add("Pasta");
		bakeryList.add("Garlic Bread");
		bakeryList.add("Donuts");

//		System.out.println(bakeryList);
//		System.out.println(bakeryList.get(0));

		ArrayList<String> produceList = new ArrayList<String>();
		produceList.add("Tomatoes");
		produceList.add("Zucchini");
//		System.out.println(produceList);

		ArrayList<String> drinksList = new ArrayList<String>();
		drinksList.add("Soda");
		drinksList.add("Coffee");
//		System.out.println(drinksList);

		groceryList.add(bakeryList);
		groceryList.add(produceList);
		groceryList.add(drinksList);

		System.out.println(groceryList);
		System.out.println(groceryList.get(0).get(0)); // first element of first list
		System.out.println(groceryList.get(2).get(1)); // last element of last list
	}

}
