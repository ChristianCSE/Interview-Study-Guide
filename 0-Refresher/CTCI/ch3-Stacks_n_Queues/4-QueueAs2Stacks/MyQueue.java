/*
NOTE: Only transfer when user requests peek() or poll()
ONLY transfer if pseudo_queue is empty.
If it's not empty, then we still have elements ahead of our newer 
 */
import java.util.*;

/*
Hide the fact that they are stacks => use poll() & add() naming
 */
class MyQueue {

  Deque<Integer> stack;
  // constrained to push() & pop()
  Deque<Integer> pseudo_queue;
  public MyQueue() {
    stack = new ArrayDeque<>();
    pseudo_queue = new ArrayDeque<>();
  }

  /*
  only relevant to stack
   */
  public void add(int data) {
    stack.push(data);
  }

  public void shiftToQueue(){
    //only shift if pseudo_queue is empty 
    //else you will be pushing newer elements on top of the old
    //already stored!
    if(pseudo_queue.isEmpty()) {
      //pop all our elements from our stack into our queue
      //we should result with queue ordering in our stack
      while(!stack.isEmpty()) {
        pseudo_queue.push(stack.pop());
      }
    }
  }

  //we want the oldest element not the newest!
  public int poll(){
    shiftToQueue();
    return pseudo_queue.pop(); //the head of or pseudo 
  }

  public int peek(){
    shiftToQueue();
    //remember peek() is same for both,
    // except we are manipulating the head in stacks,
    // while maintaing our original head in queue
    return pseudo_queue.peek(); 
  }

}