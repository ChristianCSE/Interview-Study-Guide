import java.util.*;

class Solution{

	public static boolean isValidSudoku(char[][] board)
	{
		if(board == null || board[0].length != 9 || board.length != 9)
		{
			return false; //invalid case
		}
		Set<Character> row;
		Set<Character> col;
		//row and col are indices inverse
		for(int i = 0; i < 9; i++)
		{
			//col i and row i are being tested
			row = new HashSet<>();
			col = new HashSet<>();
			for(int j = 0; j < 9; j++)
			{
				//add to row and add to col and check for repeats
				if( board[i][j] != '.')
				{
					if( !row.add(board[i][j] ) )
					{
						return false;
					}
				 }
					if( board[j][i] != '.')
					{
					if( !col.add(board[j][i]) )
						{
							return false;
						}
					}
			 }
		  }
		  if(!checkBox(board))
		  {
		  		return false;
		  }
		  //check boxes = 9 boxes
		return true;
	}


	//checking individual boxes
	public static boolean checkBox(char[][] board)
	{
		int i, j, k = 0;
		int add = 0;
		int row, stoprow;
		Set<Character> box;
		for(i = 0; i < 9; i++)
		{
			//set box
			box = new HashSet<>();
			if(i -2 <= 0)
			{
				row = 0;
				stoprow = 2;
			}
			else if(i-3 <= 5 && i-6 < 0)
			{
				row = 3;
				stoprow = 5;
			}
			else
			{
				row = 6;
				stoprow = 8;
			}
			//row
		//	System.out.println("box: " + i + " gets row: " + row);
			for(j = row; j <= stoprow; j++)
			{
				//cols
				for(k = 3*(i%3); k <= 2 + (i%3)*3; k++)
				{
					if(board[j][k] != '.'){
						if( !box.add( board[j][k]) )
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}

public static boolean isValidSudokuBetter(char[][] board){
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
	//				System.out.print(" 0 ");
				}
				else
				{
	//				System.out.print(" " + finB[i][j] + " ");
				}
			}
	//		System.out.println();
		}
		return finB;
	}

 public static boolean attemptSudoku(char[][] board){
  Map<Integer, List<Integer>> rows = new HashMap<>(); 
  Map<Integer, List<Integer>> cols = new HashMap<>(); 
  Map<Integer, List<Integer>> boxes = new HashMap<>();
  //int box = 3*(row/3) + (col/3)
  int totalRows = board.length;
  int totalCols = totalRows;
  for(int row = 0; row < totalRows; row++){
   for(int col = 0; col < totalCols; col++){
    char c = board[row][col];
    if(c!= '.'){
     int val = Character.getNumericValue(c);
 // /    System.out.println(c);
    if(!validator(val, row, col, rows, cols, boxes)){
     return false;
    }
    }
   }
  }
  return true;
 }

 public static boolean validator(int val, int row, int col, 
  Map<Integer, List<Integer>> rows, Map<Integer, List<Integer>> cols, Map<Integer, List<Integer>> boxes ){
  int box = 3*(row/3)  + (col/3);
  //row check => get row check if inside that row
  if(seenitbefore(val, row, rows)){
   return false;
  }
  //col check => get col check if inside that col
  if(seenitbefore(val, col, cols)){
   return false;
  }
  //box check => get box check if inside that col
  if(seenitbefore(val, box, boxes)){
   return false;
  }
  return true;
 }

 public static boolean seenitbefore(int val, int search, Map<Integer, List<Integer>> map){
  if(map.containsKey(search)){
   //alread made this now check if your value is inside 
   if(map.get(search).contains(val)){
    //System.out.println(map.get(search)+"      "+search);
    return true;
   } else{
    map.get(search).add(val);
    return false;
   }
  } else {
   map.put(search, new ArrayList<>());
   map.get(search).add(val);
   return false;
  }
 }


	public static void main(String[] args)
	{
String[] board = new String[]{"......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."}; //F
 System.out.println(isValidSudoku(stringarrToChar(board)));
 System.out.println("my new attempt:F      " + attemptSudoku(stringarrToChar(board)));
 board = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 System.out.println("my new attempt:T      " + attemptSudoku(stringarrToChar(board)));
 board = new String[]{".........","4........","......6..","...38....",".5...6..1","8......6.",".........","..7.9....","...6....."};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 System.out.println("my new attempt:T      " + attemptSudoku(stringarrToChar(board)));
 board = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};//T
 System.out.println(isValidSudoku(stringarrToChar(board)));
 System.out.println("my new attempt:T      " + attemptSudoku(stringarrToChar(board)));
	}

}
