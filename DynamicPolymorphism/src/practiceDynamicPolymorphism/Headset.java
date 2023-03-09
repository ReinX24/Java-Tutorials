package practiceDynamicPolymorphism;

public class Headset extends Order {

	@Override
	public void confirmOrder() {
		System.out.println("[Headset Ordered!]");
	}

}
