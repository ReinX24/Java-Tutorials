
public class Main {
	
	public static void main(String[] args) {
		UserIDsAndPasswords programIDsAndPasswords = new UserIDsAndPasswords();
		
		new LoginPage(programIDsAndPasswords.getIDAndPasswordMap());
	}

}
