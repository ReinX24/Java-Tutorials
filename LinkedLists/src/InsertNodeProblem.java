import java.util.LinkedList;

public class InsertNodeProblem {

	public static void main(String[] args) {

		/*
		 * STEP 1) If Linked list is empty then make the node as head and return it.
		 * 
		 * STEP 2) If value of the node to be inserted is smaller than value of head
		 * node, then insert the node at start and make it head.
		 * 
		 * STEP 3) Find the appropriate node after which the input node is to be
		 * inserted. To find the appropriate node start from head, keep moving until we
		 * reach a node whose value is greater than the input node. The node just before
		 * the node is the appropriate node.
		 * 
		 * STEP 4) Insert the node after the appropriate node found in step 3.
		 */

		int myElement = 13; // our element that we will be inserting

		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

		// Filling the LinkedList with even numbers from 1 to 100
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				myLinkedList.offer(i);
			}
		}

		// DONE STEP 1) If Linked list is empty then make the node as head and return
		// it.
		if (myLinkedList.size() == 0) {
			myLinkedList.offer(myElement);
		} else if (myElement < myLinkedList.getFirst()) {
			// DONE STEP 2) If value of the node to be inserted is smaller than value of
			// head node, then insert the node at start and make it head.
			myLinkedList.addFirst(myElement);
		} else {
			// DONE STEP 3) Find the appropriate node after which the input node is to be
			// inserted. To find the appropriate node start from head, keep moving until we
			// reach a node whose value is greater than the input node. The node just before
			// the node is the appropriate node.
			for (int i = 0; i < myLinkedList.size() - 1; i++) {
				// DONE STEP 4) Insert the node after the appropriate node found in step 3.
				if (myElement < myLinkedList.get(i)) {
					// If our element is less than the current iterated element, place that element
					// before the current iterated element
					myLinkedList.add(i, myElement);
					break;
				}
			}

		}

		// Printing myLinkedList contents to validate results
		System.out.println(myLinkedList);

	}

}
