package exampleBroCode;

public class MyGenericClass<Thing, Thing2> { // this is a generic class

	Thing x;
	Thing2 y;

	public MyGenericClass(Thing paraThing, Thing2 paraThing2) {
		x = paraThing;
		y = paraThing2;
	}

	public Thing getValue() {
		return x;
	}

	public Thing2 getValue2() {
		return y;
	}

}
