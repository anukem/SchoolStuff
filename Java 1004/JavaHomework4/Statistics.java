import java.util.Arrays;
public class Statistics {

	public static double max(double [] dubList) {

		//Set the first element to the max
		double max = dubList[0];

		//If a larger number is encountered, set that to the max
		for(int i = 0; i < dubList.length; i++) {

			if(max < dubList[i]) {
				max = dubList[i];
			}
		}
		return max;
	}

	public static double min(double [] dubList) {

		//Set the first number to the min
		double min = dubList[0];

		//If a smaller number is enountered,
		//Set that to the new min
		for(int i = 0; i < dubList.length; i++) {

			if(min > dubList[i]) {
				min = dubList[i];
			}
		}
		return min;
	}
	public static double mean(double[] dubList) {
		//Keep track of the total and divide it by the number
		//of things in the list to get the mean
		double total = 0;
		double mean = 0;
		for(int i = 0; i < dubList.length; i++) {

			total = total + dubList[i];
			mean = total / dubList.length;

		}
		return mean;
	}
	public static double stdDev(double[] dubList) {

		//Set the mean equal to the mean method
		double mean = mean(dubList);

		//Implement the equation
		for(int i = 0; i < dubList.length; i++) {
			dubList[i] = Math.pow((dubList[i] - mean), 2);
		}
		double newMean = mean(dubList);
		double stdDev = Math.sqrt(newMean);
		return stdDev;
	}
	public static double mode(double[] dubList) {

		//Counter will keep track of how many times
		//A number is repeated
		int counter = 0;
		//cuurentMode will keep track of the highest frequency
		int currentMode = 0;
		//placeHolder will keep track of the actual value
		double placeHolder = 0.0;
		for(int i = 0; i < dubList.length; i++) {

			for(int j = i + 1; j < dubList.length; j++) {

				if(dubList[i] == dubList[j]) {
					counter++;
				}
				if(counter > currentMode) {
					currentMode = counter;
					placeHolder = dubList[i];
				}
			}
		}
		return placeHolder;
	}
	public static double median(double[] dubList) {
		double median = 0.0;
		Arrays.sort(dubList);
		//In the case the the list is not even
		if(dubList.length % 2 != 0) {
			median = dubList[(int)((dubList.length/2) + 0.5)];
		}
		//In the case it is even
		else {

			median = (dubList[dubList.length/2] + dubList[(dubList.length/2)-1])/2;
		}
		return median;
	}
}