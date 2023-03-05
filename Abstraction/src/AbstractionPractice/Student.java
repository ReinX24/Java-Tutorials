package AbstractionPractice;

public class Student extends CourseInfo {

	public Student(String studentName, String studentCourse, double studentAverage) {
		tellName(studentName);
		tellCourse(studentCourse);
		tellAverage(studentAverage);
	}

	@Override
	void tellName(String studentName) {
		System.out.println("Hello! My name is " + studentName);
	}

	@Override
	void tellCourse(String studentCourse) {
		System.out.println("I am studying " + studentCourse);
	}

	@Override
	void tellAverage(double studentAverage) {
		System.out.println("My general average is " + studentAverage);
	}

	@Override
	void askDay() {
		System.out.println("How was your day?");
	}

}
