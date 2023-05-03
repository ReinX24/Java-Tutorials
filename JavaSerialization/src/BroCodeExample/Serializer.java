package BroCodeExample;

import java.io.*;

public class Serializer {

	public static void main(String[] args) throws IOException {

		// Steps to Serialize
		// ---------------------------------------------------------------
		// 1. Your class should implement Serializable interface
		// 2. add import java.io.Serializable;
		// 3. FileOutputStream fileOut = new FileOutputStream(file path)
		// 4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
		// 5. out.writeObject(objectName)
		// 6. out.close(); fileOut.close();
		// ---------------------------------------------------------------

		User userOne = new User();

		userOne.userName = "ReinX24";
		userOne.userPassword = "5634893";

//		userOne.sayHello();

		FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
		ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);

		streamOut.writeObject(userOne);

		fileOut.close();
		streamOut.close();

		System.out.println("Object Info Saved!");

		// SerialVersionUID = serialVersionUID is a unique ID that functions like a
		// version #
		// verifies that the sender and receiver of a serialized object,
		// have loaded classes for that object that are compatible
		// Ensures object will be compatible between machines
		// Number must match. otherwise this will cause a InvalidClassException
		// A SerialVersionUID will be calculated based on class properties, members,
		// etc.
		// A serializable class can declare its own serialVersionUID explicitly
		// (recommended)
		
		long serialVersionUID = ObjectStreamClass.lookup(userOne.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID);
		
	}

}
