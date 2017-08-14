
class Solution {

  /*
  EASY
  [7]->[1]->[6]->null | 617
  [5]->[9]->[2]->null | 295 = 912
  return: [2]->[1]->[9]-> null
  DO NOT ASSUME SAME LENGTHS
   */
  public static Node getBackwardsSum(Node listOne, Node listTwo) {
    if(listOne == null) return null;
    int totalSum = listOne.data + listTwo.data;
    Node summed = new Node(totalSum%10);
    int carryOver = totalSum/10;
    listOne = listOne.next;
    listTwo = listTwo.next;
    Node ptr = summed;

    while(listOne != null || listTwo != null) {
      int oneNumber = (listOne==null) ? 0 : listOne.data;
      int twoNumber = (listTwo==null) ? 0 : listTwo.data;
      totalSum = oneNumber + twoNumber + carryOver;
      ptr.next = new Node(totalSum%10);
      carryOver = totalSum/10;
      listOne = (listOne==null) ? null:listOne.next;
      listTwo = (listTwo== null) ? null:listTwo.next;
      ptr = ptr.next; 
    }
    if(carryOver > 0) {
      ptr.next = new Node(carryOver);
    }
    return summed;
  }

  public static void doBackwardSum(){
    Node listOne = new Node(7);
    Node ptr = listOne;
    for(int i : new int[]{1, 6}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
    ptr = listOne;
    Node listTwo = new Node(5);
    ptr = listTwo;
    for(int i : new int[]{1, 9}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }

    ptr = getBackwardsSum(listOne, listTwo);
    System.out.println("SUMMED UP ANSWER: ");
    while(ptr!=null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }
  }

  public static void main(String[] args) {
    doBackwardSum();
  }
}


class Node {
  int data;
  Node next; 

  public Node(int data){
    this.data = data;
  }
}