
enum Language {

	// Ranking each language by popularity
	Javascript(1), Typescript(2), Python(3), Java(4), PHP(5), Ruby(6), Go(7);

	int rankNum;

	Language(int myNumber) {
		this.rankNum = myNumber;
	}

}

public class EnumProgrammingLanguages {

	public static void main(String[] args) {

		Language myLanguage = Language.Java;

		showRanking(myLanguage);
		
		Language testOne = Language.Javascript;

		showRanking(testOne);
		
		Language testTwo = Language.Go;

		showRanking(testTwo);
		
	}

	public static void showRanking(Language myLanguage) {

		switch (myLanguage) {

		case Java:
			System.out.println("I love " + myLanguage + "!");
			System.out.println("Language Popularity Rank #" + myLanguage.rankNum);
			break;

		case Javascript:
			System.out.println(myLanguage + " is pretty cool!");
			System.out.println("Language Popularity Rank # " + myLanguage.rankNum);
			break;

		default:
			System.out.println("Your language is " + myLanguage + "!");
			System.out.println("Language Popularity Rank #" + myLanguage.rankNum);
			break;

		}

	}

}
