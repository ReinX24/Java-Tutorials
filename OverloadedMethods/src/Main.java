
public class Main {
	
	public static void main(String[] args) {
		// overloaded methods = methods that share the same name but have different parameters
		//						method name + parameters = method signature

		int x = addNum(1, 2, 3, 4);
		System.out.println(x);

		System.out.println(addNum(6, 3));
		System.out.println(addNum(5, 8, 2));
		System.out.println(addNum(7, 1, 3, 9));
		
		double y = addNum(1.5, 1.6, 5.5, 6.2);
		System.out.println(y);
	}

	static int addNum(int a, int b) {
		System.out.println("Overloaded Method #1");
		return a + b;
	}

	static int addNum(int a, int b, int c) {
		System.out.println("Overloaded Method #2");
		return a + b + c;
	}

	static int addNum(int a, int b, int c, int d) {
		System.out.println("Overloaded Method #3");
		return a + b + c + d;
	}

	static double addNum(double a, double b) {
		System.out.println("Overloaded Method #4");
		return a + b;
	}

	static double addNum(double a, double b, double c) {
		System.out.println("Overloaded Method #5");
		return a + b + c;
	}

	static double addNum(double a, double b, double c, double d) {
		System.out.println("Overloaded Method #6");
		return a + b + c + d;
	}

}
