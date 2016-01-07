import java.io.*;
import java.util.*;


public class Fail2Ban {

	public static void main(String[] args) throws FileNotFoundException {

		if(args.length != 1) {

			System.out.println("Please enter only one argument");
			return;
		}
		File inputFile = new File(args[0]);
		Scanner reader = new Scanner(inputFile);
		ArrayList<String> ipAddresses = new ArrayList<String>();	
		ArrayList<String> ipAnswers = new ArrayList<String>();	
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			Scanner lineWords = new Scanner(line);
			ArrayList<String> lineArray = new ArrayList<String>();		
			while(lineWords.hasNext()) {
				String word = lineWords.next();
				lineArray.add(word);
			}
			if(lineArray.get(5).equals("Invalid")) {

				ipAddresses.add(lineArray.get(9));
			}
		}
		for(int i = 0; i<ipAddresses.size(); i++) {
			int counter = 0;
			for(int j = 1; j<ipAddresses.size()-1;j++) {
				
				if(ipAddresses.get(j).equals(ipAddresses.get(i))) {

					counter = counter + 1;
				}
				if(counter == 3){

					ipAnswers.add(ipAddresses.get(i));
				}
			}
		}
		Set<String> ipOutput = new HashSet<String>(ipAnswers);
		PrintWriter out = new PrintWriter("ban.txt");
		for (int i = 0; i<ipOutput.size(); i++) {
			out.println(ipOutput.toArray()[i]);
		}
		reader.close();
		out.close();
	}
}