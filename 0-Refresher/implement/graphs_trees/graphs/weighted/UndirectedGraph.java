import java.util.*;

class UndirectedGraph {
  Vertex vertextList[]; 
  int adjMatrix[][];
  int numbVertices;//keep track of what we are adding to!
  int MAX_VERTICES;
  public UndirectedGraph(int MAX_VERTICES) {
    this.MAX_VERTICES = MAX_VERTICES;
    vertextList = new Vertex[MAX_VERTICES];
    numbVertices = 0;
    adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    for(int row = 0; row < MAX_VERTICES; row++){
      for(int col = 0; col < MAX_VERTICES; col++){
          //init all as disconnected 
          adjMatrix[row][col] = -1;
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
        if(adjMatrix[currentVertex][linkToVertex] == -1) continue;
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