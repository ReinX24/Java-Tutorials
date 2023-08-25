import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		// Hash Tables have two parameters, a key and a value
//		Hashtable<String, String> myTable = new Hashtable<>(10, 0.5f); // setting capacity and load factor, once the
																		// hash table reaches 50% capacity, it will then
																		// increase its size
		Hashtable<String, String> myTable = new Hashtable<>(21);
		myTable.put("100", "Spongebob");
		myTable.put("123", "Patrick");
		myTable.put("321", "Sandy");
		myTable.put("555", "Squidward");
		myTable.put("777", "Gary");

//		myTable.remove(777); // removes the key and value of 777

		// Iterating through all of our keys in our hash table and their values, starts
		// at the most recently added value
		// The index of our entries are its key % 10
		for (String eachKey : myTable.keySet()) {
			System.out.println(eachKey.hashCode() % 21 + "\t" + eachKey + "\t" + myTable.get(eachKey));
		}

	}

}
