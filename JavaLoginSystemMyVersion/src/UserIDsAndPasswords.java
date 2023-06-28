import java.util.*;
import java.io.*;

public class UserIDsAndPasswords {

	static HashMap<String, String> IDAndPasswordMap = new HashMap<String, String>();

	public UserIDsAndPasswords() {
		// Adding default ids and passwords in our hash map
		IDAndPasswordMap.put("Root", "1234");
		IDAndPasswordMap.put("Bro", "pizza");
		IDAndPasswordMap.put("Rein", "valorant");
		IDAndPasswordMap.put("Nikole", "genshin");

		readIDsAndPasswords(); // gets hash map data in loginData and saves it in IDAndPasswordMap
		saveIDsAndPasswords(); // saves the current content of the hash map
	}

	public HashMap<String, String> getIDAndPasswordMap() {
		return IDAndPasswordMap;
	}

	public static void saveIDsAndPasswords() {
		// Saving hash map to a text file
		try {
			File fileOne = new File("loginData");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(IDAndPasswordMap);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			// Do nothing
		}
	}

	public static void readIDsAndPasswords() {
		// Reading hash map contents in a text file
		try {
			File toRead = new File("loginData");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			@SuppressWarnings("unchecked")
			HashMap<String, String> mapInFile = (HashMap<String, String>) ois.readObject();

			ois.close();
			fis.close();
			// print All data in MAP
			for (Map.Entry<String, String> m : mapInFile.entrySet()) {
				IDAndPasswordMap.put(m.getKey(), m.getValue());
			}
		} catch (Exception e) {
			// Do nothing
		}
	}

}
