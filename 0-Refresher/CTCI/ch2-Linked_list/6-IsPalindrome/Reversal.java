/*
Simple Solution: 
Just reverse the entire list O(N) space & O(N) time
And then compare it with the original O(N) time
O(2N) => O(N) time & O(N) space
 */


class Reversal {

  //you are actually breaking the .next reference; hence, 
  //prev ordering is destroyed
  //how is it changing head ref pointer????
  // public static Node reverseit(Node head) {
  //   Node flipped = null;
  //   Node next = null;
  //   Node ptr = head;
  //   while(ptr != null) {
  //     next = ptr.next; 
  //     ptr.next = flipped; //make it point to flipped's ptr
  //     flipped = ptr; 
  //     ptr = next;
  //     System.out.println("p");
  //   }
  //   ptr = head;
  //   head = ptr;
  //   return flipped;
  // }

  //we want to maintain order of prev list we need to actually clone the nodes
  //rather than just changing refernces
  
  public static Node reverseit(Node head) {
    Node flipped = null;
    while(head != null) {
      Node clone = new Node(head.data);
      clone.next = flipped;
      flipped = clone;
      head = head.next;
    }
    return flipped;
  }

  public static boolean isPalindrome(Node head) {
    Node ptr = reverseit(head);
    while(head != null) {
      System.out.println(head.data + "    " + ptr.data );
      if(head.data != ptr.data) {
        return false;
      }
      head = head.next;
      ptr = ptr.next;
    }
    return true;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    Node ptr = head;
    for(int i : new int[]{0, 1, 1, 0, 0, 1}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    
    ptr = head;
    System.out.println(isPalindrome(ptr));
    // ptr = reverseit(ptr); // this actual changes head reference
    // while(ptr!=null) {
    //   System.out.println(" " + ptr.data);
    //   ptr = ptr.next;
    // }

  }
}

class Node {
  int data;
  Node next; 
  public Node(int data) {
    this.data = data;
  }
}