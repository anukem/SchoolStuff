import java.util.*;

public class TopVert {

	private String id;
	public int inDegree;
	public LinkedList<TopVert> adjacencyList = new LinkedList<TopVert>();

	public TopVert(int inDegree, String id ) {

		this.inDegree = inDegree;
		this.id = id;
	}

	public void addAdjacentVertex(TopVert x) {

		adjacencyList.add(x);
	}

	public void decreaseInDegree() {

		inDegree--;
	}

	public String toString() {

		return id;
	}
}