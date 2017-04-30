import java.util.*; 

class tentative{

  /*============================================================
  You using a Stack (we use a Deque)
  And this problem is similar to Reverse Polish Notation
  ==============================================================*/
  public static void validBrackets(String expression)
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
    //is this a closing bracket? If so our
    //stack should have an equivalent open bracket. 
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
      continue; 
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
     validBrackets(attempt);
     validBrackets(attempt2);
     validBrackets(attempt3);
  }
}
