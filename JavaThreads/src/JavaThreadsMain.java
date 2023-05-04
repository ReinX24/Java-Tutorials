
public class JavaThreadsMain {

	public static void main(String[] args) {

		/*
		 * thread = A thread of execution in a program (kind of like a virtual CPU) The
		 * JVM allows an application to have multiple threads running concurrently Each
		 * thread can execute parts of you code in parallel with the main thread Each
		 * thread has a priority. Threads with higher priority are executed in
		 * preference compared to threads with a lower priority
		 * 
		 * The Java Virtual Machine continues to execute threads until either of the
		 * following occurs
		 * 
		 * 1. The exit method of class Runtime has been called 2. All user threads have
		 * died
		 * 
		 * When a JVM starts up, there is a thread which calls the main method This
		 * thread is called “main”
		 * 
		 * Daemon thread is a low priority thread that runs in background to perform
		 * tasks such as garbage collection
		 * 
		 * JVM terminates itself when all user threads (non-daemon threads) finish their
		 * execution
		 */

		// Main thread

//		System.out.println(Thread.activeCount()); // prints active threads
//		Thread.currentThread().setName("MAIN THREAD"); // sets the name of our current thread
//		System.out.println(Thread.currentThread().getName()); // returns the name of our main thread

//		Thread.currentThread().setPriority(1); // sets the priority of our thread
//		System.out.println(Thread.currentThread().getPriority()); 
		// ^shows the priority of our Thread, 1 (lowest) - 10 (highest)

//		System.out.println(Thread.currentThread().isAlive()); // checks if our current thread is alive

//		for (int i = 3; i > 0; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000); // pauses for 1 second
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		System.out.println("You are done!");

		// Creating a second thread along our main thread
		MyThread threadTwo = new MyThread();

//		System.out.println(threadTwo.isAlive()); // returns false
//		threadTwo.start(); // starts our second thread, executes the run function
//		System.out.println(threadTwo.isAlive()); // returns true

//		System.out.println(threadTwo.getName()); // Thread-0
//		threadTwo.setName("THREAD TWO");
//		System.out.println(threadTwo.getName());

//		System.out.println(threadTwo.getPriority()); // inherits priority from main thread, default is 5
//		threadTwo.setPriority(10);
//		System.out.println(threadTwo.getPriority());

//		System.out.println(threadTwo.isDaemon()); // not a Daemon thread
		threadTwo.setDaemon(true);
		System.out.println(threadTwo.isDaemon());

		/*
		 * A Daemon thread is a thread that executes after all our user threads are done
		 * executing their functions
		 */

		threadTwo.start();

//		System.out.println(Thread.activeCount());

	}

}
