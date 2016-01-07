/* 	John Anukem
	jea2161
	Assignment 6
	November 6th, 2015
*/

public class CreditCard {

	//Instance Variables 
	public String cardNumber;
	public boolean validity;
	public int errorCode = 0;

	//Constructor
	public CreditCard(String number) {

		cardNumber = number;
		

	}
	public boolean check() {
		//Checks to see if the card is valid and returns a boolean value

		validity = true;
		
		//This loop adds all the digits together and stores it in sum
		Integer sum = 0;
		for(int i = 0; i < cardNumber.length(); i++) {
			Integer adder = Integer.valueOf(String.valueOf(cardNumber.charAt(i)));
			sum = sum + adder;	
		}

		//This loop stores the sum of the first 4 digits in firstFourSum
		Integer firstFourSum = 0;
		for(int j = 0; j < 4; j++) {
			Integer adder = Integer.valueOf(String.valueOf(cardNumber.charAt(j)));			
			firstFourSum = firstFourSum + adder;
		}

		//This loop does the same as above but for the last 4 digits. 
		Integer lastFourSum = 0;		
		for(int k = 8; k < cardNumber.length(); k++) {
			Integer adder = Integer.valueOf(String.valueOf(cardNumber.charAt(k)));
			lastFourSum = lastFourSum + adder;
		}

		//Create the variables that will be referenced in the checks
		Integer firstDigit = Integer.valueOf(String.valueOf(cardNumber.charAt(0)));
		Integer fourthDigit = Integer.valueOf(String.valueOf(cardNumber.charAt(3)));
		Integer fifthDigit = Integer.valueOf(String.valueOf(cardNumber.charAt(4)));
		Integer ninthDigit = Integer.valueOf(String.valueOf(cardNumber.charAt(8)));
		Integer firstTwoDigitNum = Integer.parseInt(String.valueOf(cardNumber.charAt(0) + String.valueOf(cardNumber.charAt(1))));
		Integer lastTwoDigitNum = Integer.parseInt(String.valueOf(cardNumber.charAt(6) + String.valueOf(cardNumber.charAt(7))));	
		
		//First error
		//Checks to see if the first digit is a 4
		if(cardNumber.charAt(0) != '4') {

			errorCode = 1;
			validity = false;
			return validity;

		}
		//Second Error
		//Chechs to see if the fourth digit is one larger than the fifth
		else if (fifthDigit + 1 != fourthDigit) {

			errorCode = 2;
			validity = false;
		 	return validity;
		 } 
		 //Third Error
		 //Checks to see if the product of the first, fifth, and ninth digits is 24
		 else if (firstDigit*fifthDigit*ninthDigit != 24) {
		 	errorCode = 3;
		 	validity = false;
		 	return validity;
		 }
		 //Fourth Error
		 //Checks to see if the sum of all digits is divisible by 4
		 else if (sum%4 != 0 ) {
		 	errorCode = 4;
		 	validity = false;
		 	return validity;
		 }
		 //Fifth Error
		 //Checks to see if the first four digits sum is one less than the last four digits
		 else if(firstFourSum + 1 != lastFourSum) {
		 	errorCode = 5;
		 	validity = false;
		 	return validity;
		 }
		 //Sixth Error
		 //Checks to see if the first two digits as a number + the last two digits as a number = 100
		 else if(firstTwoDigitNum + lastTwoDigitNum != 100) {
		 	errorCode = 6;
		 	validity = false;
		 	return validity;
		 }
		return validity; 
	}
	public boolean isValid() {
		//Returns the validity of the card number after being checked
		check();
		return validity;

	}
	public int getErrorCode() {
		//Returns the error code after checking to see if it's valid
		check();
		return errorCode;
	}
}