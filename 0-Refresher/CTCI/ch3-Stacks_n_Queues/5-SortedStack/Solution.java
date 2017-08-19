import java.util.*;


class Solution {


  public static void main(String[] args) throws Exception{
    SortedStack stack = new SortedStack();
    stack.add(10);
    stack.add(20);
    stack.add(3);
    stack.add(13);
    stack.add(200);
    stack.add(15);
    System.out.println(stack.sortedStack);
    stack.pop();
    System.out.println(stack.sortedStack);
    System.out.println(stack.peek());
    stack.add(1);
    System.out.println(stack.sortedStack);
  }
}


class SortedStack{
  Deque<Integer> sortedStack;
  Deque<Integer> auxStack;

  public SortedStack() {
    sortedStack = new ArrayDeque<>();
    auxStack = new ArrayDeque<>();
  }


  public void add(int data){
    if(sortedStack.isEmpty()){
      sortedStack.push(data);
      return;
    }
    boolean inserted = false; 
    //keep going until you insert
    while(!inserted){
      //TWO CASES: Inside the stack OR At the end of the stack
      if(!sortedStack.isEmpty() && sortedStack.peek() < data) {
        //keep going
        auxStack.push(sortedStack.pop());
      } else {
        sortedStack.push(data); 
        inserted = true;
      }
    }
    //now reinsert all the elements less than data
    while(!auxStack.isEmpty()){
      sortedStack.push(auxStack.pop());
    }
  }

  public int pop() throws EmptyException{
    if(sortedStack.isEmpty()) throw new EmptyException();
    return sortedStack.pop();
  }

  public int peek(){
    return sortedStack.peek();
  }

}

class EmptyException extends Exception{

}