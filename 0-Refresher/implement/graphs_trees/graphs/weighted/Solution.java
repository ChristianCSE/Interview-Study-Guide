import java.util.*;

class Solution {





  public static void main(String[] args) {

    Graph undirectedGraph = new Graph(20);
    undirectedGraph.addVertex("A"); //0
    undirectedGraph.addVertex("B"); //1
    undirectedGraph.addVertex("C"); //2
    undirectedGraph.addVertex("D"); //3
    undirectedGraph.addVertex("E"); //4
    undirectedGraph.addVertex("F"); //5

    undirectedGraph.addEdge(0, 1, 6, true); //A---6-->B
    undirectedGraph.addEdge(0, 3, 4, true); //A---4-->D
    undirectedGraph.addEdge(1, 2, 10, true); //B---10-->C
    undirectedGraph.addEdge(1, 3, 7, true); //B---7-->D
    undirectedGraph.addEdge(1, 4, 7, true); //B---7-->E
    undirectedGraph.addEdge(2, 3, 8, true); //C---8-->D
    undirectedGraph.addEdge(2, 4, 5, true); //C---5-->F
    undirectedGraph.addEdge(2, 5, 6, true); //C---6-->E
    undirectedGraph.addEdge(3, 4, 12, true); //D---12-->E
    undirectedGraph.addEdge(4, 5, 7, true); //E---7-->F

    undirectedGraph.MSTWeighted();


    Graph directedGraph = new Graph(20);
    String[] sketch = new String[]{"A", "B", "C", "D", "E"};
    directedGraph.addVertex(sketch[0]); // 0 start 
    directedGraph.addVertex(sketch[1]); // 1
    directedGraph.addVertex(sketch[2]); // 2 
    directedGraph.addVertex(sketch[3]); // 3
    directedGraph.addVertex(sketch[4]); // 4

    directedGraph.addEdge(0, 1, 50, false); //A---50---->B
    directedGraph.addEdge(0, 3, 80, false); //A---80---->D
    directedGraph.addEdge(1, 2, 60, false); //B---60---->C
    directedGraph.addEdge(1, 3, 90, false); //B---90---->D
    directedGraph.addEdge(2, 4, 40, false); //C---40---->E
    directedGraph.addEdge(3, 2, 20, false); //D---20---->C
    directedGraph.addEdge(3, 4, 70, false); //D---70---->E
    directedGraph.addEdge(4, 1, 50, false); //E---50---->B

    //A-D-C-E
    DistancePairs[] path = directedGraph.dijkstra(0, 4);
    int parentVertex = 4;
    Deque<String> shortestPath = new ArrayDeque<>();
    DistancePairs currVertex = path[parentVertex];
    shortestPath.push(sketch[parentVertex]);
    while(currVertex.distance != Integer.MAX_VALUE) {
      shortestPath.push(sketch[currVertex.parentVertex]);
      currVertex = path[currVertex.parentVertex];
    }

    while(!shortestPath.isEmpty()){
      System.out.print(shortestPath.pop() + " " );
    }

    

  }
}