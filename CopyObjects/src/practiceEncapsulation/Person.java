package practiceEncapsulation;

public abstract class Person {
	String personName;
	int personAge;

	public Person(String personName, int personAge) {
		this.personName = personName;
		this.personAge = personAge;
	}

	public Person(Person toCopyPerson) {
		this.copyPerson(toCopyPerson);
	}

	public Person() {
		// We need this constructor for an error
	}

	public abstract void sayInfo();

	public abstract void sayGoodbye();

	public String getName() {
		return personName;
	}

	public int getAge() {
		return personAge;
	}

	public void setName(String newName) {
		this.personName = newName;
	}

	public void setAge(int newAge) {
		this.personAge = newAge;
	}

	public void copyPerson(Person toCopyPerson) {
		this.setName(toCopyPerson.getName());
		this.setAge(toCopyPerson.getAge());
	}

}
