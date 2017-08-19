/*
EASY: REAL PROBLEM IS WITHOUT A BUFFER
 */
import java.util.*;

class Solution {


  public static Node removedDuplicates(Node head) {

    Set<Integer> seen = new HashSet<>(); //buffer
    Node ptr = head;
    seen.add(ptr.data);
    
    while(ptr != null) {
      if(ptr.next != null) {
        if(seen.contains(ptr.next.data)){
          System.out.println("=>" + ptr.next.data);
          ptr.next = ptr.next.next; //point to the one after it
          ptr.next.next = null; //drop the node 
        } else {
          //just move on to next node
          seen.add(ptr.next.data);
          ptr = ptr.next;

        }
      } else {
        ptr = ptr.next;
      }
    }
    checkit(head);
    return null;
  }

  public static void checkit(Node head){
    Node ptr = head;
    while(ptr != null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }    
  }

  public static void main(String[] args) {
    Node head = new Node(2);
    Node ptr = head;
    //dupes = 1, 4, 5, 2
    
    for(int i: new int[]{1, 1, 3, 4, 5, 1, 4, 2, 5}){
      ptr.next = new Node(i);
      ptr = ptr.next; 
    }
    //final form = 2, 1, 3, 4, 5
    //checkit(head);
    removedDuplicates(head);
  }
}

class Node {
  Node next;
  int data;
  public Node(int data){
    this.data = data;
  }

}