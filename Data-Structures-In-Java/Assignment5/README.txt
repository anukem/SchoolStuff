John Anukem
jea2161
Due April 21st, 2016


TopSort.java
	This program sorts a list of classes based on prerequisites and returns a list of topologically sorted items.
TopVert.java
	This class file is a blueprint for the Vertex object used in TopSort. It contains an id, inDegree, and adjacency list in order to reference the next verticies close by. 
Dijkstra.java, Display.java, Edge.java, Vertex.java
	This file contains a blueprint for the object Dijkstra which constructs a mapping of the shortest path from one vertex to every other one in the map. It makes use of Display.java in order to create a GUI for visualizing the path. The Edge and Vertex objects were created in a seperate file as a way to represent both the connection of cities as well as the cities themselves. In order to take in the data, it uses the cityxy.txt and citypairs.txt which has the x and y coordinates and pairs of cities with direct connections. 

To compile, make sure all the files are in the same folder, and run javac Display.java in the terminal, then run java Display.

Run javac Topsort.java
For the topological sort, run java Topsort [csmajor.txt]


