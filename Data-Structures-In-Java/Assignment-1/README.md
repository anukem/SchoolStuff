Assignment 1

1) (18 pts) Define a rectangle class that provides a getLength method and and a getWidth method.  
Rectangle should also implement the Comparable class; it should compare by perimeter. 
Create another class called Problem1 that has the findMax routine (included below) and add a main 
method that creates an array of Rectangle objects and finds the largest Rectangle on the bases of its perimeter.
(18 pts) In Problem2.java Implement a static method with the signature:
public static <AnyType extends Comparable<AnyType>>       
     int binarySearch(AnyType[] a, AnyType x);
This method should then search the array recursively for the value x.  
Create a main method that builds an array of rectangles (use your class from problem 1) and then sort that array with Arrays.sort. 
Demonstrate your recursive binarySearch method on this array.
(14 pts ) In Problem3.java, implement the three code fragments from written problem 3. 
Have your code repeatedly run each fragment on various values of n. 
Time each run and see if the progression of timings as n increases matches the predicted run times from your written assignment.  
Place the results of your timing and your explanation in a file called Problem3.txt.  
For the third fragment, set k equal to 2 for all of your testing. 
The easiest way to time your run is to execute the following code before each fragment:
 int starTime = System.currentTimeMillis();
then after each fragment place:
endTime = System.currentTimeMillis();
The elapsed time is the difference between these two variables.
