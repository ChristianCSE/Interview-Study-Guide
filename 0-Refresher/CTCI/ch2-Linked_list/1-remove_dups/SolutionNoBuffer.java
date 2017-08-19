class SolutionNoBuffer {


  /*
  No buffer!
   */
  public static void removedDuplicates(Node head) {
    Node ptr = head; //head is just a pointer!
    while(ptr != null) {
      Node ahead = ptr;
      while(ahead.next != null) {
        if(ahead.next.data == ptr.data) {
          //move the .next reference to the next node
          //don't change the pointer itself, since this new .next could be a dupe
          ahead.next = ahead.next.next;
        } else {
          ahead = ahead.next;
        }
      }
      ptr = ptr.next; //our next node search
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
    Node ptrCheck = head;
    while(ptrCheck!=null) {
      System.out.println(ptrCheck.data);
      ptrCheck = ptrCheck.next;
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