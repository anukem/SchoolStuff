//John Anukem
//jea2161
//January 20th, 2015
import java.util.Arrays;
public class Problem1 {

	public static void main(String[] args) {
		//Create the list of rectangles
		Rectangle[] listOfRects = new Rectangle[5];
		listOfRects[0] = new Rectangle(20, 20);
		listOfRects[1] = new Rectangle(10, 21);
		listOfRects[2] = new Rectangle(3, 61);
		listOfRects[3] = new Rectangle(5, 19);
		listOfRects[4] = new Rectangle(65, 1);

		Arrays.sort(listOfRects);

		System.out.println(findMax(listOfRects));
	}

	public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
  		int maxIndex = 0;
  		//Loop through comparing the current max with the new index
  		for (int i = 1; i < arr.length; i++)
   			 if ( arr[i].compareTo(arr[maxIndex]) > 0 )
      		 maxIndex = i;
    	return arr[maxIndex];
	}
}