package practiceEncapsulation;

public class PracticeMain {

	public static void main(String[] args) {
		Student studentOne = new Student("Rein", 19, "Information Technology", "UDD");
		Student studentTwo = new Student("Carina", 18, "Civil Engineering", "UPANG");
		Student studentThree = new Student(studentTwo); // copies all attributes of studentTwo
		
		System.out.println(studentOne);
		System.out.println(studentTwo);
		System.out.println(studentThree); // different address from studentTwo
		System.out.println();
		studentOne.sayInfo();
		studentTwo.sayInfo();
		studentThree.sayInfo();
		System.out.println();
		studentOne.sayGoodbye();
		studentTwo.sayGoodbye();
		studentThree.sayGoodbye();
		System.out.println();
		studentOne.copyPerson(studentTwo); // copying the attributes of studentTwo
		System.out.println(studentOne); // same address but different attributes
		studentOne.sayInfo();
	}

}
