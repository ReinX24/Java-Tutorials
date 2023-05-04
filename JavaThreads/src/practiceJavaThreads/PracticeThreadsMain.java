package practiceJavaThreads;

public class PracticeThreadsMain {

	public static void main(String[] args) throws InterruptedException {

		// Using methods on our main thread
//		System.out.println(Thread.activeCount()); // shows active threads

		Thread.currentThread().setName("MAIN THREAD");
//		System.out.println(Thread.currentThread().getName());

		Thread.currentThread().setPriority(10);
//		System.out.println(Thread.currentThread().getPriority());

//		System.out.println(Thread.currentThread().isAlive());

//		for (int i = 3; i > 0; i--) {
//			System.out.println(i);
//			Thread.sleep(1000);
//		}
//		
//		System.out.println("Blast off!");

		// Creating a second thread
		PracticeThread thread2 = new PracticeThread();

		thread2.setName("THREAD 2");
//		System.out.println(thread2.getName());

//		thread2.setPriority(5);
//		System.out.println(thread2.getPriority());

		thread2.setDaemon(true);
		System.out.println(thread2.isDaemon()); // returns either true or false

		/*
		 * A Daemon thread runs after all user threads are done executing their
		 * functions
		 */

		thread2.start();
//		System.out.println(thread2.isAlive());

	}

}
