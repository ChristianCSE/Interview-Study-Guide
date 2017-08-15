/*
Runner Technique 
Reference Equality 

 */

class Solution {


  public static Node getLoopHead(Node head) {
    Node runner = head;
    Node ptr = head; 

    //they will eventually clash
    //they clash at K nodes away from the head of the loop!
    //where K = size of the LL that isn't part of the cycle
    //IOW, head of LL is also K distance from head of loop.
    while(runner != null && runner.next != null) {
      runner = runner.next.next;
      ptr = ptr.next; 
      if(runner == ptr) {
        break;
      }
    }
    //this LL doesn't have a cycle 
    if(runner == null || runner.next == null) return null;

    //move one pointer to the head
    //remember: head is also K nodes from the head of the loop. 
    ptr = head; 
    while(ptr != runner) {
      ptr = ptr.next;
      runner = runner.next;
    }

    return runner;
  }

  public static void main(String[] args) {
    //save ref to third node!
    Node head = new Node(0);
    Node ptr = head;
    Node cycleHead = null;
    for(int i : new int[]{1, 2, 3, 4, 5, 6}){
      Node container = new Node(i);
      ptr.next = container;
      if(i == 3) {
        cycleHead = container;
      }
      ptr = ptr.next;
    }
    ptr.next = cycleHead;
    ptr = head;
    System.out.println("HEAD OF LOOP IS THREE: => " + getLoopHead(ptr).data);
  }
}



class Node {
  int data; 
  Node next;

  public Node(int data) {
    this.data = data;
  }
}