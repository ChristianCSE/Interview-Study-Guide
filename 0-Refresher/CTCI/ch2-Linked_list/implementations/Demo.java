

class Demo {



  public static Node doublyDeleteNode(Node head, int val) {
    if(head.data == val) {
      head = head.next;
      head.prev = null;
      return head;
    }
    Node n = head;
    n = n.next;
    while(n != null) {
      if(n.data == val) {
        n.prev.next = n.next; 
        if(n.next != null)
          n.next.prev = n.prev; 
        n.next = null;
        n.prev = null;
        return head;
      }
      System.out.println("NOPE: " + n.data);
      n = n.next;
    }
    return head;
  }

  public static void main(String[] args) {
    Node node = new Node(10);
    node.prev = null;
    Node n = node;
    for(int i : new int[]{11, 12, 13, 14, 15, 16, 17}){
      n.next = new Node(i);
      n.next.prev = n;
      n = n.next;
    }
    System.out.println(n.data);
    n.next = null;
    System.out.println(n.data);
    n = node;
    n = doublyDeleteNode(n, 10);
    // n = node;
    System.out.println();
    System.out.println(n.data);
    while(n.next != null) {
      if(n.prev == null) {
        System.out.println( "null" + " = >" + n.data + " => " + n.next.data + " => ");
      }
      else {
        System.out.println( n.prev.data + " <= >" +n.data+  " <=>" + n.next.data + " => ");
      }
      n = n.next;
    }
  }

}


class Node {
  int data; 
  Node next; 
  Node prev;

  public Node(int data) {
    this.data = data;
  }

}