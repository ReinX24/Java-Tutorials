
public class InterfaceMain {

	public static void main(String[] args) {
		/*
		 * Interface: A template that can be applied to a class. Similar to inheritance,
		 * but specifies what a class has / must do. Classes can apply more than one
		 * interface, inheritance is limited to 1 super.
		 */

		Rabbit rabbitOne = new Rabbit();
		rabbitOne.preyFlee();

		Hawk hawkOne = new Hawk();
		hawkOne.predatorHunt();
		
		Fish fishOne = new Fish();
		fishOne.predatorHunt();
		fishOne.preyFlee();
	}

}
