

class Solution {


  /*
  Uses Runner Technique
  Make a pointer move k positions (our runner pointer). 
  Now have a pointer start from the beginning. 
  Move both nodes now, but make the conditional dependent on the runner pointer.
  When the runner pointer hits null, the other pointer should be in the kth to last node.
   */
  public static Node getKToLast(Node head, int kthToLast) {

    Node ptr = head;
    Node runner = head;
    int index = 0;
    while(runner != null && index < kthToLast) {
      index++;
      runner = runner.next;
    }
    
    while(runner != null) {
      runner = runner.next;
      ptr = ptr.next;
    }
    return ptr;
  }


  /*
    Bad Solution (Brute-Force) Solution!
   */
  public static Node getKthToLast(Node head, int kth) {
    Node ptr = head;
    int size = 0;
    while(ptr != null) {
      size++; 
      ptr = ptr.next;
    }

    ptr = head;
    int atNode = size - 1;
    while(atNode >= 0) {
      if(atNode == kth) {
        return ptr;
      }
      ptr = ptr.next;
      atNode--;
    }
    return null;
  }



  public static void main(String[] args) {
    Node head = new Node(1);
    Node ptr = head;
    for(int i : new int[]{2, 3, 4, 5, 6, 7, 8}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    //size = 9 (null is the last node!!!!!)
    ptr = head;
    //ans = 1
    System.out.println("7th to last is = " + getKToLast(ptr, 8).data);
    //ans = 8
    System.out.println("0th to last is = " + getKToLast(ptr, 1).data);
    //ans = 7
    System.out.println("1th to last is = " + getKToLast(ptr, 2).data);



  }
}

class Node {
  int data; 
  Node next; 
  public Node(int data) {
    this.data = data;
  }
}