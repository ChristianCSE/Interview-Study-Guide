

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;



 class Positio {
  public int i;     //row
  public int j;     //column
  public char val;  //1, 0, or 'X'
  
  Position parent;
  
  public Position(int x, int y, char v) {
    i=x;
    j = y; 
    val=v;
  }
  
  Position(int x, int y, char v, Position p) {
    i = x; 
    j = y; 
    val=v;
    parent=p; 
    // reference to the previous position (parent) that leads to this position on a path
  }
  
}

public class PathFinder 
{
  
  public static Position [] stackSearch(char [] [] maze)
  {
    ArrayDeque<Position> mazestack = new ArrayDeque<Position>(); 
    char ends = maze[0][0];
    Position enter = new Position(0, 0, ends);  
    Position[][] end = new Position[maze.length][maze.length];
    mazestack.push(enter); 
      while(!mazestack.isEmpty()) 
        {
           enter = mazestack.pop(); 
          if(enter.i == maze.length-1 && enter.j == maze.length-1) 
          {
            ArrayDeque<Position> Depthpath = new ArrayDeque<Position>();
            while(enter!=null) 
            {
              maze[enter.i][enter.j]='X';
              Depthpath.push(enter);
              enter = end[enter.i][enter.j];
            }
            int sizetrack = Depthpath.size();
            Position [] returningthis = new Position [sizetrack];
            int i=0; 
            while(!Depthpath.isEmpty()) {
              //i++;
              returningthis[i++] = Depthpath.pop(); 
            }
            return returningthis;
          }
        maze[enter.i][enter.j] = '-'; 
        if( enter.j < maze.length-1 && maze[enter.i][enter.j + 1] == '0') 
        {
          //check right, max = array reference for columns
          Position right = new Position(enter.i, enter.j + 1, ' ', enter);
          mazestack.push(right);
          end[enter.i][enter.j + 1] = enter;
        }
        if( enter.i < maze.length-1 && maze[enter.i + 1][enter.j] == '0')
        {
          //check bottom, max = array reference for rows
          Position bottom = new Position(enter.i + 1, enter.j, ' ', enter);
          mazestack.push(bottom);
          end[enter.i + 1][enter.j] = enter;
        }
        if( enter.j > 0 && maze[enter.i][enter.j - 1] == '0') 
        {
          // check left as long as you're not in the zero column 
          Position left = new Position(enter.i, enter.j - 1, ' ', enter);
          mazestack.push(left);
          end[enter.i][enter.j - 1] = enter;
        }
        if( enter.i > 0 && maze[enter.i - 1][enter.j] == '0') 
        {
          // check top as long as you're not in the zero row 
          Position top = new Position(enter.i - 1, enter.j, ' ', enter);
          mazestack.push(top);
          end[enter.i - 1][enter.j] = enter;
        }
      }//while()
    return null;  
  }
  
  public static Position [] queueSearch(char [] [] maze)
  {
    ArrayDeque<Position> mazeQ = new ArrayDeque<Position>();
    char ends = maze[0][0];
    Position enter = new Position(0, 0, ends); 
    mazeQ.addFirst(enter);
  
    while(!mazeQ.isEmpty()) {
        enter = mazeQ.removeFirst(); 
        if(enter.i == maze.length-1 && enter.j == maze.length-1) {
           
          ArrayDeque<Position> Breadthpath = new ArrayDeque<Position>();
          
          while(enter!=null) {
            maze[enter.i][enter.j]='X'; //can only have one char
            Breadthpath.push(enter);
            enter= enter.parent; 
          }
          Position [] returningthis = new Position [Breadthpath.size()];
          int i=0; 
          while(!Breadthpath.isEmpty()) {
            returningthis[i++] = Breadthpath.pop();
          }
          return returningthis;
        }
        maze[enter.i][enter.j] = '-'; 
      if( enter.j < maze.length-1 && maze[enter.i][enter.j + 1] == '0') 
      {
        //check right, max = array reference for columns
        Position right = new Position(enter.i, enter.j + 1, ' ', enter);
        mazeQ.addLast(right);
        
      }
      if( enter.i < maze.length-1 && maze[enter.i + 1][enter.j] == '0')
      {
        //check bottom, max = array reference for rows
        Position bottom = new Position(enter.i + 1, enter.j, ' ', enter);
        mazeQ.addLast(bottom);
      }
      if( enter.j > 0 && maze[enter.i][enter.j - 1] == '0') 
      {
        // check left as long as you're not in the zero column 
        Position left = new Position(enter.i, enter.j - 1, ' ', enter);
        mazeQ.addLast(left);
      }
      if( enter.i > 0 && maze[enter.i - 1][enter.j] == '0') 
      {
        // check top as long as you're not in the zero row 
        Position top = new Position(enter.i - 1, enter.j, ' ', enter);
        mazeQ.addLast(top);
      }
    }//while()
    return null;
  }//BFS->FIFO
  
  public static void printPath(Position [] path)
  {
    if(path != null) 
    {
      System.out.println("The following is a possible path through this maze: ");
      for(int i=0; i< path.length; i++)
      {
        if (i == 0){ 
        System.out.print("Enter Path: ");
        }
        System.out.print( "[" + path[i].i + " "+ path[i].j + "] "); 
        if ( i == path.length - 1)
        {
          System.out.print(" :Exit");
          }
      }
      System.out.println();
    }
    else 
      System.out.println("No path exists");
  }

  public static void printMaze(char[][] maze)
  {
    
    if(maze==null || maze[0] == null){
      System.err.println("*** Invalid maze array");
      return;
    }
    
    for(int i=0; i< maze.length; i++){
      for(int j = 0; j< maze[0].length; j++){
        System.out.print(maze[i][j] + " "); 
      }
      System.out.println();
    }
    
    System.out.println();
  }
  

  /**
   * Reads maze file in format:
   * N  -- size of maze
   * 0 1 0 1 0 1 -- space-separated 
   * @param filename
   * @return
   * @throws IOException
   */
  //reads first argument args[0]
  //save as text file and then copy where it's actually placed in the computer
  @SuppressWarnings("resource")
  public static char [][] readMaze(String filename) throws IOException
  {
    char [][] maze;
    Scanner scanner;
    try{
      scanner = new Scanner(new FileInputStream(filename));
    }
    catch(IOException ex){
      System.err.println("*** Invalid filename: " + filename);
      return null;
    }
    
    int N = scanner.nextInt();
    scanner.nextLine();
    maze = new char[N][N];
    int i=0;
    while(i < N && scanner.hasNext()){
      String line =  scanner.nextLine();
      String [] tokens = line.split("\\s+");
      int j = 0;
      for (; j< tokens.length; j++){
        maze[i][j] = tokens[j].charAt(0);
      }
      if(j!=N){
        System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
        return null;
      }
      i++;
    }
    if(i!=N){
      System.err.println("*** Invalid file: has wrong number of rows: " + i);
      return null;
    }
    return maze;
  }//readMaze

  public static void main(String[] args) throws IOException 
  {
    if(args.length<1){
      System.err.println("***Usage: java PathFinder maze_file");
      System.exit(-1);
    }
    //maze used in "stack"
    char [][] maze;
    maze = readMaze(args[0]);
    printMaze(maze);
    Position [] path = stackSearch(maze);
    System.out.println("stackSearch Solution:");
    printPath(path);
    printMaze(maze);
    //maze used in "queue" 
    char [][] maze2 = readMaze(args[0]);
    path = queueSearch(maze2);
    System.out.println("queueSearch Solution:");
    printPath(path);
    printMaze(maze2);
  }//main
  
}//PathFinder
