John Anukem  
jea2161  
October 11th, 2015  
Assignment 4
****************************************************************************
RockPaperScissors.java      
This program plays one game of Rock, Paper, Scissors with a user and a computer. The computer secretly chooses an option and depending on the user's choice there is either a tie or a determined winner of the round. The overall winner of the game wins after winning 10 rounds.
	computerChoice()     
		This method chooses a random number for the computer to use against the user.     
	userChoice()     
		This method allows the program to keep track of when the user makes a decision.
****************************************************************************
Prime.java 
This program takes in an int and returns true or false depending on whether or not the number is prime using a few test cases as examples.	
	isPrime()
		Takes an int and returns a boolean after checking the number to be prime or not. Returns false if it is not prime and true otherwise.
****************************************************************************
Statistics.java
This program consists of methods that are used in StatisticsTester.java and allows for all the calculations to take place.
	max()
		This calculates the largest number in a list of doubles.
	min()
		This calculates the smallest number in a list of doubles.
	mode()
		This calculates the number most frequently present in a list of doubles.
	median()
		This sorts a list of doubles and then calculates the number in the middle of the list of doubles.
	stdDev()
		This calculates the standard deviation in a list of doubles.
	mean()
		This calculates the average of a list of doubles.
****************************************************************************
StatisticsTester.java
This program is for specifically testing the methods created in Statistics.java. It allows the user to input the number of values to put in a list of doubles and then performs the calculations on the created list and prints the values.
****************************************************************************
							HOW TO COMPILE.
1. Make sure all the files are in the same directory.
2. From the terminal, cd into the directory containing all the files.
3. Run javac (filename).java to create the class file that the JVM can read.
4. Run java (filename) to execute the program.
