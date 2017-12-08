import java.util.Stack;

public class NQueens {

    //index = row
    //what's stored is col index
    static Stack<Integer> board = new Stack<Integer>();
    static int currentColumn  = 0;
    static int totalSolutions = 0;

    public static int solve(int n) {
        while(true) {      
            
            if(currentColumn  < n && validPosition(currentColumn)) {
                board.push(currentColumn );
                currentColumn  = 0;
            }
            
            //backtracking
            else if(currentColumn  >= n) {
                //tried all columns revert back to old row
                if(board.empty()) {
                    break;
                } 
                currentColumn = board.pop() + 1; //try the next column
            }
            else{
            	currentColumn ++; //prev colum proved invalid, try other
            }

            if(board.size() == n) {
                //printSolution(board);
                totalSolutions++; 
                //pop the previous column and now try the next column
                currentColumn = board.pop()+1; 
            }

        }
        return totalSolutions;
    }

    public static int solver(int n) {
        Stack<Integer> rowIndexColInside = new Stack<>();
        rowIndexColInside.push(0);
        int onColumn = 0;
        while(!rowIndexColInside.isEmpty()){
            if(onColumn < n && checkValid(onColumn, rowIndexColInside)){
                rowIndexColInside.push(onColumn);
                onColumn = 0;
            } else if(onColumn >= n) {
                //remove previous row attempt try another column
                onColumn = rowIndexColInside.pop() + 1;
            } else {
                //try next col on same row
                onColumn++;
            }
            if(rowIndexColInside.size() == n){
                printSolution(rowIndexColInside);
                //pop your current col attempt and try the next one
                onColumn = rowIndexColInside.pop() + 1;
            }
        }
        return 0;
    }

    public static boolean checkValid(int col, Stack<Integer> rowCol){
        int myRow = rowCol.size();
        for(int oldRow = 0; oldRow < rowCol.size(); oldRow++){
            int oldCol = rowCol.get(oldRow);
            //no row check since adding by row
            //check col
            if(col == oldCol)return false;
            //check diag /  [2,2] [1,3] same diag ==> r+c = 4
            if((oldRow+oldCol)==(myRow+col))return false;

            //check diag \ [2,2] [0,0] same diag ==> r-c = 0
            if((oldRow-oldCol)==(myRow-col))return false;
        }
        return true;

    }

    public static boolean validPosition(int column)  {
      int len = board.size();
      int yourRow = board.size(); 
      //validate newly added position with rest of board that has been populated
        //no need for row check since we insert by row 
        for(int inrow = 0; inrow < len; inrow++) {
          int queensColumnPosition = (int)board.get(inrow); //get inrow's column (inrow, colum)

          //in same column
          if( queensColumnPosition == column){
            return false; 
          }

          // \ diagonal => (row-col == row-col)
          if((inrow - queensColumnPosition) == (yourRow - column)){
            return false;

          }
          // / diagonal => (row+col == row+col)
          if((inrow + queensColumnPosition) == (yourRow + column)){
            return false;
          }

        }
        return true; 
    }

    
    private static void printSolution(Stack<Integer> s) {
        for (int row = 0; row < s.size(); row++) {
            for (int col = 0; col < s.size(); col ++) {
                if (col == s.get(row))
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }//for
            System.out.println();
        }//for
        System.out.println();
    }
    
    
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
