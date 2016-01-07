//John Anukem
//jea2161
//12/14/2015


import java.util.Scanner;
import java.util.*;
public class Person2Tester {

	public static void main(String[] args) {

		//Make the list of students 
		ArrayList<Student2> listOfStudents = new ArrayList<Student2>();

		for(int i = 0; i < 6; i++) {

			//Populate the list using a Scanner
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the name of the student ");
			String name = in.nextLine();
			System.out.println("Please enter the birth year of the student. ");
			int year = in.nextInt();
			Student2 student = new Student2(name, year, "Computer Science");

			listOfStudents.add(student);	
		}

		//Sort them using the compare to Method
		Collections.sort(listOfStudents);
		for(int i = 0; i < listOfStudents.size(); i++) {

			System.out.println(listOfStudents.get(i));
		}

	}
}