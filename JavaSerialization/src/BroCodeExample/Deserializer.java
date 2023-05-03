package BroCodeExample;

import java.io.*;

public class Deserializer {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		// Steps to Deserialize
		// ---------------------------------------------------------------
		// 1. Your class should implement Serializable interface (User class)
		// 2. add import java.io.Serializable;
		// 3. FileInputStream fileIn = new FileInputStream(file path);
		// 4. ObjectInputStream in = new ObjectInputStream(fileIn);
		// 5. objectNam = (Class) in.readObject();
		// 6. in.close(); fileIn.close();

		User userOne = null;

		FileInputStream fileIn = new FileInputStream(
				"/home/rein/repos/Bro-Code-Java-Tutorial/JavaSerialization/UserInfo.ser");
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);

		userOne = (User) objectIn.readObject();
		objectIn.close();

		System.out.println(userOne.userName + " : " + userOne.userPassword);
		userOne.sayHello();
		
		long serialVersionUID = ObjectStreamClass.lookup(userOne.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID);
		
	}

}
