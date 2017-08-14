

class Understanding {


  public static Node partition(Node node, int x) {
    
    return null;
  }

  public static void main(String[] args) {

    //3, 1, 5, 7, 8, 2, 9, 1
    //x = 5
    //3, 1, 2, 1, 5, 7, 8, 9
    Node head = new Node(3);
    Node ptr = head;
    for(int i: new int[]{}){
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr = head;
    partition(ptr, 5);
  }
}


class Node {

  int data; 
  Node next; 

  public Node(int data) {
    this.data = data;
  }
}