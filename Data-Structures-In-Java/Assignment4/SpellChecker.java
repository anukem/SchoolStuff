// John Anukem
// jea2161
// Due April 1st

import java.io.*;
import java.util.*;
import java.lang.*;

public class SpellChecker {

	public static void main(String[] args) throws FileNotFoundException {
		//Instantiate a file object and run the scanner over it	for input text
		File inputText = new File(args[1]);
		Scanner in = new Scanner(inputText);

		//Create HashMap and add all keys from words.txt
		HashMap<String,Integer> hashOfWords = new HashMap<String,Integer>();
		File wordText = new File(args[0]);
		Scanner dictionary = new Scanner(wordText);
		while(dictionary.hasNextLine()) {

			String currentWord = dictionary.nextLine();
			currentWord = currentWord.toLowerCase();
			hashOfWords.put(currentWord, new Integer(0));
		}

		Integer lineNumber = 0;
		//Go through looking at each line looking for misspelled words 
		while(in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			String[] listOfWords = line.split(" ");
			for (int i  = 0; i < listOfWords.length ; i++ ) {
				
				String cleanedUpWord = listOfWords[i].replaceAll("[\\p{P}&&[^\u0027]]", "").toLowerCase();

				if(hashOfWords.containsKey(cleanedUpWord)) {

					continue;
				}

				else {
					if(isNumeric(cleanedUpWord)) //The word is a number 
						continue;
					
					else { //All misspelled words will end up here
					
						//Check for the case where a letter added yields a word in the hashtable
						ArrayList<String> possibleWords = new ArrayList<String>();
						for(int j=65;j<=90;j++) {
						    String addedLetter = new String(Character.toString(((char)j)).toLowerCase());
						    for (int placeInWord = 0; placeInWord <= cleanedUpWord.length() ; placeInWord++ ) {
						    	
						    	String result = cleanedUpWord.substring(0, placeInWord) + addedLetter + cleanedUpWord.substring(placeInWord);	
							    if(hashOfWords.containsKey(result)) {
									if(possibleWords.contains(result)) {
										continue;	
									}
								else {
									possibleWords.add(result);
								}
														
								}
						    }
						} 
						//Check cases where deleted letters yield keys

						for (int k = 0; k < cleanedUpWord.length() ; k++ ) {
							String result = cleanedUpWord.substring(0, k) + cleanedUpWord.substring(k+1);
							
							if(hashOfWords.containsKey(result)) {
								if(possibleWords.contains(result)) {
									continue;	
								}
								else {
									possibleWords.add(result);
								}
														
							}
						}

						//Case where adjacent letters swapped yields a key
						for (int a = 0; a < cleanedUpWord.length() - 1 ; a++ ) {
							int b = a + 1;
							String result  = cleanedUpWord.substring(0, a) + new Character(cleanedUpWord.charAt(b)).toString() + new Character(cleanedUpWord.charAt(a)).toString() + cleanedUpWord.substring(b+1);

							if(hashOfWords.containsKey(result)) {
								if(possibleWords.contains(result)) {
									continue;	
								}
								else {
									possibleWords.add(result);
								}
														
							}
						}

						if (!possibleWords.isEmpty()) {

							if (possibleWords.size() == 1) {
							System.out.println("For " + cleanedUpWord + " on line " + lineNumber + ", did you mean " + possibleWords.get(0));
							}

							else {
								System.out.println("For " + cleanedUpWord + " on line " + lineNumber + ", did you mean one of these? " + possibleWords);
							}
						}

						else {
							System.out.println(cleanedUpWord + " on line " + lineNumber + " is spelled wrong" );
						}
						
						
					}
				}
			}
		}
	}

	public static boolean isNumeric(String s) {

		for (int i = 0; i < s.length() ; i++ ) {
			
			if (Character.isDigit(s.charAt(i))) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;

	}
}