package practiceDynamicPolymorphism;

public class Mousepad extends Order {

	@Override
	public void confirmOrder() {
		System.out.println("[Mousepad Ordered!]");
	}

}
