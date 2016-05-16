import java.util.*;
import java.io.*;

public class TopSort {

	public static void main(String[] args) throws FileNotFoundException {
		
		String file = args[0];

		File inputFile = new File(file);
		Scanner in = new Scanner(inputFile);
		HashMap<String,TopVert> courses = new HashMap<String,TopVert>();

		while(in.hasNextLine()) {

			String[] line = in.nextLine().split(" ");

			courses.put(line[0], new TopVert(line.length - 1, line[0]));
			
			for (int i = 1; i < line.length ; i++ ) {
				
				if(courses.containsKey(line[i])) {

					courses.get(line[i]).addAdjacentVertex(courses.get(line[0]));
					
				}
			}
		}
		Queue<TopVert> courseQueue = new LinkedList<TopVert>();
		int counter = 0;

		for(TopVert element:courses.values()) {

			if (element.inDegree == 0) {
				
				courseQueue.add(element);
			}
		}

		while(!courseQueue.isEmpty()) {

			TopVert currentVertex = courseQueue.remove();
			System.out.println(currentVertex);
			counter++;
			for (int i = 0; i < currentVertex.adjacencyList.size() ;i++ ) {
				
				if (--currentVertex.adjacencyList.get(i).inDegree == 0) {
					
					courseQueue.add(currentVertex.adjacencyList.get(i));
				}
			}
		}
		if(counter != courses.size()) {

				System.out.println("Whoops, you've got a cycle.");
			}
	}
}