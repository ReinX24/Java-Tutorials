
public class Main {

	public static void main(String[] args) {
		// Creating a IDandPasswords object to store ids and passwords in a hashmap
		// within the class
		IDandPasswords programIDAndPasswords = new IDandPasswords();

		// Creating a programLoginPage and passing in the hashmap from
		// programIDandPasswords
		new LoginPage(programIDAndPasswords.getLoginInfo());
	}

}
