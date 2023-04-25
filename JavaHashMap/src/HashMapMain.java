import java.util.*;

public class HashMapMain {

	public static void main(String[] args) {

		// HashMap implements the Map interface (need import)
		// HashMap is similar to ArrayList, but with key-value pairs
		// stores objects, need to use Wrapper Class
		// ex: (name,email),(username,userID),(country,capital)

		// <Data types, only accepts objects>
		HashMap<String, String> countriesMap = new HashMap<String, String>();

		// Adding keys and values to our HashMap - countriesMap
		countriesMap.put("Philippines", "Manila");
		countriesMap.put("USA", "Washington DC");
		countriesMap.put("India", "New Delhi");
		countriesMap.put("Russia", "Moscow");
		countriesMap.put("China", "Beijing");

		// Printing all values in our HashMap
//		 System.out.println(countriesMap);

		// Using different methods that are in the HashMap class
//		countriesMap.remove("USA"); // removing a key
//		System.out.println(countriesMap);

//		System.out.println(countriesMap.get("Russia")); // prints Moscow

//		countriesMap.clear(); // removes all keys and values
//		System.out.println(countriesMap);

//		System.out.println(countriesMap.size()); // amount of elements in our HashMap

//		countriesMap.replace("USA", "Detroit"); // replacing the value of a key
//		System.out.println(countriesMap);

//		System.out.println(countriesMap.containsKey("Philippines"));
//		System.out.println(countriesMap.containsKey("England"));
		
//		System.out.println(countriesMap.containsValue("Manila"));
//		System.out.println(countriesMap.containsValue("Seoul"));
		
		// Printing all our elements using a for loop
		
		for (String i : countriesMap.keySet()) { // Stores the keys at String i
			
			System.out.println(i + "\t=\t" + countriesMap.get(i)); // prints key and value
			
		}
		
	}

}
