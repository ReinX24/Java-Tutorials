package practiceDeserializer;

import java.io.*;

public class PracticeUser implements Serializable {

	String userName;
	String userPassword;

	public PracticeUser(String userName, String userPassword) {

		this.userName = userName;
		this.userPassword = userPassword;

	}

	public void sayHello() {
		System.out.println("Hello!");
	}

	public void sayUserInfo() {
		System.out.println(userName + " = " + userPassword);
	}

}
