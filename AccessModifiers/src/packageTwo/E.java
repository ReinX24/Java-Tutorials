package packageTwo;

public class E extends C {
	
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.protectedStr); // accessible
	}

}
