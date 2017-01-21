import java.util.*;
class Solution {


 public static void flipped(int[][] board, List<Integer[]> dead, List<Integer[]> light){
  Map<Integer, List<Integer>> deadareas = new HashMap<>();
  Map<Integer, List<Integer>> litareas = new HashMap<>();
  int now = 0;
  int rowlen = board.length;
  for(Integer[] arr : dead){
    getBanned(arr[0], arr[1], rowlen, board[now].length, deadareas);
    now++;
  }
  now = 0;
  rowlen = board.length;
  for(Integer[] arr: light){
    getDiagonals(arr[0], arr[1], rowlen, board[now].length, litareas);
    now++;
  }

  for(Integer rows : litareas.keySet()){
    for(Integer cols : litareas.get(rows)){
      if(deadareas.containsKey(rows) && !deadareas.get(rows).contains(cols)){
        board[(int)rows][(int)cols] = 1;
      }
      if(!deadareas.containsKey(rows)){
        board[(int)rows][(int)cols] = 1;
      }
    }
  }
  
  for(int i = 0; i < rowlen; i++){
    System.out.print(i+"      ");
    for(int j = 0; j < board[i].length; j++){
      System.out.print(board[i][j]+" | ");
    }
    System.out.println();
  }
 }


 public static void getDiagonals(int row, int col, int rows, int cols, 
  Map<Integer, List<Integer>> map){
  placer(row, col, map);
  int upLeftR = row-1;
  int upLeftC = col-1;
  //     \
  while( upLeftR >= 0 && upLeftC >= 0){
    placer(upLeftR, upLeftC, map);
    upLeftR--;
    upLeftC--;
  }

  //     \
  int downLeftR= row+1;
  int downLeftC= col-1;
  while(downLeftC >= 0 && downLeftR < rows){
    placer(downLeftR, downLeftC, map);
    downLeftR++;
    downLeftC--;
  }

  //  /
  int upRightR= row-1;
  int upRightC= col+1;
  while (upRightR >= 0 && upRightC < cols){
    placer(upRightR, upRightC, map);
    upRightR--;
    upRightC++;
  }
  
  //    /
  int downRightR= row+1;
  int downRightC= col-1;
  while (downRightR < rows && downRightC >= 0){
    placer(downRightR, downRightC, map);
    downRightR++;
    downRightC--;
  }

  int leftCols = col-1;
  while(leftCols >= 0){
    placer(row, leftCols, map);
    leftCols--;
  }

  int rightCols = col+1;
  while(rightCols < cols){
    placer(row, rightCols, map);
    rightCols++;
  }

  int upRow = row-1;
  while(upRow>=0){
    placer(upRow, col, map);
    upRow--;
  }

  int downRow = row+1;
  while(downRow<rows){
    placer(downRow, col, map);
    downRow++;
  }

 }

 public static void placer(int row, int col, Map<Integer, List<Integer>> map){
  if(map.containsKey(row)){
    map.get(row).add(col);
  }
  else{
    map.put(row, new ArrayList<>());
    map.get(row).add(col);
  }
 }

 public static void getBanned(int row, int col, int rows, int cols,
  Map<Integer, List<Integer>> map){
  placer(row, col, map);
  if(row-1 >= 0 && col-1 >= 0){
    placer(row-1, col-1, map);
  }
  if(row-1 >= 0){
    placer(row-1, col, map);
  }
  if(row+1<rows){
    placer(row+1, col, map);
  }
  if(row+1 < rows && col+1 < cols){
    placer(row+1, col+1, map);
  }
  if(col-1 >= 0){
    placer(row, col-1, map);
  }
  if(col+1 < cols){
    placer(row, col+1, map);
  }
  if(row+1 < rows && col-1 >= 0){ 
    placer(row+1, col-1, map);
  }
  if(row+1 < rows && col+1 < cols){
    placer(row+1, col+1, map);
  }
 }

 public static void main(String[] args){
 // int[][] board = {{0, 0, 0, 0,0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0 }, {0, 0, 0, 0, 0}};
 int[][] board = {{0, 0, 0, 0,0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0,0, 0 }, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
 List<Integer[]> ban = new ArrayList<>();
 ban.add(new Integer[]{1, 1});
 List<Integer[]> alive = new ArrayList<>(); 
 alive.add(new Integer[]{2, 3});
 flipped(board, ban, alive);
 }
}