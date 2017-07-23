import java.util.*;

class Solution {




  public static boolean isValidSudoku(char[][] board) {
    //rules: column, row, box 
    //int box = (row/3)*3 + (col/3);
    int rows = board.length;
    int cols = board[0].length;

    if (cols != 9 || rows != 9) return false;
    
    Map<Integer, List<Character>> entireRow = new HashMap<>();
    Map<Integer, List<Character>> entireCol = new HashMap<>();
    Map<Integer, List<Character>> entireBox = new HashMap<>();
    
    for(int i = 0; i < 9; i++) {
      entireRow.put(i, new ArrayList<>());
      entireCol.put(i, new ArrayList<>());
      entireBox.put(i, new ArrayList<>());
    }

    for(int row = 0; row < rows; row++){
      for(int col = 0; col < cols; col++) {
        char element = board[row][col];
        if(element != '.') {
          //System.out.println("el->" + element);
          int box = (row/3)*3 + (col/3);
          boolean inRow = entireRow.get(row).contains(element);
          boolean inCol = entireCol.get(col).contains(element);
          boolean inBox = entireBox.get(box).contains(element);
          if(inRow || inCol || inBox) {
            return false;
          } else {
            entireRow.get(row).add(board[row][col]);
            entireCol.get(col).add(board[row][col]);
            entireBox.get(box).add(board[row][col]);
          }
        }

      }

    }


    return true;
  }
  
  public static char[][] stringarrToChar(String[] board) {
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
    String[] board = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
    System.out.println(isValidSudoku(stringarrToChar(board)));
    board = new String[]{"......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."};
    System.out.println(isValidSudoku(stringarrToChar(board)));
  }
}