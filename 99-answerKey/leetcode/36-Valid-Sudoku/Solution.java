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
			System.out.println("box: " + i + " gets row: " + row);
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

	public static void main(String[] args)
	{
		String[] board = new String[]{"......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."};
		System.out.println(isValidSudoku(stringarrToChar(board)));
	}

}
