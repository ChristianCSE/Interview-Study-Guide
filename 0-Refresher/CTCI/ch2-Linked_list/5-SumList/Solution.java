



class Solution {


  /*
  EASY
  [7]->[1]->[6]->null | 617
  [5]->[9]->[2]->null | 295 = 912
  return: [2]->[1]->[9]-> null
  Assuming same length (else have to iterate through both once to know length)
   */
  public static Node getBackwardsSum(Node listOne, Node listTwo) {
    if(listOne == null) return null;
    int totalSum = listOne.data + listTwo.data;
    Node summed = new Node(totalSum%10);
    int carryOver = totalSum/10;
    listOne = listOne.next;
    listTwo = listTwo.next;
    Node ptr = summed;
    while(listOne != null) {
      totalSum = listOne.data + listTwo.data + carryOver;
      ptr.next = new Node(totalSum%10);
      carryOver = totalSum/10;
      listOne = listOne.next;
      listTwo = listTwo.next;
      ptr = ptr.next; 
    }
    if(carryOver > 0) {
      ptr.next = new Node(carryOver);
    }
    return summed;
  }

  /*
  MEDIUM
  [6]->[1]->[7]->null
  [2]->[9]->[5]->null
  return: [9]->[1]->[2]->null
   */
  public static Node getForwardSum(Node listOne, Node listTwo) {

    return null;
  }


  public static void main(String[] args) {
    Node listOne = new Node(7);
    Node ptr = listOne;
    for(int i : new int[]{1, 6}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }

    Node listTwo = new Node(5);
    ptr = listTwo;
    for(int i : new int[]{9, 2}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }

    ptr = getBackwardsSum(listOne, listTwo);
    while(ptr!=null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
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