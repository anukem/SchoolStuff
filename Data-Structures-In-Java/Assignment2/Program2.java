//A queue tester class used to see if 
//the dequeue and enqueue methods work properly

public class Program2 {

	public static void main(String[] args) {
		
		TwoStackQueue<Integer> queueOfInts = new TwoStackQueue<Integer>();
		
		//Add 20 items in sequential order
		for (int i = 0; i < 20 ;i ++ ) {
			
			queueOfInts.enqueue(new Integer(i));
		}
		System.out.println("The first 5 items are ");

		//Takes out 5 leaving 15
		for (int i = 0; i < 5 ; i++ ) {
			System.out.println(queueOfInts.dequeue());
		}
		//Add 4 more 0's
		for (int i = 0; i < 4 ;i++ ) {
			
			queueOfInts.enqueue(new Integer(0));
		}

		System.out.println("The rest of the items are as follows ");
		int size = queueOfInts.size();
		for (int i = 0; i < size; i++ ) {
			System.out.println(queueOfInts.dequeue());
		}
	}
}
