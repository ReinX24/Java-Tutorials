
public class MyThread extends Thread {
	
	@Override
	public void run() {
		if (this.isDaemon()) {
			System.out.println("This is a Daemon thread!");
		} else {
			System.out.println("This is a user thread that is running!");
		}
		System.out.println("This thread is running!");
	}

}
