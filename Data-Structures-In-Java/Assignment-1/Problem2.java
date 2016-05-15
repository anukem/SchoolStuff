//John Anukem
//jea2161
//January 20th, 2015
import java.util.Arrays;
public class Problem2 {

	public static void main(String[] args) {
		//Create the list of rectangles
		Rectangle[] listOfRects = new Rectangle[5];
		listOfRects[0] = new Rectangle(1, 1);
		listOfRects[1] = new Rectangle(2, 2);
		Rectangle fettyWap = new Rectangle(3, 3);
		listOfRects[2] = fettyWap;
		listOfRects[4] = new Rectangle(4,4);
		listOfRects[3] = new Rectangle(5, 19);
		//listOfRects[2] = new Rectangle(65, 1);
		

		Arrays.sort(listOfRects);
		System.out.print("The index is ");
		System.out.println(binarySearch(listOfRects, fettyWap));
	}

	public static <AnyType extends Comparable<AnyType>>       
     int binarySearch(AnyType[] a, AnyType x) {
     	//Create the bounds for the search
     	int high;
     	int low;
     	int mid;

     	high = a.length;
     	low = 0;
     	mid = (high + low) / 2;

     	//Check the midpoint 
     	if(a[mid].equals(x)) {

     		return mid;
     	}

     	else {

     		return recursiveBinarySearch(a, x, low, high);
     	}
   	}
 	 

     public static <AnyType extends Comparable<AnyType>> int
     	recursiveBinarySearch(AnyType[] list, AnyType value, int low, int high) {
     	//Start by determining the midpoint
     	int mid = (low + high)/ 2;

     	//If these cross, the list has been iterated over entirely
     	if(high < low) {

     		return -1;	
     	}

     	//Check the mid point and see if the value
     	//were looking for is greater than or less than 
     	//the midpoint
     	else {

     		if(list[mid].equals(value)) {

     			return mid;
     		}

     		//Run it on the left side
     		else if(list[mid].compareTo(value) > 0){

     			return recursiveBinarySearch(list, value, low, mid - 1);

     		}

     		//Run the method on the right side. 
     		else {

     			return recursiveBinarySearch(list, value, mid + 1, high);
     		}

     	}


     }
}