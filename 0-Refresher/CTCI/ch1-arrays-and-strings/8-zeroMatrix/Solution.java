/*inefficient*/

class Solution {


  public static void clearRowsCols(int row, int col, int[][] arr) {
    int len = arr.length;
    for(int i = 0; i < len; i++) {
      arr[row][i] = 0;
      arr[i][col] = 0;
    }
  }

  //WRONG 
  //NEW ZEROS INFLUENCE THE RESULT
  public static void spreadZeros(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    if(rows != cols) return;

    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        if(arr[row][col] == 0) {
          clearRowsCols(row, col, arr);
        }
      } 
    }
  }


  public static void clearRows(int row, int[][] arr){
    int len = arr[0].length;
    for(int i = 0; i < len; i++) {
      arr[row][i] = 0;
    }
  }

  public static void clearCols(int col, int[][] arr){
    int len = arr.length;
    for(int i = 0; i < len; i++) {
      arr[i][col] = 0;
    }
  }

  public static void preExistingZeros(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    if(rows != cols) return;
    boolean[] markedRows = new boolean[rows];
    boolean[] markedCols = new boolean[cols];
    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        if(arr[row][col] == 0) {
          markedRows[row] = true;
          markedCols[col] = true;
        }
      }
    }
    //we know what to clear now & not influencing with new 0's
    for(int i = 0; i < rows; i++) {
      if(markedRows[i]) clearRows(i, arr);
    }
    for(int i = 0; i < cols; i++) {
      if(markedCols[i]) clearCols(i, arr);
    }
  }


  public static void main(String[] args) {
    int[][] arr = {
      {1, 2, 3}, 
      {1, 0, 3}, 
      {1, 2, 3}};
    preExistingZeros(arr);
    for(int[] row : arr) {
      System.out.println(java.util.Arrays.toString(row));
    }
  }
}