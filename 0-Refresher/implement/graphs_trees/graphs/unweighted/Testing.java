import java.util.*;


class Testing {



  public static void warshallsAlgorithm(int[][] adjMatrix) {
    int len = adjMatrix.length;
    for(int row = 0; row < len; row++) {
      //before bothering to link paths
      //check if there is anything to link (A->C) is useless if no X for (X->C)
      List<Integer> successorTo = getSuccessorTo(adjMatrix, row);

      if(successorTo.size()!=0) {
        //there are links to connect!
        for(int col = 0; col < len; col++) {
          if(adjMatrix[row][col] == 1) {
            //a connection exists => we can link our "parent's" to it
            for(int aRow: successorTo) {
              adjMatrix[aRow][col] = 1;
            }
          }
        }
      }
    }
  }

  public static List<Integer> getSuccessorTo(int[][] adjMatrix, int row) {
    List<Integer> successorTo = new ArrayList<>();
    int len = adjMatrix.length;
    //look down the row = adjMatrix[row][0=>len]
    for(int col = 0; col < len; col++) {
      if(adjMatrix[col][row] == 1) {
        successorTo.add(col);
      }
    }
    return successorTo;
  }


  public static List<String> topologicalSort(int[][] adjMatrix){
    //get the Vertex without successors (it's column is empty of 1's)
    //insert it at the end of our list! 
    //delete it from existence (as a row, col, vertex)
    


    return null;
  }




  public static List<String> minSpanningTree(int[][] adjMatrix){
    
    return null;
  }




  public static void main(String[] args) {
    /*  A  B   C   D  E
      A 0  0   1   0  0
      B 1  0   *   0  1
      C 0  0   0   0  0
      D 0  0   *   0  1
      E 0  0   1   0  0
     */
    //* => connections made by warshallsAlgorithm
    int[][] adjMatrix = {
      {0, 0, 1, 0, 0}, 
      {1, 0, 0, 0, 1},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1},
      {0, 0, 1, 0, 0}
    };
    warshallsAlgorithm(adjMatrix);
    for(int[] row : adjMatrix) {
      System.out.println(Arrays.toString(row));
    }
  }
}