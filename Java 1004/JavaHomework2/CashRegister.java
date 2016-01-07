//*********************
//* John Anukem
//* Paul Blaer
//* September 27th, 2015
// Cash Register
//***********************



import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//Get the cost and money received and calculate change
		System.out.print("Please enter the amount due ");
		int cost = userInput.nextInt();
		System.out.print("Please enter the amount recieved ");
		int amountRecieved = userInput.nextInt();
		int change = amountRecieved - cost;
		
		//in the case that not enough was given
		if (cost > amountRecieved) {
			System.out.print("You haven't paid the full amount.");
		}
		
		//Here I divide the respective currency out
		//and modulo to get the remainder until I have 
		//only pennies left
		else {
			int dollars, quarters, dimes, nickels, pennies;
			dollars = change/100;
			change = change % 100;
			quarters = change/25;
			change = change%25;
			dimes = change/10;
			change = change % 10;
			nickels = change/5;
			change = change%5;
			pennies = change;
			
			//Print the result
			System.out.println("Your change is ");
			System.out.println(dollars + " Dollars");
			System.out.println(quarters + " Quarters");
			System.out.println(dimes + " Dimes");
			System.out.println(nickels + " Nickels");
			System.out.println(pennies + " Pennies");

		}
	}
}