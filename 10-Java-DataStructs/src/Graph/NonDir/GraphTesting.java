package Graph.NonDir;

/**
 * Created by Christian on 12/11/16.
 */
public class GraphTesting {

  public static void main(String[] args) {
    Graph graph = new Graph(6);
    graph.insertEdge("a", "b", 0);
    graph.insertEdge("b", "c", 0);
    graph.insertEdge("c", "a", 0);
    graph.insertEdge("z", "b", 0);
    graph.insertEdge("c", "g", 0);
    graph.BFS("a", "g");
    }
  }
