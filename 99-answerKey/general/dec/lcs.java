import java.util.*; 
class lcs {

  public static String recurisveLCS(String upper, String lower, int i, int j) {
   return reLCS(upper.toCharArray(), lower.toCharArray(), i-1, j-1);
  }

  public static String reLCS(char[] up, char[] down, int i, int j) {
   //no more to go 
   if(i < 0 || j < 0) {
    return ""; 
   }
   //successful match 
   if(up[i] == down[j]) {
    return reLCS(up, down, i-1, j-1) + up[i]; //matched hence move down simultaneously 
   }
   //maybe it matches next?
   String upMove = reLCS(up, down, i-1, j); 
   String downMove = reLCS(up, down, i, j-1);
   if(upMove.length() > downMove.length() ) {
    return upMove;
   }
   else
   {
    return downMove;
   }
  }


  public static void dynoLCS(String a, String b) {
   
   //need to create board => provides length 
   //retrieve actual LCS
   char[] up = a.toCharArray(); 
   char[] down = b.toCharArray(); 
   int row = up.length; 
   int col = down.length; 
   System.out.println(getLCS(up, down, dynoBoard(up, down, row, col), row-1, col-1));
  }


  public static int[][] dynoBoard(char[] up, char[] down, int row, int col) {
   //init board as blank
   int[][] board = new int[row][col];
   //the logic we follow forces us to start at row 1 col 1
   //if not, then we'd do board[-1][-1] if we matched on index 0  
   for(int i = 1; i < row; i++) {
    for(int j =1; j < col; j++) {
     //is it a match? 
     if(up[i] == down[j]) {
      board[i][j] = board[i-1][j-1] + 1; 
     }//if not who is greater? up or left? 
     else
     { 
      if( board[i-1][j] >  board[i][j-1]) {
       board[i][j]  = board[i-1][j];
      }
      else{
       board[i][j]  = board[i][j-1];
      }
     }
    }
   }
   return board;
  }

  public static String getLCS(char[] up, char[] down, int[][] table, int row, int col) {
   //got the board filled now retrieve our actual string
   //start from the corner end 
   //sanity checks: off the board
   if( row < 0 || col < 0) { return "";}
   if(up[row]==down[col]) {return getLCS(up, down, table, row-1, col-1) + up[row];}
   //either go up or left, whichever contains the greater value
   /**
    * FORGOT the case of when one of the indices is = 0
    */
   if(row == 0){
    return getLCS(up, down, table, row, col-1);
   }
   if(col == 0){
    return getLCS(up, down, table, row-1, col);
   }   
   if(table[row-1][col] > table[row][col-1]) {
    return getLCS(up, down, table, row-1, col);
   }
   else{
    return getLCS(up, down, table, row, col-1);
   }
  }





  public static void main(String[] args){
   //abyehs aymmel
   String one = "abyehs";
   String two = "aymmel";
   System.out.println(recurisveLCS(one, two, one.length(), two.length())); 
   dynoLCS(one, two);
  }
}