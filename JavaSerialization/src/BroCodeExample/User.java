package BroCodeExample;

import java.io.Serializable;

public class User implements Serializable {

	// ---------------------------------------------------------------
	// important notes
	// 1. children classes of a parent class that implements
	// Serializable will do so as well
	// 2. static fields are not serialized (they belong to the class, not an
	// individual object)
	// 3. Fields declared as "transient" aren't serialized, they're ignored
	// 4. the class's definition ("class file") itself is not recorded, cast it as
	// the object type
	// 5. serialVersionUID is a unique version ID

	private static final long serialVersionUID = 1L;
	
	String userName;
	transient String userPassword; // not saved in our .ser file

	public void sayHello() {
		System.out.println("Hello " + userName);
	}

}
