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

	public static void saveNewHashMap(String newUserNameString, String newUserPasswordString) {
		UserIDsAndPasswords.IDAndPasswordMap.put(newUserNameString, newUserPasswordString);
		UserIDsAndPasswords.saveIDsAndPasswords();
		UserIDsAndPasswords.readIDsAndPasswords();
	}

	public static void saveIDsAndPasswords() {
		// Saving hash map to a text file
		try {
			File savedFile = new File("loginData"); // File object to save hash map data
			FileOutputStream fileOutput = new FileOutputStream(savedFile); // FileOutputStream object for saving file
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput); // ObjectOutputStream for saving hash
																					// map data

			// Writing our hash map to our object output
			objectOutput.writeObject(IDAndPasswordMap);
			objectOutput.flush(); // clears buffers when saving

			objectOutput.close();
			fileOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readIDsAndPasswords() {
		// Reading hash map contents in a text file
		try {
			File fileToRead = new File("loginData");
			FileInputStream fileInput = new FileInputStream(fileToRead);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);

			// Copying hash map data in file to a hash map
			@SuppressWarnings("unchecked")
			HashMap<String, String> mapInFile = (HashMap<String, String>) objectInput.readObject();

			objectInput.close();
			fileInput.close();

			// copying all data in hash map
			for (Map.Entry<String, String> m : mapInFile.entrySet()) {
				IDAndPasswordMap.put(m.getKey(), m.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
