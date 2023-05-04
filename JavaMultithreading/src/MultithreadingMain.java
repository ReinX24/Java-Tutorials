
public class MultithreadingMain {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Multithreading = process of executing multiple threads simultaneously.
		 * 
		 * Helps maximum utilization of CPU
		 * 
		 * Threads are independent, the don't affect the execution of other threads.
		 * 
		 * An exception in one thread will not interrupt other threads Useful for
		 * serving mulitple clients, multiplayer games, or other mutually independent
		 * tasks.
		 * 
		 */

		// A way of creating a thread
		MyThread threadOne = new MyThread();

		// Another way of creating a Thread
		MyRunnable runnableOne = new MyRunnable(); // contains instructions
		Thread threadTwo = new Thread(runnableOne); // creating another thread with our runnableOne instructions

		// Setting our Threads to Daemon threads
		threadOne.setDaemon(true);
		threadTwo.setDaemon(true);

		threadOne.start();
//		threadOne.join(3000); // waits for threadOne to finish until threadTwo is executed
		// the number in the parameter is the delay when the second thread will start,
		// will not wait threadOne to finish
		threadTwo.start();

		System.out.println(1 / 0); // causes and exception

		/*
		 * Since our Threads are now Daemon threads, they will stop immediately when the
		 * JVM is stopped by an exception in our main thread
		 */

	}

}
