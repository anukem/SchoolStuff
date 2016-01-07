//John Anukem
//jea2161
//12/14/2015



public class Student extends Person {

	//Instance variable
	private String major;

	//Constructor
	public Student(String name, int year, String major) {

		super(name, year);
		this.major = major;


	}

	//Returns a string representation of the Student Object
	public String toString() {

		return super.toString() + " majors in " + major;

	}
}