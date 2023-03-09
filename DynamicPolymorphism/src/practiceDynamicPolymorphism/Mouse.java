package practiceDynamicPolymorphism;

public class Mouse extends Order {

	@Override
	public void confirmOrder() {
		System.out.println("[Mouse Ordered!]");
	}

}
