import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> loginInfoMap = new HashMap<String, String>();

	public IDandPasswords() {
		loginInfoMap.put("Bro", "pizza");
		loginInfoMap.put("Rein", "valorant");
		loginInfoMap.put("Nikole", "genshin");
	}

	protected HashMap<String, String> getLoginInfo() {
		return loginInfoMap;
	}

}
