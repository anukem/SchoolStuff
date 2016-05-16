// John Anukem
// jea2161
// March 4, 2016

import java.util.*;
import java.io.*;

public class Problem2 {

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File(args[0]);
		Scanner in = new Scanner(inputFile);
		AvlTree<String> treeOfWords = new AvlTree<String>();
		//Create a variable for the location and counter
		int location = 0;
		int counter = 0;
		while(in.hasNextLine()) {
			location++;
			String line = in.nextLine();
			String[] listOfWords = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");//clean up words
			for(int i = 0; i < listOfWords.length; i++) {
				if(treeOfWords.contains(listOfWords[i])){//if its already in the tree
					if(treeOfWords.getNode(listOfWords[i]).numOfOccurences.contains(new Integer(location))) {// if the list already has the number
						continue;
					}
					else{

						treeOfWords.getNode(listOfWords[i]).numOfOccurences.addFirst(new Integer(location));
					}
				}
				else {
					treeOfWords.insert(listOfWords[i]);
					treeOfWords.getNode(listOfWords[i]).numOfOccurences.addFirst(new Integer(location));
				}
			}

		}
		treeOfWords.printTree();

	}
}