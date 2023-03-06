
public class Fish implements Prey, Predator { // implements 2 interfaces

	@Override
	public void predatorHunt() {
		System.out.println("*The fish is hunting smaller fish!*");
	}

	@Override
	public void preyFlee() {
		System.out.println("*The fish is fleeing from a larger fish!*");
	}

}
