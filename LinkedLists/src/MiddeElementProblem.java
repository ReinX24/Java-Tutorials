import java.util.LinkedList;

public class MiddeElementProblem {

	public static void main(String[] args) {

		/*
		 * The problem we are exploring is to find the middle element of a singly linked
		 * list. For instance, if the linked list is 1 -> 2 -> 3 -> 4 -> 5, then the
		 * middle element is 3. If there are even number of elements in a linked list
		 * such as 1 -> 2 -> 3 -> 4 -> 5 -> 6, then the middle element is 3 and 4
		 */

		LinkedList<Integer> oddSizeLinkedList = new LinkedList<Integer>();
		oddSizeLinkedList.offer(1);
		oddSizeLinkedList.offer(2);
		oddSizeLinkedList.offer(3);
		oddSizeLinkedList.offer(4);
		oddSizeLinkedList.offer(5);

		LinkedList<Integer> evenSizeLinkedList = new LinkedList<Integer>();
		evenSizeLinkedList.offer(1);
		evenSizeLinkedList.offer(2);
		evenSizeLinkedList.offer(3);
		evenSizeLinkedList.offer(4);
		evenSizeLinkedList.offer(5);
		evenSizeLinkedList.offer(6);

		System.out.println(findMiddle(oddSizeLinkedList)); // prints 3
		System.out.println(findMiddle(evenSizeLinkedList)); // prints 3 and 4

	}

	public static String findMiddle(LinkedList<Integer> paraLinkedList) {
		// If there are an odd number of elements
		if (paraLinkedList.size() % 2 != 0) {
			return paraLinkedList.get(paraLinkedList.size() / 2).toString();
		}
		// If there are an even number of elements
		return paraLinkedList.get(paraLinkedList.size() / 2 - 1) + " " + paraLinkedList.get(paraLinkedList.size() / 2);

	}

}
