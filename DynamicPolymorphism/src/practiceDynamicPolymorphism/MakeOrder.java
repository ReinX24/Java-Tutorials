package practiceDynamicPolymorphism;

import java.util.Scanner;

public class MakeOrder {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Order userOrder;

		System.out.println("[Select Order Type]");
		System.out.println("[1 - Keyboard]");
		System.out.println("[2 - Mouse]");
		System.out.println("[3 - Headset]");
		System.out.println("[4 - Mousepad]");
		System.out.println("[5 - Monitor]");
		System.out.print("Enter order number: ");
		int orderNum = userInput.nextInt();

		switch (orderNum) {
		case 1:
			userOrder = new Keyboard();
			userOrder.confirmOrder();
			break;
		case 2:
			userOrder = new Mouse();
			userOrder.confirmOrder();
			break;
		case 3:
			userOrder = new Headset();
			userOrder.confirmOrder();
			break;
		case 4:
			userOrder = new Mousepad();
			userOrder.confirmOrder();
			break;
		case 5:
			userOrder = new Monitor();
			userOrder.confirmOrder();
			break;
		default:
			System.out.println("[Not a valid order number!]");
			break;
		}

		userInput.close();
	}

}
