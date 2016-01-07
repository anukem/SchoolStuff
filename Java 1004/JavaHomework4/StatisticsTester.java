import java.util.Scanner;

public class StatisticsTester {

	public static void main(String[] agrs) {
		//Store the answer as an int
		Scanner input = new Scanner(System.in);
		System.out.print("How many numbers would you like to enter? ");
		int answer = input.nextInt();
		
		//Use the answer to derive the length and then 
		//for every place in the list, allow the user to input a value
		double[] userList = new double[answer];
		for(int i = 0; i < answer; i++) {
			System.out.println("Please enter a number: ");
			userList[i] = input.nextDouble();
		}

		//Print the results
		System.out.println("The max is: " + Statistics.max(userList));
		System.out.println("The min is: " + Statistics.min(userList));
		System.out.println("The median is " + Statistics.median(userList));
		System.out.println("The mode is " + Statistics.mode(userList));
		System.out.println("The mean is " + Statistics.mean(userList));
		System.out.println("The standard deviation is " + Statistics.stdDev(userList));



	}
}