import java.util.*;
class Solution{



  public int minPathSum(int[][] grid) {
   //DFS
   //coordinates
   Deque<int[]> pairs = new ArrayDeque<>();
   int minSum= Integer.MAX_VALUE;
   int rows = grid.length;;
   int columns = grid[0].length;
   pairs.push(new int[]{0,0});
   Deque<Integer> sums = new ArrayDeque<>();
   int currRow = 0; 
   int currCol = 0;
   sums.push(grid[currRow][currCol]);

   while(true){
    if(checkvalid(currRow+1, currCol)){

    }
    if(checkvalid(currRow, currCol+1))
    break;
   }


   return 0;
  }


 public static void main(String[] args){
  Solution caller = new Solution();
  caller.minPathSum(new int[][]{{1,2,3}, {1,2,3}});
 }
}