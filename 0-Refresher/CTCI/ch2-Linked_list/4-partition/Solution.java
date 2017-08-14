


class Solution {


  public static Node partition(Node head, int x) {
    
    
    //two individual linked lists
    //can't do dual pointers, since singly ll
    Node before = null;
    Node after = null;

    while(head != null) {
      //save next reference
      Node next = head.next;
      if(head.data < x) {
        //make next point to our head (lost ref to old LL) 
        head.next = before; 
        //move our head to newly added node
        before = head; 
      } else {
        //same logic
        head.next = after;
        after = head; 
      }
      head = next;
    }

    //merge them (first check if anything to merge) 
    if(before == null) {
      return after;
    }

    Node ptr = before;
    //you want the pointer right before you hit null
    //you are overwritting the null reference 
    //[] -> [] -> null (stop on the first to last node not on the null)
    while(ptr.next != null) {
      ptr = ptr.next;
    }
    //overwrite
    ptr.next = after;
    return before;
  }

  public static void main(String[] args) {
    //3, 1, 5, 7, 8, 2, 9, 1
    //x = 5
    //3, 1, 2, 1, 5, 7, 8, 9
    Node head = new Node(3);
    Node ptr = head;
    for(int i: new int[]{1, 5, 7, 8, 2, 9, 1}){
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr = head;
    Node newList = partition(ptr, 5);
    //Node ptr = newList;
    while(newList != null) {
      System.out.println(newList.data);
      newList = newList.next;
    }

  }

}


class Node {
  int data; 
  Node next; 

  public Node(int data){
    this.data = data; 
  }
}