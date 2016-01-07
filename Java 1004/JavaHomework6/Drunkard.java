/* 	John Anukem
	jea2161
	Assignment 6
	November 6th, 2015
*/
public class Drunkard {

	//Instance Variables 
	public int currentStreet;
	public int currentAvenue;
	public int distanceInX = 0;
	public int distanceInY = 0;

	//Constructor
	public Drunkard(int avenue, int street) {

		currentAvenue = avenue;
		currentStreet = street;

	}
	public void step() {
		//Represents each direction as a number between 1 and 4
		//Then randomly chooses one to go in. 
		int direction = (int)(Math.random() * 4 + 1);

		if(direction == 1) {

			currentStreet++;
			distanceInY++;
		}
		if(direction == 2) {

			currentStreet--;
			distanceInY--;
		}
		if(direction == 3) {

			currentAvenue++;
			distanceInX++;
		}
		if(direction == 4) {

			currentAvenue--;
			distanceInX--;
		}
	}
	public void fastForward(int steps) {
		//Determines and takes the number of steps to take using the step method and input.
		for(int i = 0; i < steps; i++) {

			step();
		}
	}
	public String getLocation() {
		//Returns the location of the Drunkard at the time it's called.
		String location = "(" + String.valueOf(currentAvenue) + "," + String.valueOf(currentStreet) + ")";
		return location;
	}
	public int howFar() {
		//Returns the distance travelled by Manhattan distance.
		return Math.abs(distanceInX) + Math.abs(distanceInY);
	}
}