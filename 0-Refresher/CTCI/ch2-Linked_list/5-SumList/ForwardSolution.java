/*
POINTS TO TAKE FROM PROBLEM:
-> Partial Sum Data Structure: Maintain Sum So Far
-> Recursion: Conserve references to previous Nodes
-> Head Insertion: Quick update to head of linked list
 */


class ForwardSolution {

  /*
  MEDIUM
  [6]->[1]->[7]->null
  [2]->[9]->[5]->null
  return: [9]->[1]->[2]->null
   */
  public static Node getForwardSum(Node listOne, Node listTwo) {
    int lengthOne = getLength(listOne);
    int lengthTwo = getLength(listTwo);
    listOne = padding(listOne, lengthTwo-lengthOne);
    listTwo = padding(listTwo, lengthOne-lengthTwo);
    PartialSum totalSum = getListTotalSum(listOne, listTwo);
    
    //is there a carryover still active?
    if(totalSum.carryOver != 0) {
      Node summed = insertNewHead(totalSum.LLsum, totalSum.carryOver);
      totalSum.LLsum = summed; //could just return summed!
    }
    return totalSum.LLsum;
  }


  /* 
  Doing this recursively let's us maintain the reference to our previous nodes.
  Remember, this is a singly linked list => no quick reference to prev!
  */
  public static PartialSum getListTotalSum(Node listOne, Node  listTwo) {
    if(listOne == null) {
      //we've reached the end of our list! Start our partial sum now!
      PartialSum sum = new PartialSum();
      return sum;
    }
    PartialSum builtUpSum = getListTotalSum(listOne.next, listTwo.next); //we conserve references to prev NODES
    int totalSum = builtUpSum.carryOver + listOne.data + listTwo.data; //sum of index col!
    //we need to store this sum!
    Node summed = insertNewHead(builtUpSum.LLsum, totalSum%10);
    builtUpSum.LLsum = summed; //update ongoing sum
    builtUpSum.carryOver = totalSum/10;
    return builtUpSum;
  }

  /*
  update the head (leftmost digit) of our sum [1]->[2], 3 => [3]->[1]->[2]
   */
  public static Node insertNewHead(Node head, int sum) {
    Node summed = new Node(sum);
    if(head!=null) {
      summed.next = head;
    }
    return summed;
  }


  public static void quickPrint(Node head) {
    while(head!=null){
      System.out.println(head.data);
      head = head.next;
    }
  }

  public static Node padding(Node list, int padding) {
    if(padding <= 0) return list; //either same length or already longer
    while(padding > 0) {
      padding--;
      Node zeroPadding = new Node(0);
      zeroPadding.next = list;
      list = zeroPadding; //make it the new head
    }
    return list;
  }


  public static int getLength(Node head) {
    int size = 0;
    //doesn't influence original ptr
    while(head!=null) {
      head = head.next;
      size++;
    }
    return size;
  }

  public static void doForwardSum() {
    Node listOne = new Node(6);
    Node ptr = listOne;
    for(int i: new int[]{1, 2}){
      ptr.next= new Node(i);
      ptr = ptr.next;
    }
    Node listTwo = new Node(5);
    ptr = listTwo;
    for(int i: new int[]{2}) {
      ptr.next = new Node(i);
      ptr = ptr.next;
    }
     ptr = getForwardSum(listOne, listTwo);
    while(ptr!= null) {
      System.out.print(ptr.data + " ");
      ptr = ptr.next;
    }
  }

  public static void main(String[] args) {
    doForwardSum();
  }
}

/*
We need a way to reference the currently built up sum so far!
 */
class PartialSum {
  int carryOver;
  Node LLsum;
}

class Node {
  int data; 
  Node next; 
  public Node(int data){
    this.data = data;
  }
}