John Anukem	
jea2161
Due May 3rd, 2016

Display.java
	This class creates a GUI to display the graph instance created in Graph.java. It includes buttons that calculate the brute force and nearestNeighbor shortest paths. 

Graph.java
	This class creates an instance of a graph with random vertices dispersed throughout the GUI created in Display.java. It makes use of methods that create the verticies using the Vertex class and makes undirected edges to each of the vertices from each vertex. After that, this class allows you to compute the shortest nearest neighbor path starting from each vertex. In addition, it also allows for a brute force calculation of every cycle and returns the shortest with a red overlay. 

Vertex.java
	This class is a blueprint for the vertices used in Graph.java. It contains instance variables of the coordinates, as well as an adjacency list representation of all the edges that connect to neighboring vertices. I also changed the toString() method to make the adjacency list a little less cluttered and easier to comprehend when debugging. 


Edge.java
	This class is a blueprint for the Edge class used in the Graph.java. It contains instance variables for the vertices that it connects as well as a weight instance variable used in the nearestNeighbor() and bruteForce() methods. 

In order to compile, download the source folder and run javac [filename] for source code files, and then run java Display. 
