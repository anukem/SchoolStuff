public class Rectangle implements Comparable<Rectangle>{
	//Instance variables
	private int length;
	private int width;

	//Constructor
	public Rectangle(int l, int w) {
		
		length = l;
		width = w;
	}

	//Accessor methods
	public int getWidth() {

		return width;
	}

	public int getLength() {

		return length;
	}

	public int perimeter() {

		return 2*length + 2*width;
	}

	//Required by comparable
	public int compareTo(Rectangle c) {

		if(c.perimeter() > this.perimeter()) {

			return -1;
		}

		else if(this.perimeter() > c.perimeter()) {

			return 1;
		}

		else {

			return 0;
		}
	}

	//String representation of the rectangle
	public String toString() {

		return "Rectangle with perimeter " + new Integer(this.perimeter()).toString();
	}
}