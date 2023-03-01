
public class Main {

	public static void main(String[] args) {
		// 2D array = an array of arrays
//		String[][] carArr = new String[3][3]; // 3 arrays w/ 3 elements per array
//		carArr[0][0] = "Camaro";
//		carArr[0][1] = "Corvette";
//		carArr[0][2] = "Silverado";
//		carArr[1][0] = "Mustang";
//		carArr[1][1] = "Ranger";
//		carArr[1][2] = "F-150";
//		carArr[2][0] = "Ferrari";
//		carArr[2][1] = "Lambo";
//		carArr[2][2] = "Tesla";

		// Another way of instantiating the array
		String[][] carArr = { 
					{ "Camaro", "Corvette", "Silverado" }, 
					{ "Mustang", "Ranger", "F-150" },
					{ "Ferrari", "Lambo", "Tesla" } 
				};

		// Iterating through each outer array
		for (int i = 0; i < carArr.length; i++) {
			System.out.println();
			// Iterating through each inner array
			for (int j = 0; j < carArr[i].length; j++) {
				System.out.printf("%-10s", carArr[i][j]);
			}
		}
	}

}
