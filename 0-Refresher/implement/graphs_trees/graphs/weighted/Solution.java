

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

    

  }
}