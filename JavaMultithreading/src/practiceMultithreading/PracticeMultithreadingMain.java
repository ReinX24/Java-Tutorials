package practiceMultithreading;

public class PracticeMultithreadingMain {

	public static void main(String[] args) throws InterruptedException {

//		System.out.println(1 / 0); // stops the entire program, terminates JVM

		MyThread threadOne = new MyThread();

		RunnableOne runnableOne = new RunnableOne();
		Thread threadTwo = new Thread(runnableOne);

		/*
		 * Daemon threads are threads that run alongside our user threads but the JVM
		 * does not wait for these threads to finish.
		 * 
		 * Daemon threads stop when all of our main threads are finished executing
		 * regardless if the Daemon thread is done with its processes or not.
		 */

		threadOne.setDaemon(false);
		threadTwo.setDaemon(true);

		threadOne.start();
		threadOne.join(5000);
		threadTwo.start(); // stops when threadOne is finished since it is a Daemon thread

//		System.out.println(1 / 0); // stops threadOne and threadTwo since they are both Daemon threads and our main
		// thread is immediately terminated by an exception

	}

}
