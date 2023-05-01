package exampleBroCode;

public class NumberGenericClass<Thing extends Number, Thing2> { // first parameter only accepts Numbers

	Thing myNumber;
	Thing2 y;

	public NumberGenericClass(Thing paraThing, Thing2 paraThing2) {
		myNumber = paraThing;
		y = paraThing2;
	}

	public Thing getValue() {
		return myNumber;
	}

	public Thing2 getValue2() {
		return y;
	}

}
