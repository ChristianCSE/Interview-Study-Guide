

class Solution {

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
    //size = 8
    ptr = head;
    //ans = 1
    System.out.println("7th to last is = " + getKthToLast(ptr, 7).data);
    //ans = 8
    System.out.println("0th to last is = " + getKthToLast(ptr, 0).data);
    //ans = 7
    System.out.println("1th to last is = " + getKthToLast(ptr, 1).data);



  }
}

class Node {
  int data; 
  Node next; 
  public Node(int data) {
    this.data = data;
  }
}