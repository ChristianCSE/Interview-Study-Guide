
import java.util.*;


class Dijkstra {
  public static void intit(double[] distances, Integer[] previous, int target) {
   for(int i = 0; i  < distances.length; i++) {
    if(distances[i] == target) {
     distances[i] = 0; //distance is 0 since starting point
    }
    distances[i] = Double.MAX_VALUE; //all infinite
    previous[i] = null; //Object
   }
  }

  public static Integer[] shortestPath(Graph graph, int source, int target) {
   Queue<VertexDistancePair> q = new PriorityQueue<>();
   double[] distances = new double[graph.size()];
   Integer[] previous = new Integer[graph.size()];
   Set<Integer> vertixVisted = new HashSet<>();
   intit(distances, previous, target);
   q.add(new VertexDistancePair(0, target));
   while(!q.isEmpty()) {
    //visit what is on top
    VertexDistancePair current = q.poll();
    visited.add(current.vertex);

   }
   return null;
  }



  public static class VertexDistancePair{
    double distance;
    int vertex;
   public VertexDistancePair(double distance, int vertex){
    this.distance = distance;
    this.vertex = vertex;
   }
  }

  public static void main(String[] args) {

  }
}