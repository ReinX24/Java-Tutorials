package practiceDynamicPolymorphism;

public class Monitor extends Order {

	@Override
	public void confirmOrder() {
		System.out.println("[Monitor Ordered!]");
	}

}
