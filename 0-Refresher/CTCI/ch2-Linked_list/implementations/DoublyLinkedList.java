


class DoublyLinkedList {



  public static Node removeNode(Node head, int val) {
    if(head.data == val) {
      head = head.next;
      head.prev = null;
      return head;
    }
    Node ptr = head;
    ptr = ptr.next;
    while(ptr != null) {
      if(ptr.data == val) {
        ptr.next.prev = ptr.prev; //these are actual nodes
        ptr.prev.next = ptr.next; //these are actual nodes

        ptr.next = null; //what i point to 
        ptr.prev = null; //what i point to 
        return head;
      }
      ptr = ptr.next;
    }
    return head;
  }

  public static Node makeDLL(int size) {
    Node node = new Node(0);
    node.prev = null;
    Node n = node;
    for(int i = 1; i < size; i++){
      n.next = new Node(i);
      n.next.prev = n;
      n = n.next;
    }
    n.next = null;
    return node;
  }

  public static void main(String[] args) {
    Node head = makeDLL(10);
    Node ptr = removeNode(head, 8);
    while(ptr != null) {
      if(ptr.prev == null)
        System.out.println("NULL" + "<=>" + ptr.data + "<=>" + ptr.next.data);
      else 
        if(ptr.next != null) System.out.println(ptr.prev.data + "<=>" + ptr.data + "<=>" + ptr.next.data);
        else System.out.println(ptr.prev.data + "<=>" + ptr.data);
      ptr = ptr.next;
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