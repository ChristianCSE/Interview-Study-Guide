/*
NOT A STACK THAT MAINTAINS SORTING
RATHER, WE WANT TO SORT A PRE-FILLED STACK 
 */


import java.util.*;
class ActualSolution {

  public static void sort(Deque<Integer> stack) {
    //maintains descending ordering
    Deque<Integer> aux = new ArrayDeque<>(); 
    while(!stack.isEmpty()){
      int candidate = stack.pop();
      //want to introduce candidate below all higher elements
      while(!aux.isEmpty() && aux.peek() > candidate) {
        stack.push(aux.pop());
      }
      //insert ourselves here
      aux.push(candidate);
    }
    while(!aux.isEmpty()) {
      stack.push(aux.pop());
    }
  }

  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(10);
    stack.push(1);
    stack.push(3);
    stack.push(300);
    stack.push(13);
    System.out.println(stack);
    sort(stack);
    System.out.println(stack);
  }
}

