import java.util.*;
class failed {

 public static void banner(int row, int col, int rows, int cols, List list){
  // int leftup = (row-1 && col-1);
  if(row-1 >= 0 && col-1 >= 0){
   list.add(new int[]{row-1, col-1} );
  }
  // int up = (row-1 => 0): 
  if(row-1 >= 0){
   list.add(new int[]{row-1, col});
  }
  // int rightup = (row-1 + col+1);
  if(row+1 < rows && col+1 < cols){
   list.add(new int[]{row+1, col+1});
  }
  // int left = (col-1);
  if(col-1 >= 0){
   list.add(new int[]{row, col-1});
  }
  // int right = (col+1);
  if(col+1 < cols){
   list.add(new int[]{row, col+1});
  }
  // int leftDown = (row+1 + col-1);
  if(row+1 < rows && col-1 >= 0){
   list.add(new int[]{row+1, col-1});
  }
  // int rightDown = (row+1 + col+1)
  if(row+1 < rows && col+1 < cols){
   list.add(new int[]{row+1, col+1});
  }
  
 }

 public static void main(String[] args){

 }
}