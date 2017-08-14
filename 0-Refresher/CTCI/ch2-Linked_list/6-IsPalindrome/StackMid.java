/*
Space complexity: O(N/2) [uses stack to store first half]
Run time: O(N) [traverse entire LL]
 */

import java.util.*;

class StackMid {


  /*
  Need to be considerate about even lengths 
   */
  public static boolean isPalindrome(Node head) {
    Deque<Integer> stack = new ArrayDeque<>();

    //start at head for both
    Node ptr = head;
    Node runner = head;
    //we jump by 2's so make sure we have a .next ref something!
    while(runner!=null && runner.next != null) {
      stack.push(ptr.data);
      ptr = ptr.next;
      runner = runner.next.next; 
    }

    //an odd LL will have runner end on non null (runner.next == null)
    //that means ptr will be on the mid point (we don't care for that)
    if(runner != null) {
      ptr = ptr.next; //skip midpoint since we start our comparison on the latter half 
    }

    //now pop from the list and run through the rest of the list!
    
    while(ptr != null) {
      if(stack.pop() != ptr.data) {
        return false;
      }
      ptr = ptr.next;
    }
    
    return true;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    Node ptr = head;
    int[] pair = new int[]{0, 0, 1, 0, 0, 1}; //true 
    //int[] pair = new int[]{0, 0, 1, 0, 0, 0}; //false
    for(int i : pair) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    
    ptr = head;
    System.out.println("1011001 is not palindrome => " + isPalindrome(ptr));
  }
}