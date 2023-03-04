
public class Person {

	String personName;
	int personAge;
	
	public Person(String personName, int personAge) {
		this.personName = personName;
		this.personAge = personAge;
	}
	
	public String toString() {
		return this.personName + "\n" + this.personAge + "\n"; 
	}
	
}
