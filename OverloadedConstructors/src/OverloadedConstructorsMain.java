
public class OverloadedConstructorsMain {

	public static void main(String[] args) {
		/*
		 * Overloaded Constructors: Multiple constructors within a class with the same
		 * name but have different parameters.
		 * 
		 * Name + Parameters = Signature
		 */

		Pizza pizzaOne = new Pizza();
		System.out.println("Here are the ingredients of your pizza: ");
		System.out.println(pizzaOne.breadPizza);
		System.out.println(pizzaOne.saucePizza);
		System.out.println(pizzaOne.cheesePizza);
		System.out.println(pizzaOne.toppingPizza);
	}

}
