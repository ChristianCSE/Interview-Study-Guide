
/*
1->1->1->2->2->2
Slice the LL in half and merge every other node
1->2->1->1->2->1
CURRENTLY: CYCLE! There is some error in my merging method!
 */

class Weaving {


  public static Node weaveThem(Node head) {
    Node ptr1 = head.next;
    Node ptr2 = head;
    int counter = 0;
    //first check if there is even another next
    while(ptr1.next != null && ptr1.next.next != null) {
      ptr1 = ptr1.next.next;
      ptr2 = ptr2.next;
      counter++;
    }
    //ptr is pointing to the last 1 [before change]
    ptr2 = ptr2.next; //now at 2
    System.out.println(ptr2.data);

    ptr1 = head; //to the back 
    System.out.println(ptr1.data);

    Node ptr1_next; 
    Node ptr2_next; 
    System.out.println(counter);
    //merge 
    while(ptr1 != null) {
      //save their next references
      ptr1_next = ptr1.next;
      ptr2_next = ptr2.next;


      //back points to front and front points to back's next node
      ptr1.next = ptr2;
      ptr2.next = ptr1_next;

      //move pointers to (old) next nodes (maintain referecences)
      ptr1 = ptr1_next;
      ptr2 = ptr2_next;
    }

    ptr1 = head;

    //something is wrong here 
    Node printPoint = ptr1;
    while(printPoint != null) {
      System.out.println(printPoint.data);
      printPoint = printPoint.next;
    }

    return null;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    Node ptr = head;
    for(int i = 2; i <= 10; i++) {
      if(i <= 5)
        ptr.next = new Node(1);
      else
        ptr.next = new Node(2);
      ptr = ptr.next;
    }
    ptr = head;
    while(ptr != null) {
      //System.out.println(ptr.data);
      ptr = ptr.next;
    }
    weaveThem(head);
  }

}

class Node {
  int data;
  Node next;
  public Node(int data) {
    this.data = data;
  }
}