package practiceJavaThreads;

public class PracticeThread extends Thread {

	@Override
	public void run() {
		if (this.isDaemon()) {
			System.out.println("Daemon thread is running!");
		} else {
			System.out.println("User thread is running!");
		}
		System.out.println("This is another thread");
	}
	
}
