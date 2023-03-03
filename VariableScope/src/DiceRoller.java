import java.util.Random;

public class DiceRoller {

	Random randObj;
	int myNumber;

	DiceRoller() {
		randObj = new Random();
		myNumber = 0;
		rollDice(); // method that generates a random number
	}

	void rollDice() {
		myNumber = randObj.nextInt(6) + 1;
		// nextInt creates a random no. >= 0 && < 6. We add 1 to generate a number >= 1
		// && <= 6
		System.out.println(myNumber);
	}

}
