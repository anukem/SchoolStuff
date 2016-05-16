import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.*;

public class Graph {

  // Keep a fast index to nodes in the map
  private Map<Integer, Vertex> vertexNames;

  /**
   * Construct an empty Graph with a map. The map's key is the name of a vertex
   * and the map's value is the vertex object.
   */
  public Graph() {
    vertexNames = new HashMap<>();
  }

  /**
   * Adds a vertex to the graph. Throws IllegalArgumentException if two vertices
   * with the same name are added.
   * 
   * @param v
   *          (Vertex) vertex to be added to the graph
   */
  public void addVertex(Vertex v) {
    if (vertexNames.containsKey(v.name))
      throw new IllegalArgumentException("Cannot create new vertex with existing name.");
    vertexNames.put(v.name, v);
  }

  /**
   * Gets a collection of all the vertices in the graph
   * 
   * @return (Collection<Vertex>) collection of all the vertices in the graph
   */
  public Collection<Vertex> getVertices() {
    return vertexNames.values();
  }

  /**
   * Gets the vertex object with the given name
   * 
   * @param name
   *          (String) name of the vertex object requested
   * @return (Vertex) vertex object associated with the name
   */
  public Vertex getVertex(String name) {
    return vertexNames.get(name);
  }

  /**
   * Adds a directed edge from vertex u to vertex v
   * 
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addEdge(int nameU, int nameV, Double cost) {
    if (!vertexNames.containsKey(nameU))
      throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
    if (!vertexNames.containsKey(nameV))
      throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
    Vertex sourceVertex = vertexNames.get(nameU);
    Vertex targetVertex = vertexNames.get(nameV);
    Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
    sourceVertex.addEdge(newEdge);
  }

  /**
   * Adds an undirected edge between vertex u and vertex v by adding a directed
   * edge from u to v, then a directed edge from v to u
   * 
   * @param name
   *          (String) name of vertex u
   * @param name2
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addUndirectedEdge(int name, int name2, double cost) {
    addEdge(name, name2, cost);
    addEdge(name2, name, cost);
  }


  /**
   * Computes the euclidean distance between two points as described by their
   * coordinates
   * 
   * @param ux
   *          (double) x coordinate of point u
   * @param uy
   *          (double) y coordinate of point u
   * @param vx
   *          (double) x coordinate of point v
   * @param vy
   *          (double) y coordinate of point v
   * @return (double) distance between the two points
   */
  public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
    return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
  }

  /**
   * Computes euclidean distance between two vertices as described by their
   * coordinates
   * 
   * @param u
   *          (Vertex) vertex u
   * @param v
   *          (Vertex) vertex v
   * @return (double) distance between two vertices
   */
  public double computeEuclideanDistance(Vertex u, Vertex v) {
    return computeEuclideanDistance(u.x, u.y, v.x, v.y);
  }

  /**
   * Calculates the euclidean distance for all edges in the map using the
   * computeEuclideanCost method.
   */
  public void computeAllEuclideanDistances() {
    for (Vertex u : getVertices())
      for (Edge uv : u.adjacentEdges) {
        Vertex v = uv.target;
        uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
      }
  }



  // STUDENT CODE STARTS HERE


  public boolean stillVerticiesLeft() {
    //This method checks the list to see if any verticies are still marked known
    //Used in the findNewPossibleEdge() method and computeNearestNeighbor()

    for (Vertex v: getVertices()) {
        if(!v.known) {
          return true;
        }
    }
    return false;
}


  public void generateRandomVertices(int n) {
    //This method creates a random connected graph in the GUI.


    vertexNames = new HashMap<>(); // reset the vertex hashmap
    for (int i = 0; i < n ;i++ ) {
      int name = new Random().nextInt(101);
      Vertex nVert = new Vertex(name, new Random().nextInt(101), new Random().nextInt(101));
      vertexNames.put(name, nVert);
    }

    for (Vertex v:getVertices() ) {
        
        for(Vertex x: getVertices()){

            if(!x.equals(v)){
              addUndirectedEdge(x.name, v.name, 100);
          }
        }
    }
    
    
    computeAllEuclideanDistances(); // compute distances
  }

  public Edge findNewPossibleEdge(Vertex v, Vertex w) {
    //Helper method for computeNearestNeighbor() that finds an edge that connects an unknown vertex.

      Edge possibleEdge;
      if (stillVerticiesLeft()) {
          possibleEdge = new Edge(v,v,0);
          for (Edge e: v.adjacentEdges ) {
             if(!e.target.known) 
                possibleEdge = e;
          }
      }
      else {
          //Last vertex gets connected to the first

          possibleEdge = new Edge(v, w, computeEuclideanDistance(v, w));
      }
      return possibleEdge;
  }

  public List<Edge> computeNearestNeighbor(Vertex startingPoint) {
    //This method computes the nearest neighbor with each vertex as a starting point
    //and selects the shortest cycle as an approximation. 

    //return list
    LinkedList<Edge> neighbors = new LinkedList<Edge>();

    //Starting Vertex
    Vertex currentVertex;
    currentVertex = startingPoint;
    
    // Loop that finds the vertex closest to the current and adds the edge to return list
    while(stillVerticiesLeft()) {

      currentVertex.known = true;
      
      Edge minimiumEdge = findNewPossibleEdge(currentVertex, startingPoint);
      for (Edge e: currentVertex.adjacentEdges) {
          if(e.distance < minimiumEdge.distance && !e.target.known) {

              minimiumEdge = e;
          }
      }

      neighbors.add(minimiumEdge);
      currentVertex = minimiumEdge.target;
    }
    
    for(Vertex v: getVertices())
        v.known = false;

   

    return neighbors;
  }

  public List<Edge> nearestNeighborTsp() {
    //Finds the smallest nearestNeighor path by checking all verticies as the start
    
    
    double distance = Double.POSITIVE_INFINITY;
    Vertex smallestStartingVertex = null;
    for (Vertex v: getVertices() ) {



        if(findDistanceOfEdges(computeNearestNeighbor(v)) < distance) {
            distance = findDistanceOfEdges(computeNearestNeighbor(v));
            smallestStartingVertex = v;
        }
    }


    return computeNearestNeighbor(smallestStartingVertex);
  }

  public double findDistanceOfEdges(List<Edge> listOfEdges) {
    //Finds distance from start to finish of all the edges in a list.

      double distance = 0;

      for (Edge e: listOfEdges ) {
          distance += e.distance;
      }

      return distance;
  }

  public double findDistanceOfVerticies(List<Vertex> listOfVerticies) {
    //Converts a list of verticies into a list of edges.
    //Then finds the distance from all of them.

    List<Edge> listOfEdges = convertFromVertexToEdgeList(listOfVerticies);
    return findDistanceOfEdges(listOfEdges);
  }


    public LinkedList<Edge> convertFromVertexToEdgeList(List<Vertex> vertexList) {
        //Converts a Vertex list to an Edge List

      LinkedList<Edge> neighbors = new LinkedList<Edge>();

      Vertex currentVertex;
      currentVertex = vertexList.get(0);
      //Keeps track of where we are in the list
      int index = 1;

      while(stillVerticiesLeft()) {

          currentVertex.known = true;
          if(index == vertexList.size()) {


              for(Edge e : currentVertex.adjacentEdges) {

                  if(e.target.equals(vertexList.get(0))) {
                      
                      neighbors.add(e);
                      for(Vertex v: getVertices())
                          v.known = false;  
                      System.out.println(neighbors);
                      return neighbors;
                  }
                  
              }
          }

          Vertex nextVertex = vertexList.get(index);
          for (Edge e : currentVertex.adjacentEdges ) {
              if(e.target.equals(nextVertex)) {
                  neighbors.add(e);
                  break;
              }
          }
          index++;
          currentVertex = nextVertex;

      }

        return null;
        
    }
      
    public static LinkedList<List<Vertex>> getPermutations(List<Vertex> list) {
        //Finds all permutations of a list of verticies.

    if (list.size() == 0) {
        //Base Case
        LinkedList<List<Vertex>> result = new LinkedList<List<Vertex>>();
        result.add(new ArrayList<Vertex>());
        return result;
    }

    LinkedList<List<Vertex>> returnList = new LinkedList<List<Vertex>>();

    //Fix the element
    Vertex firstElement = list.remove(0);

    LinkedList<List<Vertex>> recursiveReturn = getPermutations(list);

    //Go through and permute the n - 1 elements. 
    for (List<Vertex> li : recursiveReturn) {

        for (int index = 0; index <= li.size(); index++) {
            List<Vertex> temp = new ArrayList<Vertex>(li);
            temp.add(index, firstElement);
            returnList.add(temp);
        }

    }
    return returnList;
    }






  public List<Edge> bruteForceTsp() {
      //Iterates through all permutations and finds the shortest path. 
    
    List<Vertex> listOfVerticies = new LinkedList<Vertex>();

    for(Vertex v: getVertices())
        listOfVerticies.add(v);

    LinkedList<List<Vertex>> permutations = getPermutations(listOfVerticies);

    double distance = Double.POSITIVE_INFINITY;

    List<Vertex> answer = new LinkedList<Vertex>();

    //Loop to find the shortest distance
    for(List<Vertex> permutation : permutations) {

      double currentDistance = findDistanceOfVerticies(permutation);
        if(currentDistance < distance) {
            distance = currentDistance;
            answer = permutation;
        } 
    }



    return convertFromVertexToEdgeList(answer); 
  }

  // STUDENT CODE ENDS HERE



  /**
   * Prints out the adjacency list of the graph for debugging
   */
  public void printAdjacencyList() {
    for (int u : vertexNames.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(u);
      sb.append(" -> [ ");
      for (Edge e : vertexNames.get(u).adjacentEdges) {
        sb.append(e.target.name);
        sb.append("(");
        sb.append(e.distance);
        sb.append(") ");
      }
      sb.append("]");
      System.out.println(sb.toString());
    }
  }
}
