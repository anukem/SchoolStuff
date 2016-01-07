//*********************
//* John Anukem
//* Paul Blaer
//* September 27th, 2015
// Degree Converter
//***********************
import java.util.Scanner;

public class DegreeConverter {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//user selects conversion
		System.out.println("Please enter a 1 for Farenheit to Celcius");
		System.out.print("Please enter a 2 for Celcius to Farenheit ");
		int choice = userInput.nextInt();
		
		//farenheit to celcius
		if (choice == 1) {
			System.out.print("Please enter a number to convert. ");
			int farenNum = userInput.nextInt();
			int celciusNum = (farenNum - 32) * 5/9;
			System.out.println("This is " + celciusNum + "degrees Celcius.");
		}
		
		//celcius to farenheit
		if (choice == 2) {
			System.out.print("Please enter a number to convert. ");
			int celciusNum = userInput.nextInt();
			int farenNum = celciusNum * 9/5 + 32;
			System.out.println("This is " + farenNum + " degrees Farenheit");
			
		}
	}
}
