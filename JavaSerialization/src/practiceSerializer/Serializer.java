package practiceSerializer;

import java.io.*;

public class Serializer {

	public static void main(String[] args) throws IOException {

		PracticeUser myUser = new PracticeUser("Rein", "1337");

		FileOutputStream fileOut = new FileOutputStream("PracticeUserInfo.ser");
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

		objectOut.writeObject(myUser);

		fileOut.close();
		objectOut.close();

		System.out.println("[Object Saved!]");
		
		myUser.sayHello();
		myUser.sayUserInfo();

		long serialVersionUID = ObjectStreamClass.lookup(myUser.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID);

	}

}
