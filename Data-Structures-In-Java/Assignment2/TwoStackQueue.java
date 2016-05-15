import java.util.*;
//Implements the queue ADT using two Stacks. 

public class TwoStackQueue<Anytype> {

	private MyStack<Anytype> stack1;
	private MyStack<Anytype> stack2;

	//Constructor
	public TwoStackQueue() {

		stack1 = new MyStack<Anytype>();
		stack2 = new MyStack<Anytype>();
	}
	
	//Add an item to the queue
	public void enqueue(Anytype data) {

		stack1.push(data);
	}

	//Remove the first data point in line and returns the value
	public Anytype dequeue() {

		//If the queue is empty
		if(stack1.isEmpty() && stack2.isEmpty()){

			throw new NoSuchElementException();
		}

		//The queue has information in the first stack that needs to be pushed
		else if(stack2.isEmpty()){
			int size = stack1.size();
			for(int i = 0; i < size; i++) {
				
				stack2.push(stack1.pop());
				
				
			}

			return stack2.pop();
		}

		//The front of the line is already on stack 2
		else {

			return stack2.pop();
		}
	}

	//Allows the user to view without removing the value
	public Anytype peek() {

		//Nothing to see
		if(stack2.isEmpty() && stack1.isEmpty()) {

			return null;
		}

		//Data needs to be moved
		else if(stack2.isEmpty()) {

			for(int i = 0; i < stack1.size(); i++) {

				stack2.push(stack1.pop());
			}
			return stack2.peek();
		}

		//Already on Stack2
		else {

			return stack2.peek();
		}
	}

	//Returns the size
	public int size() {

		return(stack1.size() + stack2.size());
	}
}