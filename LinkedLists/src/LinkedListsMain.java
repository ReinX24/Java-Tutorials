import java.util.LinkedList;

public class LinkedListsMain {

	public static void main(String[] args) {

		LinkedList<String> myLinkedList = new LinkedList<String>();

//		Treating the LinkedList as a stack
//		myLinkedList.push("A");
//		myLinkedList.push("B");
//		myLinkedList.push("C");
//		myLinkedList.push("D");
//		myLinkedList.push("F");
//		
//		myLinkedList.pop(); // removes last added element

//		Prints as if it is a stack, the last added element will be the first
//		System.out.println(myLinkedList);

//		Treating the LinkedList as a queue
		myLinkedList.offer("A");
		myLinkedList.offer("B");
		myLinkedList.offer("C");
		myLinkedList.offer("D");
		myLinkedList.offer("F");

//		myLinkedList.poll(); // removes first element

		// Adding a node between D and F
		myLinkedList.add(4, "E"); // index of where it will be added, the contents of the element

		// Removing a node
		myLinkedList.remove("F");

//		Prints as if it is a queue, first added element will be first
//		System.out.println(myLinkedList);
//		System.out.println(myLinkedList.indexOf("E")); // prints 4
//		System.out.println(myLinkedList.peekFirst()); // prints the first element
//		System.out.println(myLinkedList.peekLast()); // prints the last element

		myLinkedList.addFirst("0"); // adds a node at the start of the Linked List
		myLinkedList.addLast("G");
//		System.out.println(myLinkedList);

		// Removing first and last element and storing them in a variable
		String firstElement = myLinkedList.removeFirst();
		String lastElement = myLinkedList.removeLast();

		System.out.println(myLinkedList);
		System.out.println(firstElement);
		System.out.println(lastElement);
	}

}
