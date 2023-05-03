
import java.util.*;

public class TimerTaskMain {

	public static void main(String[] args) {

		// Timer = A facility for threads to schedule tasks
		// for future execution in a background thread

		// TimerTask = A task that can be scheduled for one-time
		// or repeated execution by a Timer

		Timer myTimer = new Timer();

		TimerTask myTimerTask = new TimerTask() {

			int myCounter = 10;

			@Override
			public void run() { // runs when myTimer is out of time
				if (myCounter > 0) {
					System.out.println(myCounter + " seconds");
					myCounter--;
				} else {
					System.out.println("Happy New Year!");
					myTimer.cancel();
				}

			}

		};

//		myTimer.schedule(myTimerTask, 3000); // TimerTask, time delay in milliseconds

		Calendar myDate = Calendar.getInstance();
		myDate.set(Calendar.YEAR, 2023); // setting our Calendar date
		myDate.set(Calendar.MONTH, Calendar.MAY);
		myDate.set(Calendar.DAY_OF_MONTH, 3);
		myDate.set(Calendar.HOUR_OF_DAY, 18);
		myDate.set(Calendar.MINUTE, 1);
		myDate.set(Calendar.SECOND, 0);
		myDate.set(Calendar.MILLISECOND, 0);

//		myTimer.schedule(myTimerTask, myDate.getTime()); // runs when myDate is the current time

		// Repeatedly call our TimerTask method
//		myTimer.scheduleAtFixedRate(myTimerTask, 1000, 1000); // TimerTask, delay before starting, how often
		myTimer.scheduleAtFixedRate(myTimerTask, myDate.getTime(), 1000);

	}

}
