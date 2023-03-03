
public class Pizza {

	String breadPizza;
	String saucePizza;
	String cheesePizza;
	String toppingPizza;
	
	Pizza() {
		// no attributes are assigned
	}

	Pizza(String breadPizza) {
		this.breadPizza = breadPizza;
	}

	Pizza(String breadPizza, String saucePizza) {
		this.breadPizza = breadPizza;
		this.saucePizza = saucePizza;
	}

	Pizza(String breadPizza, String saucePizza, String cheesePizza) {
		this.breadPizza = breadPizza;
		this.saucePizza = saucePizza;
		this.cheesePizza = cheesePizza;
	}

	Pizza(String breadPizza, String saucePizza, String cheesePizza, String toppingPizza) {
		this.breadPizza = breadPizza;
		this.saucePizza = saucePizza;
		this.cheesePizza = cheesePizza;
		this.toppingPizza = toppingPizza;
	}

}
