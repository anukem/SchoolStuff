//John Anukem
//jea2161
//12/14/2015


public class Person2 implements Comparable<Person2> {

	//Instance variables
	private int birthYear;
	private String name;

	//Constructor
	public Person2(String name, int year) {

		this.name = name;
		birthYear = year;
	}

	//Takes care of the required compareTo method
	public int compareTo(Person2 person) {

		if(birthYear < person.birthYear) {

			return -1;
		}

		else if(birthYear > person.birthYear) {

			return 1;
		}

		else {

			return 0;
		}
	}

	//Used to access name 
	public String toString() {

		return name;
	}

	//Accessor method for birth year.
	public int getBirthYear() {

		return birthYear;
	}
}