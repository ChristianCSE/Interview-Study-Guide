import java.util.*; 
class Dijkstra {
  int adjMatrix[][] = new int[20][20];
  int INFINITY = Integer.MAX_VALUE;
  int numbVertices = 20;


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
      int currVertex = getMin(shortestPath, visted);
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

  //Could be done with a Queue
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






/////////////////////////////////////////////////////////////////////////////////



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