import java.util.HashMap;

public class UserIDsAndPasswords {

	HashMap<String, String> IDAndPasswordMap = new HashMap<String, String>();

	public UserIDsAndPasswords() {
		// Adding default ids and passwords in our hashmap
		IDAndPasswordMap.put("Root", "1234");
		IDAndPasswordMap.put("Bro", "pizza");
		IDAndPasswordMap.put("Rein", "valorant");
		IDAndPasswordMap.put("Nikole", "genshin");
	}

	public HashMap<String, String> getIDAndPasswordMap() {
		return IDAndPasswordMap;
	}

}
