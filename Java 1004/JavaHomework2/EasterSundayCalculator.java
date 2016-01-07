//*********************
//* John Anukem
//* Paul Blaer
//* September 27th, 2015
// Easter Sunday Calculation
//***********************



//Get the class that allows for user input
import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		//Prompt for the year
		System.out.println("Enter a year: ");
		Scanner userInput = new Scanner(System.in);

		//Implement the algorithm
		int y, a, b, c, d, e, g, h, k, j, m, r, n, p;
		y = userInput.nextInt();
		a = y % 19;
		b = y / 100;
		c = y % 100;
		d = b / 4;
		e = b % 4;
		g = (8 * b + 13) / 25;
		h = (19 * a + b - d - g + 15) % 30;
		j = c / 4;
		k = c % 4;
		m = (a + 11 * h) / 319;
		r = (2 * e + 2 * j - k - h + m + 32) % 7;
		n = (h - m + r + 90) / 25;
		p = (h - m + r + n + 19) % 32;



		//Print the result
		System.out.println("Easter Sunday is on month " + n + " and day " + p);		
	}
}