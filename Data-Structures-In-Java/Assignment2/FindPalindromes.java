import java.util.*;
import java.io.*;

//Looks through a text file and detects 
//the presence of a palindrome by the line.


public class FindPalindromes {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Create a file and scanner object to look through the line of items.		
		File inputFile = new File(args[0]);
		Scanner reader = new Scanner(inputFile);
		
		//Splits it into lines and pushes half the characters onto the stack and 
		//checks against the other half of the line to see if they're identical
		while(reader.hasNextLine()){
			String line = reader.nextLine();
			String revisedLine = line.replaceAll("[^a-zA-Z]","");
			revisedLine = revisedLine.toLowerCase();
			MyStack<String> newStack = new MyStack<String>();
			
			//odd number of characters
			if(revisedLine.length()%2 == 1) {
				for(int i = 0; i < revisedLine.length()/2 ;i++){
				
				newStack.push(new Character(revisedLine.charAt(i)).toString());
				
			}
				boolean isPalindrome = true;
				for(int j = (revisedLine.length()/2) + 1; j < revisedLine.length(); j++){
					
					if(newStack.pop().equals(new Character(revisedLine.charAt(j)).toString()) == false) {
						isPalindrome = false;
					}

				}
				System.out.println(line);
				System.out.println(isPalindrome);
			}

			//even number of characters
			else {
				for(int i = 0; i < revisedLine.length()/2 - 1 ;i++){
				
				newStack.push(new Character(revisedLine.charAt(i)).toString());
				
			}
				boolean isPalindrome = true;
				for(int j = (revisedLine.length()/2) + 1; j < revisedLine.length(); j++){
					
					if(newStack.pop().equals(new Character(revisedLine.charAt(j)).toString()) == false) {
						isPalindrome = false;
					}

				}
				System.out.println(line);
				System.out.println(isPalindrome);

			}
		}
	}
}