import java.util.*;
class RevPolish{


 public int evalRPN(String[] tokens) {
  int len = tokens.length;
  Deque<String> eq = new ArrayDeque<>();
  doMath("", "a", "b");
  List<String> operators = Arrays.asList( new String[]{"/","-","*", "+"} );
  eq.push(tokens[0]);
  for(int i=1; i< len;i++){
   String curr = tokens[i];
   if(operators.contains(curr)){
    eq.push(doMath(curr, eq.poll(), eq.poll()) + "");
   } else {
    eq.push(curr);
   }
  }
  System.out.println(eq.peek());
  return Integer.parseInt(eq.poll());
 }

 public int doMath(String op, String b, String a){
  switch(op){
  case ("-"): return (Integer.parseInt(a))-(Integer.parseInt(b));
  case ("+"): return (Integer.parseInt(a))+(Integer.parseInt(b));
  case ("/"): return (Integer.parseInt(a))/(Integer.parseInt(b));
  case ("*"): return (Integer.parseInt(a))*(Integer.parseInt(b));
  }
  return 0;
 }



  public static void main(String[] args){
   RevPolish call = new RevPolish();
   call.evalRPN(new String[]{"2", "1", "+", "3", "*"});
   call.evalRPN(new String[]{"4", "13", "5", "/", "+"});
   //3 4 − 5 + => 3 − 4 + 5
   // ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  //["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  }
}