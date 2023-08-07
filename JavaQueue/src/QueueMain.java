
// To make use of the Queue interface and LinkedList constructor, we need imports
import java.util.*;

public class QueueMain {

	public static void main(String[] args) {

		/*
		 * Queues are FIFO data structures. First-in First-out (ex. A line of people) A
		 * collection designed for holding elements prior to processing Linear data
		 * structure
		 * 
		 * add = enqueue, offer() remove = dequeue, poll()
		 */

		// Queue is an interface, to finished instantiating we must use LinkedList
		Queue<String> myQueue = new LinkedList<String>();

		System.out.println(myQueue.isEmpty()); // prints true

		myQueue.offer("Karen");
		myQueue.offer("Chad");
		myQueue.offer("Steve");
		myQueue.offer("Harold");

//		System.out.println(myQueue.isEmpty()); // prints false
//		System.out.println(myQueue.size()); // prints 4
//		System.out.println(myQueue);
		
		System.out.println(myQueue.contains("Harold")); // prints true

		// Using the peek() method to look at the head of our queue
//		System.out.println(myQueue.peek());

		// Using the poll() method to remove the head of our queue
		myQueue.poll();
		myQueue.poll();
		myQueue.poll();
		myQueue.poll();
		myQueue.poll(); // will not throw an exception
		myQueue.element(); // causes and exception
		System.out.println(myQueue);

	}

}
