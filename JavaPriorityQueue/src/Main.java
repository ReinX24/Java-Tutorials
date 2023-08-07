import java.util.*;

public class Main {

	public static void main(String[] args) {
		/*
		 * Priority Queue = A FIFO (first in, first out) data structure that serves
		 * elements with the highest priorities first before elements with lower
		 * priority
		 */

//		Queue<Double> myQueue = new LinkedList<>(); // will store elements in order that they were offered
		Queue<Double> myQueue = new PriorityQueue<>(Collections.reverseOrder()); // will store elements from lowest to highest
		// Collections.reverseOrder() makes it so that it now orders elements from highest to lowest
		
		myQueue.offer(3.0);
		myQueue.offer(2.5);
		myQueue.offer(4.0);
		myQueue.offer(1.5);
		myQueue.offer(2.0);

		// Printing queue element then removing the displayed element
//		while (!myQueue.isEmpty()) {
//			System.out.println(myQueue.poll());
//		}
		
		// Queue with String elements, will be in alphabetical order originally
		Queue<String> gradeQueue = new PriorityQueue<>(Collections.reverseOrder());
		// Collections.reverseOrder() makes it so that it now starts at reverse alphabetical order
		
		gradeQueue.offer("B");
		gradeQueue.offer("C");
		gradeQueue.offer("A");
		gradeQueue.offer("F");
		gradeQueue.offer("D");
		
		while (!gradeQueue.isEmpty()) {
			System.out.println(gradeQueue.poll());
		}
		
		
	}

}
