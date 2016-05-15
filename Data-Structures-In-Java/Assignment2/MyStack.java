import java.util.*;
public class MyStack<Anytype>{

	//Implement a stack using a Linkedlist as the underlying structure.

	private LinkedList<Anytype> underlyingList;
	private int size;

	//Constructor
	public MyStack(){
		underlyingList = new LinkedList<Anytype>();
		size = 0;
	}

	//Push method that adds the data of the object to the stack
	public void push(Anytype obj) {
		underlyingList.addFirst(obj);
		size++;
	}

	//Returns the object and removes it from the list.
	public Anytype pop(){
		if(size == 0){
			throw new IndexOutOfBoundsException();
		}
		size--;
		return underlyingList.removeFirst();
	}

	//Lets the user know if the data structure is empty. 
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public int size() {
		return size;
	}

	//Allows the user to see the front item without removing it.
	public Anytype peek() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return underlyingList.get(0);
	}
}