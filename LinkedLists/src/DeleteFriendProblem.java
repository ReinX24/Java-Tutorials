import java.util.LinkedList;

public class DeleteFriendProblem {

	public static void main(String[] args) {

		// A list of numbers that will act as a popularity score will be given, if the
		// current iterated score is lower than the next score, remove the current
		// iterated score.

		LinkedList<Integer> popularityLinkedList = new LinkedList<Integer>();

		// Filling the list up with random data, will treat as if it is a queue
		popularityLinkedList.offer(19);
		popularityLinkedList.offer(12);
		popularityLinkedList.offer(3);
		popularityLinkedList.offer(4);
		popularityLinkedList.offer(17);

		for (int i = 0; i < popularityLinkedList.size() - 1; i++) {
			System.out.println(popularityLinkedList.get(i));
			// If the number after the current iterated number is higher, delete the current
			// number
			if (popularityLinkedList.get(i) < popularityLinkedList.get(i + 1)) {
				popularityLinkedList.remove(i);
			}
		}

		System.out.println(popularityLinkedList);

	}

}
