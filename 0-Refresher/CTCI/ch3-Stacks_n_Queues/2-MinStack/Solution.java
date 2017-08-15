
import java.util.*;

class Solution {

  public static void main(String[] args) throws Exception{
    MinStack stack = new MinStack();
    stack.add(10);
    System.out.println("MIN SO FAR (should be 10) => " + stack.min());
    stack.add(100);
    System.out.println("MIN SO FAR (should be 10) => " + stack.min());
    stack.add(-1);
    System.out.println("MIN SO FAR (should be -1) => " + stack.min());
    stack.add(-10);
    System.out.println("MIN SO FAR (should be -10) => " + stack.min());
    stack.add(1000);
    System.out.println("MIN SO FAR => (should be -10) => " + stack.min());
    stack.pop();
    System.out.println("MIN SO FAR => (should be -10) =>" + stack.min());
    stack.pop();
    System.out.println("MIN SO FAR => (should be -1) =>" + stack.min());

    System.out.println(stack.stack);
    System.out.println(stack.minSoFar);
  }

}


/*
Uses an auxillary Stack: 
-> 0(N) space for aux stack & O(N) space for regular stack
-> O(1) add, remove, min retrieval/update
 */
class MinStack {
  Deque<Integer> stack; 
  Deque<Integer> minSoFar;
  public MinStack(){
    stack = new ArrayDeque<>();
    minSoFar = new ArrayDeque<>();
  }
  public void add(int element) {
    stack.push(element);
    if(minSoFar.isEmpty()) {
      minSoFar.push(element);
    } else {
      //is this min smaller than the min so far?
      int min = Math.min(minSoFar.peek(), element);
      minSoFar.push(min);
    }
  }

  public int pop() throws StackEmptyException{
    if(!minSoFar.isEmpty()){
      minSoFar.pop();
      return stack.pop();
    }
    System.out.println("STACK IS EMPTY NOTHING TO POP!");
    throw new StackEmptyException();
  }

  public int min() throws StackEmptyException{
    if(!minSoFar.isEmpty()){
      return minSoFar.peek();
    }
    System.out.println("STACK IS EMPTY SO THERE IS NO MIN!");
    throw new StackEmptyException();
  }
}


class StackEmptyException extends Exception{}