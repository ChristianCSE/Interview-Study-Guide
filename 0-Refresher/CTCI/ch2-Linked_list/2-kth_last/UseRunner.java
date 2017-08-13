


class UseRunner {


  public static Node getKthNode(Node head, int kthToLast) {
    Node ptr = head;
    Node ptr2 = head;
    for(int i = 0; i < kthToLast; i++) {
      if(ptr == null) return null;
      ptr = ptr.next;
    }
    while(ptr != null) {
      ptr = ptr.next;
      ptr2 = ptr2.next;
    }

    return ptr2;
  }


  public static void main(String[] args) {
    Node head = new Node(0);
    Node ptr = head;
    for(int i : new int[]{1, 2, 3, 4, 5, 6, 7}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr = head;

    System.out.println(getKthNode(ptr, 2).data);
  }
}



class Node {
  int data;
  Node next; 
  public Node(int data) {
    this.data = data;
  }
}