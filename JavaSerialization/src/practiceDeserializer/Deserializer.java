package practiceDeserializer;

import java.io.*;

import practiceSerializer.PracticeUser;

public class Deserializer implements Serializable {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		PracticeUser myUser = null;

		FileInputStream fileIn = new FileInputStream(
				"/home/rein/repos/Bro-Code-Java-Tutorial/JavaSerialization/PracticeUserInfo.ser");
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);

		myUser = (PracticeUser) objectIn.readObject();

		fileIn.close();
		objectIn.close();

		myUser.sayHello();
		myUser.sayUserInfo();
		
		long serialVersionUID = ObjectStreamClass.lookup(myUser.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID);

	}

}
