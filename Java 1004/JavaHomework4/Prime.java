public class Prime {

	public static void main(String[] agrs) {
		//Hardcoded numbers to test
		int test1 = 6;
		int test2 = 23;
		int test3 = 51647;

		//Check to see if it is prime and print the result
		if (isPrime(test1)) {

			System.out.println(test1 + " is prime");
		}

		else {

			System.out.println(test1 + " is not prime");
		}

		if (isPrime(test2)) {

			System.out.println(test2 + " is prime");
		}

		else {

			System.out.println(test2 + " is not prime");
		}

		if (isPrime(test3)) {

			System.out.println(test3 + " is prime");
		}

		else {

			System.out.println(test3 + " is not prime");
		}
	}

	public static boolean isPrime(int userInput ) {
		//Takes an int and returns a boolean depending on whether
		// or not the number is prime.

		//Implement the algorithm
		for(int i =2; i <= Math.sqrt(userInput); i++) {
			int answer = userInput % i;
			if(answer == 0) {
				return false;
			}
		}
		return true;
	}
	
}
