

class Solution {





  public static void main(String[] args) {
    UndirectedGraph graph = new UndirectedGraph(20);
    graph.addVertex("A"); //0
    graph.addVertex("B"); //1
    graph.addVertex("C"); //2
    graph.addVertex("D"); //3
    graph.addVertex("E"); //4
    graph.addVertex("F"); //5

    graph.addEdge(0, 1, 6, true); //A---6-->B
    graph.addEdge(0, 3, 4, true); //A---4-->D
    graph.addEdge(1, 2, 10, true); //B---10-->C
    graph.addEdge(1, 3, 7, true); //B---7-->D
    graph.addEdge(1, 4, 7, true); //B---7-->E
    graph.addEdge(2, 3, 8, true); //C---8-->D
    graph.addEdge(2, 4, 5, true); //C---5-->F
    graph.addEdge(2, 5, 6, true); //C---6-->E
    graph.addEdge(3, 4, 12, true); //D---12-->E
    graph.addEdge(4, 5, 7, true); //E---7-->F

    graph.MSTWeighted();
    

  }
}