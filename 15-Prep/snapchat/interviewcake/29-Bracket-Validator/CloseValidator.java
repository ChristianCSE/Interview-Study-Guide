import java.util.*; 
class CloseValidator {

  public static boolean validateClosing(String[] brackets){
    Map<String, String> map = new HashMap<>(); 
    map.put("}", "{");
    map.put(")", "(");
    map.put("]", "[");
    Deque<String> stack = new ArrayDeque<String>();
    int i = 0;
    stack.push(brackets[i]);
    
    for( i = 1; i < brackets.length; i++){
      String bracket = brackets[i]; //currently being pushed 
      if(map.containsKey(bracket)){ //is it a closing bracket
        String closing = map.get(bracket); //get what it should be closing 
        if(stack.peek() == null) {
          return false; 
        }
        //is it closing the matching opp
        String shouldMatch = stack.pop();
        if(!closing.equals(shouldMatch)) {
          return false;
        }
      }
      else {
        stack.push(bracket);
      }
    }
    //System.out.println(stack.peek());
    return (stack.peek() == null) ?  true : false;
  }

  public static void main(String[] args) {
    boolean res = validateClosing(new String[]{"{","{","}","}","(",")"});
    System.out.println(res);
    res = validateClosing(new String[]{"{","{","}","}","(",")", "("});
    System.out.println(res);
    res = validateClosing(new String[]{"{","{","]","}","(","("});
    System.out.println(res);
    res = validateClosing(new String[]{"{","{","{","{","{","{"});
    System.out.println(res);
    res = validateClosing(new String[]{"(",")","(",")","{","}"});
    System.out.println(res);

    res = validateClosing(new String[]{"{", "[", "(", "]", ")", "}"});
    System.out.println("should be false=> "+ res);
  }
} 