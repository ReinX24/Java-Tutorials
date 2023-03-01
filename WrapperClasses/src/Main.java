
public class Main {
	
	public static void main(String[] args) {
		// wrapper class =  provides a way to use primitive data types as reference data types
		//     				reference data types contain useful methods
		//     				can be used with collections (ex.ArrayList)
		  
		//primitive  //wrapper
		//---------  //-------
		// boolean 	Boolean
		// char   	Character
		// int   	Integer
		// double  	Double
		  
		// autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes
		// unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive
		
		// Creating reference data types using autoboxing
		Boolean boolOne = true;
		Character charOne = '$';
		Integer intOne = 123;
		Double doubleOne = 3.14;
		String strOne = "Rein";
		
		System.out.println(boolOne);
		System.out.println(charOne);
		System.out.println(intOne);
		System.out.println(doubleOne);
		System.out.println(strOne);
		
		// unboxing to primitive data types
		if (boolOne == true) {
			System.out.println("This is true!");
		}
	}

}
