import java.util.Stack;

public class NQueens {
    static Stack<Integer> board = new Stack<Integer>();
    static int currentPosition = 0;
    static int totalSolutions = 0;

    public static int solve(int n) {
        while(true) {      
            if(currentPosition < n && validPosition(currentPosition)) 
            {
                board.push(currentPosition);
                currentPosition = 0;
            }//if()
            //backtracking
            else if(currentPosition>=n) 
            {
                if(board.empty()) 
                {
                    break;
                }
                if(!board.empty()) 
                {
                    currentPosition=board.pop()+1;
                }
            }//elseif()
            else
            {
            	currentPosition++;
            }
            if(board.size() == n) 
            {
                currentPosition++;
                totalSolutions++; 
                currentPosition = board.pop()+1;
            }
        }
        return totalSolutions;   
    }

    public static boolean validPosition(int column)  {
      int position = 0, inrow; 
      int len = board.size(), diff; 
        for( inrow = 0; inrow < len; inrow++) 
        {
          position = (int)board.get(inrow);

          diff = len - inrow;
          if( position == column)
          {
            return false; 
          }
          if( (column - position) == diff)
          {
            return false;
          }
          if( (position - column) == diff)
          {
            return false;
          } 
        }
        return true; 
    }
    private static void printSolution(Stack<Integer> s) {
        for (int i = 0; i < s.size(); i ++) {
            for (int j = 0; j < s.size(); j ++) {
                if (j == s.get(i))
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }//for
            System.out.println();
        }//for
        System.out.println();
    }//printSolution()
    
    
    public static void main(String[] args) 
    {    
        int n = 8;
        if (args.length == 1) {
            n = Integer.parseInt(args[0].trim());
            if (n < 1) {
                System.out.println("Incorrect parameter");
                System.exit(-1);
            }//if()
        }//if()
        int number = solve(n);
        System.out.println("There are " 
          + number + " solutions to the " 
          + n + "-queens problem.");
    }
}
