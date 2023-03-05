package practiceEncapsulation;

public class Student extends Person {

	String personCourse;
	String personSchool;

	public Student(String personName, int personAge, String personCourse, String personSchool) {
		super(personName, personAge); // calling constructor from Person class
		this.setCourse(personCourse);
		this.setSchool(personSchool);
	}

	// Copy attributes of one student when creating a Student class
	public Student(Student toCopyStudent) {
		this.copyStudent(toCopyStudent);
	}

	@Override
	public void sayInfo() {
		System.out.println("Hi! My name is " + super.getName() + ".");
		System.out.println("I am " + super.getAge() + " years old!");
		System.out.println("I am currently in the course " + this.getCourse());
		System.out.println("I am studying at " + this.getSchool());
	}

	@Override
	public void sayGoodbye() {
		System.out.println("Goodbye! It was nice meeting you.");
	}

	public String getName() {
		return super.getName(); // getName method of Person class
	}

	public int getAge() {
		return super.getAge();
	}

	public String getCourse() {
		return personCourse;
	}

	public String getSchool() {
		return personSchool;
	}

	public void setName(String newName) {
		super.setName(newName);
	}

	public void setAge(int newAge) {
		super.setAge(newAge);
	}

	public void setCourse(String newCourse) {
		this.personCourse = newCourse;
	}

	public void setSchool(String newSchool) {
		this.personSchool = newSchool;
	}

	// Copies all the attributes of one Student (in parameter) to another Student
	public void copyStudent(Student toCopyStudent) {
		super.setName(toCopyStudent.getName());
		super.setAge(toCopyStudent.getAge());
		this.setCourse(toCopyStudent.getCourse());
		this.setSchool(toCopyStudent.getSchool());
	}

}
