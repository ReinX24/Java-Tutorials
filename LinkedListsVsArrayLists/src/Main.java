
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();

		// Variables that will store times
		long startTime;
		long endTime;
		long elapsedTime;

		for (int i = 0; i < 1000000; i++) {
			myLinkedList.add(i);
			myArrayList.add(i);
		}

		// LinkedList
		startTime = System.nanoTime(); // gets current time of the JVM in nanoseconds

		// Main functions
//		myLinkedList.get(0);
//		myLinkedList.get(500000);
//		myLinkedList.get(999999);
//		myLinkedList.remove(0);
//		myLinkedList.remove(500000);
		myLinkedList.remove(999999);

		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("LinkedList:\t" + elapsedTime + "ns");

		// ArrayList
		startTime = System.nanoTime(); // gets current time of the JVM in nanoseconds

		// Main functions
//		myArrayList.get(0); // ArrayList faster for getting first object
//		myArrayList.get(500000); // Faster for getting a random object
//		myArrayList.get(999999); // Faster for getting last object
//		myArrayList.remove(0); // Slower than LinkedList
//		myArrayList.remove(500000); // Faster than LinkedList
		myArrayList.remove(999999); // Faster than LinkedList

		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("ArrayList:\t" + elapsedTime + "ns");

		// Conclusion: only used LinkedLists when you plan on removing the first
		// element. For other cases, it's much better to use ArrayLists.

	}

}
