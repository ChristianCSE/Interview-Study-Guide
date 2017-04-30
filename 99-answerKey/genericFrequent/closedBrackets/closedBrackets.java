import java.util.*; 

/*============================================================
  You using a Stack (we use a Deque)
  And this problem is similar to Reverse Polish Notation
  ==============================================================*/
class closedBrackets{
  
  public static void validExpression(String expression)
  {

  String[] bracketExpr = expression.split("");
  boolean wire = true; 
  int i, len = bracketExpr.length; 

  Deque<String> wantClose = new ArrayDeque<>();  
    
  List<String> openBracks = new ArrayList<>(3);
  openBracks.addAll( Arrays.asList( "{", "[", "(" ) );
  
  List<String> closedBracks = new ArrayList<>(3);
  closedBracks.addAll( Arrays.asList( "}", "]", ")" ) ); 

  pairThem: for(i = 0; i < len; i++)
  {
    String xBracket = bracketExpr[i];
    if(openBracks.contains(xBracket))
    {
      wantClose.addFirst(xBracket);
    }
    else if(closedBracks.contains(xBracket))
    {

      String catchOpen = wantClose.pollFirst();
      if(catchOpen == null)
      {
        wire = false; 
        break pairThem;
      }
      //now pair it with current
        switch(catchOpen)
        {
          case "{": 
            if(!xBracket.equals("}"))
            {
              wire = false; 
              break pairThem;
            }
          break; 
         case "(":
            if(!xBracket.equals(")"))
            {
              wire = false; 
              break pairThem;
            }
          break;         
         case  "[":
            if(!xBracket.equals("]"))
            {
              wire = false; 
              break pairThem;
            }
          break;         
        }//switch
    }
    else{
      //do nothing
      }
  }//for loop

  if(wire)
  {
    System.out.println(expression + " is valid.");
  }
  else
  {
    System.out.println(expression + " is not a valid expression!");
  }
}

  public static void main(String[] args)
  {
     String attempt = "{ [ } ( ) ] )";
     String attempt2 = "{ [ ] } ( ) () )";
     String attempt3 = "{aaaa[dsadsad]}daadssad(dadsasd)()";
     validExpression(attempt);
     validExpression(attempt2);
     validExpression(attempt3);
  }

}
