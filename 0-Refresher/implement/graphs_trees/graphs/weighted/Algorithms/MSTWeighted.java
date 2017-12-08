import java.util.*;

class MSTWeighted {

  Vertex vertextList[] = new Vertex[20];
  int adjMatrix[][] = new int[20][20];
  int INFINITY = Integer.MAX_VALUE;
  int numbVertices = 20;

  /*MST (Weighted Summary)
    1. 
    2. 
    3.
    4.
   */
  public void MSTWeightedAlg() {

    int currentVertex = 0; 
    //keep shortest distance on top!
    PriorityQueue<Edge> pq = new PriorityQueue<>(10, new Comparator<Edge>(){
      public int compare(Edge a, Edge b) {
        return Integer.compare(a.distance, b.distance);
      }
    });

    List<Integer> visted = new ArrayList<>();
    Deque<Edge> mst = new ArrayDeque<>();
    visted.add(currentVertex);
    
    while(visted.size()!= numbVertices) {
      /* Push all our vertice's neighbors (constraints: not visted, can link to them, not you)*/
      for(int linkToVertex = 0; linkToVertex < numbVertices; linkToVertex++) {
        if(currentVertex == linkToVertex) continue; //is it you?
        if(visted.contains(linkToVertex)) continue;
        if(adjMatrix[currentVertex][linkToVertex] == INFINITY) continue; //check if we can even link to it
        /*We proved we can link to this vertex, add it to PQ, we still don't know 
        the vertex we will follow (we want to follow the min distance vertex) */
        addToPQ(currentVertex, linkToVertex, adjMatrix[currentVertex][linkToVertex], pq);
      }

      if(pq.isEmpty()){
        System.out.println("MORE THAN ONE GRAPH EXISTS HERE!");
        return; //kill it!
      }
      //get the vertex with the smallest edge
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
}






////////////////////////////////////////////////////////////////////////////////////////////////////





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