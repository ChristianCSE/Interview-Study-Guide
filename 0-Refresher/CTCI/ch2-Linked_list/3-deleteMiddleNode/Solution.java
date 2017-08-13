


class Solution {


  /*
  Clone the node after the mid node, 
  since the mid node is a clone of the upcoming node, we can drop the upcoming node.
   */
  public static void removeMid(Node mid) {
    if(mid == null || mid.next == null) return;

    mid.data = mid.next.data; //copy the data of the upcoming node
    mid.next = mid.next.next; //since we cloned the data we can drop the next node

  }


  public static void main(String[] args) {
    Node head = new Node(0);
    Node ptr = head;
    for(int i: new int[]{1, 2, 3, 4, 5, 6}){
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr = head;
    int i = 0;
    while(i < 3) {
      i++;
      ptr = ptr.next;
    }
    removeMid(ptr);
    ptr = head;
    while(ptr != null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }
  }
}

class Node {
  int data; 
  Node next; 

  public Node(int data) {
    this.data = data; 
  }
}