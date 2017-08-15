

import java.util.*;

class Notes {



  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    //push => make this the new head!
    //push (think of forcing in rather than adding in behind)
    stack.push(10);
    stack.push(20);
    stack.push(30);
    System.out.println("PEEK RETURNS HEAD (AKA 30) == " + stack.peek());
    System.out.println("POP RETURNS HEAD (AKA 30) == " + stack.pop());
    System.out.println("IS EMPTY == " + stack.isEmpty());

    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    System.out.println("PEEK RETURNS HEAD (AKA 10) == " + queue.peek());
    System.out.println("POLL RETURNS HEAD (AKA 10) == " + queue.poll()); //same as pop()
    System.out.println("IS EMPTY == " + queue.isEmpty());

  }
}