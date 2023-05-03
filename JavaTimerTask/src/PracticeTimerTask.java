
import java.util.*;
import java.util.spi.CalendarNameProvider;

public class PracticeTimerTask {

	public static void main(String[] args) {

		Timer myTimer = new Timer();

		TimerTask myTimerTask = new TimerTask() {

			int myCounter = 10;

			@Override
			public void run() {
				if (myCounter > 0) {
					System.out.println(myCounter + " seconds");
					myCounter--;
				} else {
					System.out.println("Happy New Year!");
					myTimer.cancel();
				}
			}
		};

//		myTimer.schedule(myTimerTask, 1000); // executes after 1 second

		// What if we want our TimerTask to run at a specified time?
		Calendar myDate = Calendar.getInstance();
		myDate.set(Calendar.YEAR, 2023);
		myDate.set(Calendar.MONTH, Calendar.MAY);
		myDate.set(Calendar.DAY_OF_MONTH, 3);
		myDate.set(Calendar.HOUR_OF_DAY, 18);
		myDate.set(Calendar.MINUTE, 17);
		myDate.set(Calendar.SECOND, 0);
		myDate.set(Calendar.MILLISECOND, 0);

//		myTimer.schedule(myTimerTask, myDate.getTime());

		// Executing our run function for a number of times
//		myTimer.scheduleAtFixedRate(myTimerTask, 1000, 1000); // TimerTask, delay before start, delay each run
		myTimer.scheduleAtFixedRate(myTimerTask, myDate.getTime(), 1000); // starts when myDate is the current date

	}

}
