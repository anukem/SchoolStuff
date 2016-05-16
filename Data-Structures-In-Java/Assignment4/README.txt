John Anukem
jea2161
Due April 1st, 2015


SpellChecker.java
	This program takes a text file as input and returns a list of mispelled words as well as their line number and possible suggestions for other words. It utilizes a dictionary with words.txt and compares values in the input text file against the dictionary. 

	main()
		This method takes the input file and runs a Scanner object over it. It then creates a HashMap to get all values in the dictionary. After that it goes over the entire dictionary and compares words in the text file to see if they belong in the dictionary. Lastly, it outputs the misspelled words as well as a list of suggestions.

	isNumeric()
		Function made to check if an input word is a number. 

KBestCounter.java
	This class file keeps track of the k largest values in a set of data. 

	count()
		This processes the next item in the set of data.

	kbest()
		This returns a list with the k highest numbers in the set. 

To compile, open the file in terminal and run javac [filename].java and then run java [filename]