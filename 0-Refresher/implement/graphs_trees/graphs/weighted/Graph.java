import java.util.*;

class Graph {
  Vertex vertextList[]; 
  int adjMatrix[][];
  int numbVertices;//keep track of what we are adding to!
  int MAX_VERTICES;
  int INFINITY = Integer.MAX_VALUE;

  public Graph(int MAX_VERTICES) {
    this.MAX_VERTICES = MAX_VERTICES;
    vertextList = new Vertex[MAX_VERTICES];
    numbVertices = 0;
    adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    for(int row = 0; row < MAX_VERTICES; row++){
      for(int col = 0; col < MAX_VERTICES; col++){
          //init all as disconnected 
          adjMatrix[row][col] = INFINITY;
      }
    }
  }
  //just adding that it's here (not linked to anything yet)
  public void addVertex(String label) {
    vertextList[numbVertices++] = new Vertex(label);
  }
  public void addEdge(int src, int dest, int weight, boolean undirected) {
    adjMatrix[src][dest] = weight;
    if(undirected) adjMatrix[dest][src] = weight;
  }

  //Print the MST of a Weight Undirected Graph!
  public void MSTWeighted() {
    int currentVertex = 0; //we'll start on the first inserted vertex!
    //keep shortest distance on top!
    PriorityQueue<Edge> pq = new PriorityQueue<>(10, new Comparator<Edge>(){
      public int compare(Edge a, Edge b) {
        return Integer.compare(a.distance, b.distance);
      }
    });
    List<Integer> visted = new ArrayList<>();
    Deque<Edge> mst = new ArrayDeque<>();
    visted.add(currentVertex);
    //until we visit all vertices
    while(visted.size()!= numbVertices) {
      //now search what vertices our current vertex links to 
      //push all those edges to our pq (pop the smallest edge and repeat)
      //make sure new Vertices = aren't you, aren't visted, path to them exists
      for(int linkToVertex = 0; linkToVertex < numbVertices; linkToVertex++) {
        //is it you?
        if(currentVertex == linkToVertex) continue;
        if(visted.contains(linkToVertex)) continue;
        //check if we can even link to it
        if(adjMatrix[currentVertex][linkToVertex] == INFINITY) continue;
        //we just proved we can link to it 
        //add it to your pq (we don't know if it's the best path to take) pq is 
        //in charge of that!
        addToPQ(currentVertex, linkToVertex, adjMatrix[currentVertex][linkToVertex], pq);
      }
      //we've added all neighbors
      //add the next path and update our currentVertex
      //check queue is still active (else something went wrong!!!)
      if(pq.isEmpty()){
        System.out.println("MORE THAN ONE GRAPH EXISTS HERE!");
        return; //kill it!
      }
      Edge goingTo = pq.poll(); 
      mst.add(goingTo);
      visted.add(goingTo.destinationVertex);
      currentVertex = goingTo.destinationVertex; //this is the index we are looking into next
    }

    //we should have the entire path in our mst deque 
    while(!mst.isEmpty()) {
      Edge visting = mst.poll();
      System.out.println(vertextList[visting.sourceVertex].label + "  =>  " + vertextList[visting.destinationVertex].label);
    }
  }

  //O(N) WC (no clone or clone is last found)
  public void addToPQ(int src, int dest, int distance, PriorityQueue<Edge> pq) {
    PriorityQueue<Edge> clonePQ = new PriorityQueue<>(pq); //make NEW pq not REF
    //make edge
    Edge candidate = new Edge(src, dest, distance);
    while(!clonePQ.isEmpty()) {
      Edge currEdge = clonePQ.poll();
      if(candidate.destinationVertex == currEdge.destinationVertex) {
        //same destination is ours smaller dist?
        if(candidate.distance < currEdge.distance) {
          pq.remove(currEdge);
          pq.add(candidate);
          return; //done
        } else {
          //we found our match, we conserve them 
          return;
        }
      }
    }
    //no clone so just add it
    pq.add(candidate);
  }

  /*Dijkstra's Algorithm: 
  Visit starting point: Log all neighbors (#) and non-neighbors (INFINITY==-1) 
  1. Get the vertex that has the lowest summed up path
  2. Add it to our visted and now get it's neighbors (edges) 
  3. Adjust our stored path with the new neighbors (edges)
  4. Repeat from 1
  */
  public DistancePairs[] dijkstra(int startingVertex, int endingVertex) {
    List<Integer> visted = new ArrayList<>();
    visted.add(startingVertex);
    DistancePairs[] shortestPath = new DistancePairs[numbVertices];
    initPaths(startingVertex, shortestPath);
    for(DistancePairs pair : shortestPath) {
      System.out.println(" " + pair.parentVertex + "    " + pair.distance);
    }
    while(visted.size() < numbVertices) {
      int currVertex = getMin(shortestPath, visted);//get the vertex with the min(sumPath) not visted
      int startToCurr = shortestPath[currVertex].distance;
      if(startToCurr == INFINITY) {
        System.out.println("UNCONNECTED GRAPH!!!");
        return null;
      } else {
        visted.add(currVertex);
        adjustPath(currVertex, startToCurr, visted, shortestPath);
      }
    }
    return shortestPath;
  }

  public void initPaths(int startingVertex, DistancePairs[] shortestPath) {
    for(int vertexTo = 0; vertexTo < numbVertices; vertexTo++) {
      int distance = adjMatrix[startingVertex][vertexTo];
      shortestPath[vertexTo] = new DistancePairs(startingVertex, distance);
    }
  }

  public int getMin(DistancePairs[] shortestPath, List<Integer> visted) {
    int minDistance = Integer.MAX_VALUE;
    int minVertexIndex = 0;
    //go through entire SP and get the vertex with min(summedPath) & not visted
    for(int vertexTo = 0; vertexTo < numbVertices; vertexTo++) {
      int distance = shortestPath[vertexTo].distance;
      if(!visted.contains(vertexTo) && distance < minDistance) {
        minDistance = distance;
        minVertexIndex = vertexTo;
      }
    }
    return minVertexIndex;
  }

  public void adjustPath(int currVertex, int startToCurr, List<Integer> visted, DistancePairs[] shortestPath){
    //visit all neighbors and update if we have a shorter distance to its
    for(int vertexTo = 0; vertexTo < numbVertices; vertexTo++) {
      int currToNextVertex = adjMatrix[currVertex][vertexTo];
      if(visted.contains(vertexTo) || currToNextVertex == INFINITY) {
        continue; //don't bother checking
      }
      else{
        int startToNextVertex = startToCurr + currToNextVertex; //candiate
        int holdingToNextVertex = shortestPath[vertexTo].distance; //what we've stored for that point
        if(startToNextVertex < holdingToNextVertex) {
          //overwrite old path 
          shortestPath[vertexTo] = new DistancePairs(currVertex, startToNextVertex);
        }
      }
    }
  }

}

class DistancePairs {
  int parentVertex; 
  int distance; 
  public DistancePairs(int parentVertex, int distance) {
    this.parentVertex = parentVertex;
    this.distance = distance;
  }
}

class Edge {
  int sourceVertex;
  int destinationVertex;
  int distance;
  public Edge(int sourceVertex, int destinationVertex, int distance) {
    this.sourceVertex = sourceVertex;
    this.destinationVertex = destinationVertex;
    this.distance = distance;
  }
}


class Vertex {
  String label;
  public Vertex(String label) {
    this.label = label;
  }
}