//John Anukem
//jea2161
//12/14/2015


public class PersonTester {

	public static void main(String[] args) {

	//Hardcode the different classes to be tested
	Person lilGucci = new Person("Braxton Gunter", 1996);
	Student greatestEver = new Student("John Anukem", 1996, "Computer Science and Phlososphy");
	Instructor pbAndJ = new Instructor("Paul Blaer", 1964, 213456);

	//Make use of their toString methods.
	System.out.println(lilGucci.toString());	
	System.out.println(greatestEver.toString());	
	System.out.println(pbAndJ.toString());	

	


	}
	

}