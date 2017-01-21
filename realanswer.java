public class Solution {
    public static void gameOfLife(int[][] board) {
    List<Integer> rowAbove = new ArrayList<>();
    List<Integer> prepareNext = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int row = board.length; 
    int col = board[0].length; 
    for(int i = 0; i < row; i++){
        for( int j = 0; j < col; j++){
            prepareNext.add(board[i][j]);
            curr.add(determineLife(i, j, board, rowAbove, row, col));
            if(j+1 == col){    
                for(int o = 0; o < curr.size(); o++) {
                    board[i][o] = curr.get(o);
                }
            }
        }
        curr = new ArrayList<>();
        rowAbove = prepareNext; 
        prepareNext = new ArrayList<>();
    }
}

public static  int determineLife(int row, int col, int[][] board, List<Integer> rowAbove, int rows, int cols){
   int me = board[row][col];
   int neighbors = 0;
   
   int leftAcr = (row-1 >= 0 && col-1 >= 0) ? rowAbove.get(col-1): 0;
   int up = (row - 1 >= 0) ? rowAbove.get(col):0; 
   int rightAcr = (row-1 >= 0 && col+1 <  cols)?  rowAbove.get(col+1): 0;
   int right = (col + 1 < cols) ? board[row][col+1]: 0;
   int left = (col-1 >= 0) ? board[row][col-1]: 0;
   
   int down =  (row + 1 < rows)? board[row+1][col]:0;
   int rightDownAcr = (row+1 < rows && col + 1 < cols) ? board[row+1][col+1]:0; 
   int leftDownAcr = (row+1 < rows && col - 1 >= 0) ? board[row+1][col-1]:0; 
   
   neighbors =  leftAcr+  up+ rightAcr+ right + left + down + rightDownAcr + leftDownAcr;
   
   if(me == 0){
    if(neighbors == 3){
     return 1;
    } else {
     return 0; 
    }
   } else {
    if(neighbors == 2 || neighbors == 3) {
     return 1;
    } else {
     return 0;
    }
   }
  } 
}