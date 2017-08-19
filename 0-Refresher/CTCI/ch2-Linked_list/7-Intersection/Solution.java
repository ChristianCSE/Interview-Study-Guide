


class Solution {


  //intersection is based on reference not on value!
  
  //Traverse through Both Linked Lists 
  //
  public static Node isIntersecting(Node listOne, Node listTwo) {
    int lenOne = LLlen(listOne);
    int lenTwo = LLlen(listTwo);

    //we do this in the case that diff lens

    //move ptr by difference offset (if not lt => don't move at all)
    while(lenOne > lenTwo) {
      listOne = listOne.next; 
      lenOne--;
    }

    //only one of these will need to move (we just don't know which)
    //could do boolean and flip them larger/smaller
    while(lenTwo > lenOne) {
      listTwo = listTwo.next;
      lenTwo--;
    }

    while(listTwo != listOne) {
      System.out.println(listTwo.data + "   " + listOne.data);
      listTwo = listTwo.next;
      listOne = listOne.next;
    }

    return listTwo; //returns null if don't intersect on actual node 
  }

  /*
  O(N)
   */
  public static int LLlen(Node head) {
    int size = 0;
    while(head!=null) {
      head = head.next;
      size++;
    }
    return size;
  }

  public static void main(String[] args) {
    Node intersect = new Node(100);


    Node listOne = new Node(10);
    Node ptr = listOne;
    for(int i : new int[]{1, 2, 3, 4}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr.next = intersect;
    Node listTwo = new Node(10);
    ptr = listTwo;
    for(int i : new int[]{12, 21}){
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr.next = intersect;
    System.out.println(isIntersecting(listOne, listTwo).data);//null


  }
}

class Node {
  int data; 
  Node next; 
  public Node(int data) {
    this.data = data; 
  }
}