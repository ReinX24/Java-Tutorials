import java.util.*;

public class HashMapPractice {

	public static void main(String[] args) {

		HashMap<String, String> countriesMap = new HashMap<String, String>();

		countriesMap.put("USA", "Washington");
		countriesMap.put("India", "New Delhi");
		countriesMap.put("Russia", "Moscow");
		countriesMap.put("China", "Beijing");
		countriesMap.put("Belgium", "Brussels");
		countriesMap.put("Brazil", "Brasilia");
		countriesMap.put("Finland", "Helsinki");

		// removing a key w/ their value
//		countriesMap.remove("USA");

		// getting the value of a certain key
//		System.out.println(countriesMap.get("India")); // returns the value

		// removing all keys and values
//		countriesMap.clear();
//		System.out.println(countriesMap);

		// printing amount of keys inside the HashMap
//		System.out.println(countriesMap.size());

		// replacing the value of a key inside the HashMap
//		countriesMap.replace("USA", "Florida");

		// checking if our HashMap contains a certain key
//		System.out.println(countriesMap.containsKey("India")); // true
//		System.out.println(countriesMap.containsKey("Philippines")); // false

		// checking if our HashMap contains certain values
//		System.out.println(countriesMap.containsValue("Moscow")); // true
//		System.out.println(countriesMap.containsValue("Manila")); // false

		// prints out the Keys and their Values alphabetically
//		System.out.println(countriesMap);

		// printing our HashMap keys and values in entered order (first is first, last
		// is last)

		for (String i : countriesMap.keySet()) { // stores the key of the map in a String
			
			System.out.println(i + "\t:\t" + countriesMap.get(i)); // gets the value of a certain key
			
		}

	}

}
