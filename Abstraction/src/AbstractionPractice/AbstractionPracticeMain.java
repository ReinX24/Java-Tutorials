package AbstractionPractice;

public class AbstractionPracticeMain {
	
	public static void main(String[] args) {
		Student UDD_Rein = new Student("Rein", "Information Technology", 94.21);
		Student UL_Aaliyah = new Student("Aaliyah", "Chemical Engineering", 95.56);
		Student UPANG_Carina = new Student("Carina", "Civil Engineering", 94.11);
		UDD_Rein.askDay();
		UL_Aaliyah.askDay();
		UPANG_Carina.askDay();
	}

}
