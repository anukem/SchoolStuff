//John Anukem
//jea2161
//12/14/2015



public class Student2 extends Person2 {

	//Instance variables
	private String major;

	public Student2(String name, int year, String major) {

		//Uses the super class constructor
		super(name, year);
		this.major = major;


	}

	//Returns a string representation for the Student2 object
	public String toString() {

		return super.toString() + " majors in " + major + " and was born in " + Integer.toString(super.getBirthYear());

	}
}