import java.util.*;
class Solution {
/**
 *0: 123|
 *1: 456|
 *2: 789|
 */
 public static boolean isValidSudoku(char[][] board){
  Map<Integer, List<Integer>> cheatRow = new HashMap<>();
  Map<Integer, List<Integer>> cheatCol = new HashMap<>();
  Map<Integer, List<Integer>> cheatBox = new HashMap<>();
  int i = 0;
  int row =  board.length;
  int col = board[0].length;
  while(i < row)  {
   cheatRow.put(i, new ArrayList<>());
   cheatCol.put(i, new ArrayList<>());
   cheatBox.put(i, new ArrayList<>());
   i++;
  }
  char c; 
  if(row != 9 && col != 9){return false;}
  for(i = 0; i < row; i++){
   for(int j = 0; j < col; j++){
    if((c=board[i][j])!= '.'){
     int mark = c;
     int box = ((j/3) + (i/3)*3);
     if( !cheatRow.get(i).contains(mark) && !cheatCol.get(j).contains(mark) && !cheatBox.get(box).contains(mark) ){
      cheatRow.get(i).add(mark);
      cheatCol.get(j).add(mark);
      cheatBox.get(box).add(mark);
     } else{
      return false;
     }
    }
   }
  }
  return true;
 }

  public static char[][] stringarrToChar(String[] board)
 {
  int len = board.length , i, j;
  String flatBoard = "";
  char[][] finB = new char[9][9];
  for(i = 0; i < len; i++)
  {
   String word = board[i];
   for(j = 0; j < word.length() ; j++)
   {
    finB[i][j] = word.charAt(j);
    if(word.charAt(j) == '.')
    {
     System.out.print(" 0 ");
    }
    else
    {
     System.out.print(" " + finB[i][j] + " ");
    }
   }
   System.out.println();
  }
  return finB;
 }

 public static void main(String[] args) {
  //
 String[] board = new String[]{"......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."}; //F
 System.out.println(isValidSudoku(stringarrToChar(board)));
 board = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 board = new String[]{".........","4........","......6..","...38....",".5...6..1","8......6.",".........","..7.9....","...6....."};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 board = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 }
}